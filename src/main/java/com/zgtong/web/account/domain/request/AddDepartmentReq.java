package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class AddDepartmentReq extends ServiceRequest {


    private static final long serialVersionUID = 6644832173647116765L;

    public AddDepartmentReq(String traceId) {
        super(traceId);
    }

    public AddDepartmentReq(ServiceRequest base) {
        super(base);
    }

    /**
     * 部门ID
     */
    private  Integer departId;

    /**
     * 部门名称
     */
    private  String  departmentName;

    /**
     * 部门描述
     */
    private String description;

}
