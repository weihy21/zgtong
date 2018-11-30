package com.zgtong.web.account.service;


import com.zgtong.web.account.domain.request.RoleReq;
import com.zgtong.web.account.domain.response.RoleVO;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.logger.annotation.AutoLogger;

import java.util.List;

/**
 *
 */
public interface RoleService {

    /**
     * 查询ROLE
     * @param req
     * @return
     */
    @AutoLogger
    public ServiceResponse<List<RoleVO>>  findRole(RoleReq req);

    /**
     * 创建Role
     * @param req
     * @return
     */
    @AutoLogger
    public ServiceResponse<Integer> createRole(RoleReq req);

    /**
     * 修改ROLE
     * @param req
     * @return
     */
    @AutoLogger
    public  ServiceResponse<Integer>    updateRole(RoleReq req);

    /**
     * 删除ROLE
     * @param req
     * @return
     */
    @AutoLogger
    public  ServiceResponse<Integer>     deleteRole(RoleReq req);

}
