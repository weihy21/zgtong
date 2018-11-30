package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

import java.util.List;

/**
 * Created by wxp on 2017/10/12.
 */
@Data
public class FindUserRoleReq extends ServiceRequest {
    private static final long serialVersionUID = -4298284708346771885L;

    public FindUserRoleReq() {
        super();
    }

    public FindUserRoleReq(ServiceRequest base) {
        super(base);
    }

    private Long userID;
    private List<Long> roleIDS;
    private Integer id;
    private Long currentUserId;
}
