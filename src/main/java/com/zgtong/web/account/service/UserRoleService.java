package com.zgtong.web.account.service;


import com.zgtong.web.account.domain.request.UserRoleReq;
import com.zgtong.web.account.domain.response.RoleVO;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.logger.annotation.AutoLogger;

import java.util.List;

/**
 *
 */
public interface UserRoleService {

    /**
     * 查询用户角色
     * @param req
     * @return
     */
    @AutoLogger
    public ServiceResponse<List<RoleVO>> findRole(UserRoleReq req);

    /**
     * 创建用户角色
     * @param req
     * @return
     */
    @AutoLogger
    public  ServiceResponse<Integer>   createRole(UserRoleReq req);

    /**
     * 修改用户角色
     * @param req
     * @return
     */
    @AutoLogger
    public  ServiceResponse<Integer>    updateRole(UserRoleReq req);

    /**
     * 删除用户角色
     * @param req
     * @return
     */
    @AutoLogger
    public  ServiceResponse<Integer>     deleteRole(UserRoleReq req);
}
