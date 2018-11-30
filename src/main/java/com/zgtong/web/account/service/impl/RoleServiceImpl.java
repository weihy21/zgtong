package com.zgtong.web.account.service.impl;

import com.zgtong.web.account.dao.ManagerAccountDao;
import com.zgtong.web.account.dao.RoleDao;
import com.zgtong.web.account.dao.RoleRightDao;
import com.zgtong.web.account.dao.UserRoleDao;
import com.zgtong.web.account.dataobject.ManagerAccountDo;
import com.zgtong.web.account.domain.request.RoleReq;
import com.zgtong.web.account.domain.response.Response;
import com.zgtong.web.account.domain.response.RoleRightVO;
import com.zgtong.web.account.domain.response.RoleVO;
import com.zgtong.web.account.domain.response.UserRoleVO;
import com.zgtong.web.account.entity.AccountType;
import com.zgtong.web.account.service.RoleService;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.logger.annotation.AutoLogger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private RoleRightDao roleRightDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Resource
    private ManagerAccountDao managerAccountDao;

    @AutoLogger
    @Override
    public ServiceResponse<List<RoleVO>> findRole(RoleReq req) {
        List<RoleVO> list = new ArrayList<>();
        try{
            ManagerAccountDo accountDo = managerAccountDao.selectById(req.getUserId(),null);
            //查询所有角色
            RoleVO roleVO = new RoleVO();
            if(accountDo!=null){
                if(accountDo.getType()==null || accountDo.getType().intValue()!= AccountType.ADMIN.code.intValue()){
                    if(accountDo.getDepartmentId() != null){
                        roleVO.setDepartmentId(accountDo.getDepartmentId());
                    }else{
                        roleVO.setDepartmentId(-1);
                    }
                }
            }else {
                return  Response.build(Response.Entry.BIZE_31005);
            }
            list = roleDao.findRole(roleVO);
        }catch (Exception ex){
            ex.printStackTrace();
            return   Response.build(Response.Entry.SYSE_20000);
        }
            return  Response.build(Response.Entry.SUCCESS,list);
    }

    @AutoLogger
    @Override
    public ServiceResponse<Integer> createRole(RoleReq req) {
        Integer result = 0;
        try{
            ManagerAccountDo accountDo = managerAccountDao.selectById(req.getUserId(),null);
            if(accountDo==null){
                return  Response.build(Response.Entry.BIZE_31005);
            }
            if (null != req.getRoleVO()){
                RoleVO temp = req.getRoleVO();
                temp.setDepartmentId(accountDo.getDepartmentId());
                result=roleDao.createRole(temp);
            }else{
                return   Response.build(Response.Entry.BIZE_31000);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Response.build(Response.Entry.SUCCESS,result);
    }

    @AutoLogger
    @Override
    public ServiceResponse<Integer> updateRole(RoleReq req) {
        Integer result = 0;
        if (null != req.getRoleVO()){

            RoleVO temp = req.getRoleVO();

            result=roleDao.updateRole(temp);
        }else{
            return   Response.build(Response.Entry.BIZE_31000);
        }
        return Response.build(Response.Entry.SUCCESS,result);
    }

    @AutoLogger
    @Override
    public ServiceResponse<Integer> deleteRole(RoleReq req) {
        Integer result = 0;
        if (null != req.getRoleVO()){
            RoleVO temp = req.getRoleVO();
            if (temp.getId() != null){
                //删除角色
                result=roleDao.deleteRoleByCondition(temp);
                //删除角色关联权限组
                RoleRightVO roleRight = new RoleRightVO();
                roleRight.setRoleID(temp.getId());
                result=roleRightDao.deleteRoleRight(roleRight);
                //删除角色和用户关系
                UserRoleVO userRole = new UserRoleVO();
                userRole.setRoleID(temp.getId());
                result=userRoleDao.deleteUserRole(userRole);

            }else {
                return   Response.build(Response.Entry.BIZE_31000);
            }

        }else{
            return   Response.build(Response.Entry.BIZE_31000);
        }
        return Response.build(Response.Entry.SUCCESS,result);
    }
}
