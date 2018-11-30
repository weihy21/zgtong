package com.zgtong.web.account.domain.request;

import com.zgtong.web.account.domain.response.RoleVO;
import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class GetRoleReq extends ServiceRequest {

    private static final long serialVersionUID = -3074995604550148727L;

    public GetRoleReq() {
        super();
    }

    public GetRoleReq(ServiceRequest base) {
        super(base);
    }

    private RoleVO roleVO;
    private Long currentUserId;

}
