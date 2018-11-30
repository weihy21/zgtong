package com.zgtong.web.account.domain.request;

import com.zgtong.web.account.domain.response.RoleVO;
import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 * Created by wxp on 2017/10/12.
 */
@Data
public class CreateRoleReq extends ServiceRequest {

    public CreateRoleReq() {
        super();
    }

    public CreateRoleReq(ServiceRequest base) {
        super(base);
    }

    private RoleVO roleVO;

    private Long currentUserId;
}
