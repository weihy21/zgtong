package com.zgtong.web.account.service;


import com.zgtong.web.account.domain.request.RoleRightReq;
import com.zgtong.web.account.domain.response.RoleRightVO;
import com.zgtong.web.common.domain.ServiceResponse;
import com.zgtong.web.common.logger.annotation.AutoLogger;

import java.util.List;

/**
 *
 */
public interface RoleRightService {

    /**
     * 查询ROLE 权限组
     * @param req
     * @return
     */
    @AutoLogger
    public ServiceResponse<List<RoleRightVO>> findRoleRight(RoleRightReq req);

    /**
     * 创建ROLE 权限组
     * @param req
     * @return
     */
    @AutoLogger
    public  ServiceResponse<Integer>   createRoleRight(RoleRightReq req);

    /**
     * 修改ROLE 权限组
     * @param req
     * @return
     */
    @AutoLogger
    public  ServiceResponse<Integer>    updateRoleRight(RoleRightReq req);

    /**
     * 删除ROLE 权限组
     * @param req
     * @return
     */
    @AutoLogger
    public  ServiceResponse<Integer>     deleteRoleRight(RoleRightReq req);
}
