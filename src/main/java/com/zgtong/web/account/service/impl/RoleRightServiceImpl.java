package com.zgtong.web.account.service.impl;

import com.zgtong.web.account.dao.ManagerAccountDao;
import com.zgtong.web.account.dao.RightsDao;
import com.zgtong.web.account.dao.RoleRightDao;
import com.zgtong.web.account.dataobject.ManagerAccountDo;
import com.zgtong.web.account.dataobject.RightsDo;
import com.zgtong.web.account.domain.request.QueryRightsReq;
import com.zgtong.web.account.domain.request.RoleRightReq;
import com.zgtong.web.account.domain.response.Response;
import com.zgtong.web.account.domain.response.RoleRightVO;
import com.zgtong.web.account.entity.AccountType;
import com.zgtong.web.account.entity.RightsTypeEnum;
import com.zgtong.web.account.service.RoleRightService;
import com.zgtong.web.common.domain.ServiceResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 */
@Service("roleRightService")
public class RoleRightServiceImpl implements RoleRightService {

    @Resource
    private RoleRightDao roleRightDao;

    @Resource
    private RightsDao rightsDao;

    @Resource
    private ManagerAccountDao managerAccountDao;

    @Override
    public ServiceResponse<List<RoleRightVO>> findRoleRight(RoleRightReq req) {

        if(req.getUserId()==null){
            return Response.build(Response.Entry.SUCCESS);
        }

        List<RoleRightVO> re = new ArrayList<>();

        List<RoleRightVO> result = new ArrayList<>();

        List <RightsDo> list;

        ManagerAccountDo queryUser   = managerAccountDao.selectById(req.getUserId(),null);
        if(queryUser==null){
            return  Response.build(Response.Entry.BIZE_31005);
        }

        if(req.getType() == null){
            req.setType(RightsTypeEnum.MENU.code);
        }

        if (Objects.equals(AccountType.ADMIN.code,queryUser.getType())){
            QueryRightsReq rightsReq = new QueryRightsReq();
            rightsReq.setType(req.getType());
            list =rightsDao.selectByRight(rightsReq);
        }else {
            list = rightsDao.selectByUserId(req.getUserId(),RightsTypeEnum.MENU.code);
        }

        if (null != req.getRoleID()){
            //查询角色已有菜单权限
            RoleRightVO temp = new RoleRightVO();
            temp.setRoleID(req.getRoleID());
            result=roleRightDao.findRoleRight(temp);

        }

        for (RightsDo model:list){
            RoleRightVO vo = new RoleRightVO();
            vo.setRightID(model.getId());
            vo.setRoleID(req.getRoleID());
            vo.setName(model.getName());
            vo.setDesc(model.getDesc());
            vo.setParentID(model.getParentId());
            if (findRight(result,model.getId())==true){
                vo.setType(true);
            }
            re.add(vo);
        }

        return Response.build(Response.Entry.SUCCESS,re);
    }

    @Override
    public ServiceResponse<Integer> createRoleRight(RoleRightReq req) {
        Long roleid = req.getRoleID();
        List<Long> rights = req.getRightIDs();
        List<RoleRightVO> roleRight = new ArrayList<>();
        Integer result=0;
        if(null != roleid){
            //删除旧权限数据
            RoleRightVO vo = new RoleRightVO();
            vo.setRoleID(roleid);
            roleRightDao.deleteRoleRight(vo);
            //添加新的权限数据
            for (Long temp:rights){
                RoleRightVO rVO = new RoleRightVO();
                rVO.setRoleID(roleid);
                rVO.setRightID(temp);
                roleRight.add(rVO);
            }
            if(roleRight.size()>0)
            roleRightDao.createRoleRight(roleRight);
        }else{
            return   Response.build(Response.Entry.BIZE_31000);
        }
        return Response.build(Response.Entry.SUCCESS,result);
    }

    @Override
    public ServiceResponse<Integer> updateRoleRight(RoleRightReq req) {
        return null;
    }

    @Override
    public ServiceResponse<Integer> deleteRoleRight(RoleRightReq req) {
        Long roleID = req.getRoleID();
        Integer result = 0;
        if(null != roleID){
            RoleRightVO vo = new RoleRightVO();
            vo.setRightID(roleID);
            result = roleRightDao.deleteRoleRight(vo);
        }else{
            return   Response.build(Response.Entry.BIZE_31000);
        }
        return Response.build(Response.Entry.SUCCESS,result);
    }

    public boolean findRight(List<RoleRightVO> list,Long id){

        if(CollectionUtils.isEmpty(list)){
            return false;
        }

        for (RoleRightVO vo :list){
            if(vo.getRightID().longValue()==id){
                return true;
            }
        }
        return false;
    }


}
