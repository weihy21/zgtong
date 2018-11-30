package com.zgtong.web.account.service;

import com.zgtong.web.account.domain.request.QueryRightsReq;
import com.zgtong.web.account.domain.response.RightsVo;
import com.zgtong.web.common.domain.ServiceResponse;

import java.util.List;

/**
 *
 */
public interface RightsFacade {

    /**
     * url:/manager/rights/query
     * <p>
     * <br/>查询所有权限
     *
     * @param queryRightsReq
     * @return
     */
    ServiceResponse<List<RightsVo>> query(QueryRightsReq queryRightsReq);
}
