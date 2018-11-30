package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class DepartmentReq extends ServiceRequest {



    public DepartmentReq() {
        super();
    }

    public DepartmentReq(ServiceRequest base) {
        super(base);
    }

    private  Integer id;
}
