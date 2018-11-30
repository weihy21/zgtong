package com.zgtong.web.account.service.impl;

import com.zgtong.web.account.dao.ManagerAccountDao;
import com.zgtong.web.account.dao.RoleDao;
import com.zgtong.web.account.dao.UserRoleDao;
import com.zgtong.web.account.dataobject.ManagerAccountDo;
import com.zgtong.web.account.domain.request.UserRoleReq;
import com.zgtong.web.account.domain.response.Response;
import com.zgtong.web.account.domain.response.RoleVO;
import com.zgtong.web.account.domain.response.UserRoleVO;
import com.zgtong.web.account.service.UserRoleService;
import com.zgtong.web.common.domain.ServiceResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wxp on 2017/6/1.
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleDao userRoleDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private ManagerAccountDao managerAccountDao;

    @Override
    public ServiceResponse<List<RoleVO>> findRole(UserRoleReq req) {

        ManagerAccountDo accountDo = managerAccountDao.selectById(req.getCurrentUserId(),null);

        List<UserRoleVO> result = new ArrayList<>();
        List<RoleVO> roles = new ArrayList<>();
        if (null != req.getUserID()){
            //查询用户角色
            UserRoleVO temp = new UserRoleVO();
            temp.setUserID(req.getUserID());
            result=userRoleDao.findUserRole(temp);
            //查询所有角色
            if(accountDo!=null){
                RoleVO roleVO = new RoleVO();
                roles = roleDao.findRole(roleVO);
            }else {
                return  Response.build(Response.Entry.BIZE_31005);
            }
            //组合数据
            for (int i=0;i<roles.size();i++){
                Boolean flag = findRight(result,roles.get(i).getId());
                if(flag){
                    roles.get(i).setType(true);
                }
            }
        }else{
            return   Response.build(Response.Entry.BIZE_31000);
        }
        return Response.build(Response.Entry.SUCCESS,roles);
    }

    @Override
    public ServiceResponse<Integer> createRole(UserRoleReq req) {
        List<UserRoleVO> roleList = new ArrayList<>();
        List<Long>  roleIDs = req.getRoleIDS();
        Integer result=0;
        if(null != req.getUserID()){
            //删除用户旧权限角色组
            UserRoleVO ur = new UserRoleVO();
            ur.setUserID(req.getUserID());
            userRoleDao.deleteUserRole(ur);
            //重新写入角色组
            for(Long temp:roleIDs){
                UserRoleVO vo = new UserRoleVO();
                vo.setRoleID(temp);
                vo.setUserID(req.getUserID());
                roleList.add(vo);
            }
            if(roleList.size()>0)
            result=userRoleDao.createUserRole(roleList);
        }else {
            return   Response.build(Response.Entry.BIZE_31000);
        }
        return Response.build(Response.Entry.SUCCESS,result);
    }

    @Override
    public ServiceResponse<Integer> updateRole(UserRoleReq req) {
        return null;
    }

    @Override
    public ServiceResponse<Integer> deleteRole(UserRoleReq req) {
       Integer result=0;
        if (null != req.getId()) {
            UserRoleVO vo = new UserRoleVO();
            vo.setId(req.getId());
            result=userRoleDao.deleteUserRole(vo);
        }else {
            return   Response.build(Response.Entry.BIZE_31000);
        }
        return Response.build(Response.Entry.SUCCESS,result);
    }

    public boolean findRight(List<UserRoleVO> list, Long id){
        for (UserRoleVO vo :list){
            if(Objects.equals(vo.getRoleID(),id)){
                return true;
            }
        }
        return false;
    }
}
