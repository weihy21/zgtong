package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

import java.util.List;


/**
 *
 */
@Data
public class UserRoleReq extends ServiceRequest {


    public UserRoleReq() {
        super();
    }
    public UserRoleReq(ServiceRequest base) {
        super(base);
    }

    private Long currentUserId;

    private Long userID;

    private List<Long> roleIDS;

    private  Integer id;
}
