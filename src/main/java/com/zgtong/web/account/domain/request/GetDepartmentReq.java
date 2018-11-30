package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class GetDepartmentReq extends ServiceRequest {

    private static final long serialVersionUID = -1478326056063793071L;

    public GetDepartmentReq() {
        super();
    }

    public GetDepartmentReq(ServiceRequest base) {
        super(base);
    }

    private Integer departmentId;

    private String  departmentName;

    private Long currentUserId;

}
