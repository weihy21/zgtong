package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class DeleteDepartmentReq extends ServiceRequest {
    public DeleteDepartmentReq() {
        super();
    }

    public DeleteDepartmentReq(ServiceRequest base) {
        super(base);
    }

    private Integer departmentId;

}
