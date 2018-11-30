package com.zgtong.web.account.service.impl;

import com.google.common.collect.Lists;
import com.zgtong.web.account.dao.*;
import com.zgtong.web.account.dataobject.AccountRightsDo;
import com.zgtong.web.account.dataobject.DepartmentDo;
import com.zgtong.web.account.dataobject.ManagerAccountDo;
import com.zgtong.web.account.dataobject.RightsDo;
import com.zgtong.web.account.domain.request.*;
import com.zgtong.web.account.domain.response.AccountVO;
import com.zgtong.web.account.domain.response.Response;
import com.zgtong.web.account.domain.response.RightsVo;
import com.zgtong.web.account.domain.response.UserRoleVO;
import com.zgtong.web.account.entity.AccountStatus;
import com.zgtong.web.account.entity.AccountType;
import com.zgtong.web.account.entity.Converter;
import com.zgtong.web.account.service.AccountService;
import com.zgtong.web.common.domain.PageObject;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.logger.annotation.AutoLogger;
import com.zgtong.web.utils.EncryptUtil;
import com.zgtong.web.utils.ValidationUtil;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class AccountServiceImpl implements AccountService {

    @Resource
    private ManagerAccountDao managerAccountDao;

    @Resource
    private RightsDao rightsDao;

    @Resource
    private AccountRightsDao accountRightsDao;

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Resource
    private TransactionTemplate transactionTemplate;


    @AutoLogger
    @Override
    public ServiceResponse<Void> add(AddUserReq addUserReq) {
        AccountVO accountVo     = addUserReq.getAccountVo();
        Long      currentUserId = addUserReq.getCurrentUserId();

        if (accountVo == null || ValidationUtil.containsNullOrEmpty(currentUserId,
                accountVo.getUserName(),
                accountVo.getPassword())
                ) {
            return Response.BIZE_PARAMS_EXCEPTIONE;
        }

        ManagerAccountDo currentUser = managerAccountDao.selectById(currentUserId,null);
        if (currentUser == null) {
            return Response.BIZE_USER_NOT_EXISTS;
        }


        ManagerAccountDo oldManagerAccountDo = managerAccountDao.selectByUserName(accountVo.getUserName(),null);
        if (oldManagerAccountDo != null) {
            return Response.BIZE_USERNAME_EXISTS;
        }
        accountVo.setType(AccountType.NORMAL.code);
        accountVo.setStatus(AccountStatus.NORMAL.code);
        ManagerAccountDo newManagerAccountDo = Converter.accountVo2Do(accountVo);

        if (ValidationUtil.isNullOrEmpty(accountVo.getRightsList())) {
            managerAccountDao.insert(newManagerAccountDo);
        } else {
            Boolean result = transactionTemplate.execute(new TransactionCallback<Boolean>() {

                @Override
                public Boolean doInTransaction(TransactionStatus transactionStatus) {
                    managerAccountDao.insert(newManagerAccountDo);
                    List<RightsVo> rightsVos = accountVo.getRightsList();
                    if (!ValidationUtil.isNullOrEmpty(rightsVos)) {
                        List<AccountRightsDo> accountRightsDoList = Lists.newArrayList();
                        for (RightsVo rightsVo : rightsVos) {
                            AccountRightsDo accountRightsDo = new AccountRightsDo();
                            accountRightsDo.setUserId(newManagerAccountDo.getId());
                            accountRightsDo.setRightsId(rightsVo.getId());
                            accountRightsDoList.add(accountRightsDo);
                        }
                        accountRightsDao.insert(accountRightsDoList);
                    }
                    return true;
                }
            });

            if (result == null) {
                return Response.SYSE;
            }
        }

        return Response.SUCCESS;
    }

    @AutoLogger
    @Override
    public ServiceResponse<Void> modify(ModifyUserInfoReq modifyUserInfoReq) {
        AccountVO accountVo     = modifyUserInfoReq.getAccountVo();
        Long      currentUserId = modifyUserInfoReq.getCurrentUserId();

        if (accountVo == null || ValidationUtil.containsNullOrEmpty(currentUserId, accountVo.getId())) {
            return Response.BIZE_PARAMS_EXCEPTIONE;
        }

        final ManagerAccountDo currentUser  = managerAccountDao.selectById(currentUserId,null);
        final ManagerAccountDo modifiedUser = managerAccountDao.selectById(accountVo.getId(),null);
        if (currentUser == null || modifiedUser == null) {
            return Response.BIZE_USER_NOT_EXISTS;
        }

        modifiedUser.setPassword(null);
        //加密用户密码
        if (StringUtils.isEmpty(accountVo.getPassword())) {
            modifiedUser.setPassword(EncryptUtil.encrypt(modifiedUser.getPassword()));
        }

        ManagerAccountDo managerAccountDo = Converter.accountVo2Do(accountVo);
        managerAccountDo.setStatus(AccountStatus.NORMAL.code);
        if (accountVo.getRightsList() == null) {
            managerAccountDao.update(managerAccountDo);
        } else {
            List<AccountRightsDo> accountRightsDoList = Lists.newArrayList();
            for (RightsVo rightsVo : accountVo.getRightsList()) {
                AccountRightsDo accountRightsDo = new AccountRightsDo();
                accountRightsDo.setUserId(modifiedUser.getId());
                accountRightsDo.setRightsId(rightsVo.getId());
                accountRightsDoList.add(accountRightsDo);
            }
            Boolean result = transactionTemplate.execute(new TransactionCallback<Boolean>() {

                @Override
                public Boolean doInTransaction(TransactionStatus transactionStatus) {
                    managerAccountDao.update(managerAccountDo);
                    accountRightsDao.deleteAccountRightsByUserId(modifiedUser.getId());
                    if (accountRightsDoList.size() > 0) {
                        accountRightsDao.insert(accountRightsDoList);
                    }
                    return true;
                }
            });
            if (result == null) {
                return Response.SYSE;
            }

        }
        return Response.SUCCESS;
    }


    @AutoLogger
    @Override
    public ServiceResponse<Void> remove(RemoveUserReq removeUserReq) {
        Long userId        = removeUserReq.getUserId();
        Long currentUserId = removeUserReq.getCurrentUserId();

        if (ValidationUtil.containsNullOrEmpty(userId, currentUserId)) {
            return Response.BIZE_PARAMS_EXCEPTIONE;
        }

        ManagerAccountDo currentUser = managerAccountDao.selectById(currentUserId,null);
        ManagerAccountDo deletedUser = managerAccountDao.selectById(userId,null);
        if (currentUser == null || deletedUser == null) {
            return Response.BIZE_USER_NOT_EXISTS;
        }
        Integer tempIsDelete = AccountStatus.NORMAL.code;
        if(removeUserReq.getIsDelete()==null || removeUserReq.getIsDelete()==true){
            tempIsDelete = AccountStatus.FROZEN.code;
        }
        Integer isDelete = tempIsDelete;

        Boolean result = transactionTemplate.execute(new TransactionCallback<Boolean>() {

            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                managerAccountDao.deleteById(userId,isDelete,removeUserReq.getCurrentUserId());
                return true;
            }
        });
        if (result == null) {
            return Response.SYSE;
        }

        return Response.SUCCESS;
    }


    @AutoLogger
    @Override
    public ServiceResponse<AccountVO> login(LoginReq loginReq) {

        if (ValidationUtil.containsNullOrEmpty(loginReq.getUsername(), loginReq.getPassword())) {
            return Response.BIZE_PARAMS_EXCEPTIONE;
        }

        ManagerAccountDo managerAccountDo = managerAccountDao.selectByUserName(loginReq.getUsername(),true);
        if (managerAccountDo == null || !Objects.equals(managerAccountDo.getPassword(),
                EncryptUtil.encrypt(loginReq.getPassword()))) {
            return Response.BIZE_LOGIN;
        }

        AccountVO accountVo = Converter.assembleAccountVo(managerAccountDo, null,false);

        return Response.build(Response.Entry.SUCCESS, accountVo);
    }


    @AutoLogger
    @Override
    public ServiceResponse<AccountVO> query(QueryUserInfoReq queryUserInfoReq) {
        Long userId        = queryUserInfoReq.getUserId();
        Long currentUserId = queryUserInfoReq.getCurrentUserId();

        String userName = queryUserInfoReq.getUserName();

        if (StringUtils.isEmpty(userId) && StringUtils.isEmpty(userName)) {
            return Response.BIZE_PARAMS_EXCEPTIONE;
        }


        ManagerAccountDo queryUser  ;

        if(!StringUtils.isEmpty(userId)){
            queryUser = managerAccountDao.selectById(userId,null);
        }else {
            queryUser = managerAccountDao.selectByUserName(userName,null);
        }

        ManagerAccountDo currentUser = managerAccountDao.selectById(currentUserId,null);

        if (currentUser == null || queryUser == null) {
            return Response.BIZE_USER_NOT_EXISTS;
        }

        List<RightsDo> rightsDos = rightsDao.selectByUserId(userId,null);

        AccountVO accountVo = Converter.assembleAccountVo(queryUser, rightsDos,queryUserInfoReq.getNeedPassword());

        return Response.build(Response.Entry.SUCCESS, accountVo);

    }

    @AutoLogger
    @Override
    public ServiceResponse<PageObject<AccountVO>> list(QueryUserListReq queryUserListReq) {
        Long currentUserId = queryUserListReq.getCurrentUserId();
        if (ValidationUtil.containsNullOrEmpty(currentUserId)) {
            return Response.BIZE_PARAMS_EXCEPTIONE;
        }
        ManagerAccountDo currentUser = managerAccountDao.selectById(currentUserId,null);
        if (currentUser == null) {
            return Response.BIZE_USER_NOT_EXISTS;
        }

        if (ValidationUtil.containsNullOrEmpty(queryUserListReq.getPhone())) {
            queryUserListReq.setPhone(null);
        }
        if (ValidationUtil.containsNullOrEmpty(queryUserListReq.getUserName())) {
            queryUserListReq.setUserName(null);
        }


        Integer departmentId = currentUser.getDepartmentId();
        if(departmentId==null){
            departmentId=-1;
        }

        if(currentUser.getType()!=null && currentUser.getType().intValue()==AccountType.ADMIN.code.intValue()) {
            departmentId=null;
        }
        List<ManagerAccountDo> users = managerAccountDao.select(queryUserListReq.getPhone(),queryUserListReq.getUserName(),departmentId,queryUserListReq.offset(),queryUserListReq.getPageSize());
        if(null != users && users.size()>0){
            for (ManagerAccountDo managerAccountDo:users){
                if(managerAccountDo.getDepartmentId() != null){
                    DepartmentDo departmentDo = new DepartmentDo();
                    departmentDo.setId(managerAccountDo.getDepartmentId());
                    departmentDo = departmentDao.departmentDetail(departmentDo);
                    if(departmentDo != null){
                        managerAccountDo.setDepartmentName(departmentDo.getName());
                    }
                }
            }
        }


        //**查询用户关联角色
        List<UserRoleVO> list = userRoleDao.findAccentRole();
        //** 组合数据
        for (int i=0;i<users.size();i++){
            List<UserRoleVO> userRole = getAccountRole(list,users.get(i).getId());
            users.get(i).setRoleList(userRole);
        }

        int totalCount = managerAccountDao.count(queryUserListReq.getPhone(),queryUserListReq.getUserName(),departmentId);
        PageObject pageObject = new PageObject();
        pageObject.setTotalNumber(totalCount);
        pageObject.setData(Converter.AccountDo2Vo(users));
        return Response.build(Response.Entry.SUCCESS,pageObject);
    }

    private  List<UserRoleVO> getAccountRole(List<UserRoleVO> list, Long userid){
        List<UserRoleVO> re = new ArrayList<>();
        for (UserRoleVO model:list){
            if (model.getUserID().longValue()==userid){
                re.add(model);
            }
        }
        return re;
    }


}
