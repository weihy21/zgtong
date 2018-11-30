package com.zgtong.web.account.controller;

import com.zgtong.web.account.domain.request.*;
import com.zgtong.web.account.domain.response.*;
import com.zgtong.web.account.service.*;
import com.zgtong.web.common.domain.PageObject;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.error.CommonError;
import com.zgtong.web.common.logger.annotation.AutoLogger;
import com.zgtong.web.utils.ValidationUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * @author weihy
 * @create 2018-11-16
 */
@RestController
@CrossOrigin
@RequestMapping(value = "manager",method = RequestMethod.POST)
public class ManagerController {

    @Resource
    private AccountService accountService;

    @Resource
    private DepartmentFacade departmentFacade;

    @Resource
    private RoleService roleService;

    @Resource
    private RoleRightService roleRightService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RightsFacade rightsFacade;



    private String ZGTONG_USERNAME_COOKIE = "zgtongusernameco";
    private String ZGTONG_USERNAME_SESSION = "zgtongusernamese";


    /**
     * 添加账户请求
     * <br/>
     * <p>
     * <p>url:/manager/account/add
     * @param addUserReq
     * @return
     */
    @RequestMapping("/account/add")
    @AutoLogger
    public ServiceResponse<Void> add(@RequestBody AddUserReq addUserReq) {

        return accountService.add(addUserReq);
    }


    /**
     * <p>url:/manager/account/modify
     *
     * @param modifyUserInfoReq
     * @return
     */
    @RequestMapping("/account/modify")
    @AutoLogger
    public ServiceResponse<Void> modify(@RequestBody ModifyUserInfoReq modifyUserInfoReq) {
        return accountService.modify(modifyUserInfoReq);
    }

    /**
     * <p>url:/manager/account/remove
     *
     * @param removeUserReq
     * @return
     */
    @RequestMapping("/account/remove")
    @AutoLogger
    public ServiceResponse<Void> remove(@RequestBody RemoveUserReq removeUserReq) {
        return accountService.remove(removeUserReq);
    }


    /**
     * <p>url:/manager/account/login
     * <p>
     * <br/>
     * 密码登录请求
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/account/login")
    @AutoLogger
    public ServiceResponse<AccountVO> login(@RequestBody LoginReq loginReq,HttpServletRequest request, HttpServletResponse resp) {

        if(null != request.getSession().getAttribute(ZGTONG_USERNAME_SESSION)){
            AccountVO accountVO = (AccountVO)request.getSession().getAttribute(ZGTONG_USERNAME_SESSION);
            return new ServiceResponse<>(CommonError.SUCCESS,accountVO);
        }

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            //遍历
            for(Cookie c:cookies){
                if(Objects.equals(c.getName(),ZGTONG_USERNAME_COOKIE)){
                    AccountVO accountVO = new AccountVO();
                    accountVO.setUserName(c.getValue());
                    return new ServiceResponse<>(CommonError.SUCCESS,accountVO);
                }
            }
        }

        if (ValidationUtil.containsNullOrEmpty(loginReq.getUsername(), loginReq.getPassword())) {
            return Response.BIZE_PARAMS_EXCEPTIONE;
        }

        LoginReq req = new LoginReq();

        req.setUsername(loginReq.getUsername());
        req.setPassword(loginReq.getPassword());


        ServiceResponse<AccountVO>  response =accountService.login(req);
        if(response.isSuccess() && null!= response.getData()){
            if(StringUtils.isNotBlank(loginReq.getRemember()) && loginReq.getRemember().equals("1")){//记住密码
                // 将用户名和密码存放在cookie对象中
                Cookie cookie = new Cookie(ZGTONG_USERNAME_COOKIE, req.getUsername());
                // 设置有效时间三天
                cookie.setMaxAge(3 * 24 * 60 * 60);
                // 设置有效页面
                cookie.setPath(request.getContextPath()+"/");
                // 将cookie对象存放至response
                resp.addCookie(cookie);
            }
            request.getSession().setAttribute(ZGTONG_USERNAME_SESSION, response.getData());
        }
        return response;
    }


    /**
     * url:/manager/account/query
     * <p>
     * <br/></>查询用户详细信息
     *
     * @param queryUserInfoReq
     * @return
     */
    @RequestMapping("/account/query")
    @AutoLogger
    public ServiceResponse<AccountVO> query(@RequestBody QueryUserInfoReq queryUserInfoReq) {
        ServiceResponse response = accountService.query(queryUserInfoReq);
        return response;
    }

    /**pm
     * <p>url:/manager/account/list
     * <p>
     * <br/></>查询用户列表
     *
     * @param queryUserListReq
     * @return
     */
    @RequestMapping("/account/list")
    @AutoLogger
    public ServiceResponse<PageObject<AccountVO>> list(@RequestBody QueryUserListReq queryUserListReq) {
        if(queryUserListReq.getPageSize() == null){
            queryUserListReq.setPageSize(20);
        }
        ServiceResponse<PageObject<AccountVO>>  response = accountService.list(queryUserListReq);
        return response;
    }



    /**
     * <p>url:/manager/account/logout
     * <p>
     * <br/>用户登出：
     * @param
     * @return
     */
    @RequestMapping("/account/logout")
    @AutoLogger
    public ServiceResponse<Void> logout(HttpServletRequest request, HttpServletResponse resp) {

        request.getSession().invalidate();

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            //遍历
            for(Cookie c:cookies){
                if(Objects.equals(c.getName(),ZGTONG_USERNAME_COOKIE)){
                    c.setMaxAge(0);
                    c.setValue(null);
                    c.setPath(request.getContextPath()+"/");
                    // 将cookie对象存放至response
                    resp.addCookie(c);
                    return new ServiceResponse<>(CommonError.SUCCESS);
                }
            }
        }
        return new ServiceResponse<>(CommonError.SUCCESS);
    }




    //-----------------------------------公司---------------------------------------------

    /**
     * url:/manager/department/add
     * <p>
     * <br/>公司添加
     * @param
     * @return
     */
    @RequestMapping("/department/addOrModify")
    @AutoLogger
    public  ServiceResponse<Long> addOrModify(@RequestBody AddDepartmentReq addDepartmentReq){

        return departmentFacade.addOrModifyDepartment(addDepartmentReq);
    }

    /**
     * url:/manager/department/detail
     * <p>
     * <br/>公司详情
     * @param departmentReq
     * @return
     */
    @RequestMapping("/department/detail")
    @AutoLogger
    public  ServiceResponse<DepartmentRespons> detailDepartment(@RequestBody DepartmentReq departmentReq){
        GetDepartmentReq getDepartmentReq = new GetDepartmentReq();
        getDepartmentReq.setDepartmentId(departmentReq.getId());
        return   departmentFacade.detailDepartment(getDepartmentReq);
    }


    /**
     * url:/manager/department/delete
     * <p>
     * <br/>公司删除
     * @param departmentReq
     * @return
     */
    @RequestMapping("/department/delete")
    @AutoLogger
    public  ServiceResponse<Boolean> deleteDepartment(@RequestBody DepartmentReq departmentReq){
        DeleteDepartmentReq deleteDepartmentReq = new DeleteDepartmentReq();
        deleteDepartmentReq.setDepartmentId(departmentReq.getId());
        return departmentFacade.deleteDepartment(deleteDepartmentReq);
    }

    /**
     * url:/manager/department/list
     * <p>
     * <br/>公司列表
     * @param
     * @return
     */
    @RequestMapping("/department/list")
    @AutoLogger
    public  ServiceResponse<List<DepartmentRespons>> departmentList(@RequestBody QueryDepartmentReq queryDepartmentReq){
        GetDepartmentReq getDepartmentReq = new GetDepartmentReq();
        getDepartmentReq.setCurrentUserId(queryDepartmentReq.getCurrentUserId());
        return    departmentFacade.departmentList(getDepartmentReq);
    }



    //-----------------------------------角色---------------------------------------------

    /**
     * url:/role/getAllRole
     * <p>
     * <br/>查询所有角色
     * @param getRoleReq
     * @return
     */
    @RequestMapping("/role/getAllRole")
    @AutoLogger
    public ServiceResponse<List<RoleVO>> getAllRole(@RequestBody GetRoleReq getRoleReq){
        RoleReq roleReq = new RoleReq();
        roleReq.setUserId(getRoleReq.getCurrentUserId());
        roleReq.setRoleVO(getRoleReq.getRoleVO());
        return roleService.findRole(roleReq);
    }


    /**
     * url:/role/createRole
     * <p>
     * <br/>创建角色
     * @param createRoleReq
     * @return
     */
    @RequestMapping("/role/createRole" )
    @AutoLogger
    public ServiceResponse<Integer> createRole(@RequestBody CreateRoleReq createRoleReq){

        if(createRoleReq.getRoleVO() == null){
            return  new ServiceResponse<>(CommonError.INVALID_PARAMTER);
        }
        RoleVO roleVO = createRoleReq.getRoleVO();
        if(roleVO.getName()==null){
            return  new ServiceResponse<>(CommonError.INVALID_PARAMTER);
        }
        RoleReq roleReq = new RoleReq();
        roleReq.setRoleVO(roleVO);
        roleReq.setUserId(createRoleReq.getCurrentUserId());
        ServiceResponse<Integer> re= new ServiceResponse<>(roleReq.getTraceId());
        re = roleService.createRole(roleReq);
        return  re;
    }


    /**
     * url:/role/editRole
     * <p>
     * <br/>编辑角色
     * @param roleReq
     * @return
     */
    @RequestMapping("/role/editRole")
    @AutoLogger
    public ServiceResponse<Integer> editRole(@RequestBody RoleReq roleReq){
        return roleService.updateRole(roleReq);
    }

    /**
     * url:/role/deleteRole
     * <p>
     * <br/>删除角色
     * @param roleReq
     * @return
     */
    @RequestMapping("/role/deleteRole")
    @AutoLogger
    public ServiceResponse<Integer> deleteRole(@RequestBody RoleReq roleReq){
        return roleService.deleteRole(roleReq);
    }




    /**
     * url:/manager/rights/query
     * <p>
     * <br/>查询所有权限
     *
     * @param queryRightsReq
     * @return
     */
    @RequestMapping("/rights/query")
    @AutoLogger
    public ServiceResponse<List<RightsVo>> query(@RequestBody QueryRightsReq queryRightsReq) {
        return rightsFacade.query(queryRightsReq);
    }

    /**
     * url:/roleRights/getAllRole
     * <p>
     * <br/>查询所有菜单
     * @param getAllRightsReq
     * @return
     */
    @RequestMapping("/roleRights/getAllRights")
    @AutoLogger
    public  ServiceResponse<List<RoleRightVO>> getAllRights(@RequestBody GetAllRightsReq getAllRightsReq){
        RoleRightReq roleRightReq = new RoleRightReq();
        roleRightReq.setRoleID(getAllRightsReq.getRoleID());
        roleRightReq.setRightIDs(getAllRightsReq.getRightIDs());
        roleRightReq.setUserId(getAllRightsReq.getCurrentUserId());
        return  roleRightService.findRoleRight(roleRightReq);
    }


    /**
     * url:/roleRights/getAllRole
     * <p>
     * <br/>创建角色菜单  编辑角色菜单
     * @param rightReq
     * @return
     */
    @RequestMapping("/roleRights/editRoleRights")
    @AutoLogger
    public  ServiceResponse<Integer> editRoleRights(@RequestBody RoleRightReq rightReq){
        return   roleRightService.createRoleRight(rightReq);
    }


    /**
     * url:/roleUser/createUserRole
     * <p>
     * <br/>创建 编辑 用户角色
     * @param userRoleReq
     * @return
     */
    @RequestMapping("/roleUser/createUserRole")
    @AutoLogger
    public  ServiceResponse<Integer> createUserRole(@RequestBody UserRoleReq userRoleReq){
        return   userRoleService.createRole(userRoleReq);
    }


    /**
     * url:/roleUser/createUserRole
     * <p>
     * <br/>查询 用户角色
     * @param findUserRoleReq
     * @return
     */
    @RequestMapping("/roleUser/findUserRole")
    @AutoLogger
    public  ServiceResponse<List<RoleVO>> findUserRole(@RequestBody FindUserRoleReq findUserRoleReq){
        UserRoleReq userRoleReq = new UserRoleReq();
        userRoleReq.setRoleIDS(findUserRoleReq.getRoleIDS());
        userRoleReq.setUserID(findUserRoleReq.getUserID());
        userRoleReq.setCurrentUserId(findUserRoleReq.getCurrentUserId());
        return   userRoleService.findRole(userRoleReq);
    }




}
