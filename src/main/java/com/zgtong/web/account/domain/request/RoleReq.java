package com.zgtong.web.account.domain.request;


import com.zgtong.web.account.domain.response.RoleVO;
import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class RoleReq extends ServiceRequest {

    public RoleReq() {
        super();
    }

    public RoleReq(ServiceRequest base) {
        super(base);
    }

    public RoleVO roleVO;

    public Long userId;
}
