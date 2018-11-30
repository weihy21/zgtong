package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class QueryDepartmentReq extends ServiceRequest {


    private static final long serialVersionUID = 1318763455765855352L;

    public QueryDepartmentReq() {
        super();
    }

    public QueryDepartmentReq(ServiceRequest base) {
        super(base);
    }

    /**
     * 部门ID
     */
    private  Integer departId;

    private Long currentUserId;



}
