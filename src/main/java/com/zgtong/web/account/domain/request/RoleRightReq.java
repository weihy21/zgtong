package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

import java.util.List;


/**
 *
 */
@Data
public class RoleRightReq extends ServiceRequest {

    public RoleRightReq() {
        super();
    }

    public RoleRightReq(ServiceRequest base) {
        super(base);
    }

    private  Long roleID;

    private List<Long> rightIDs;

    private Long userId;

    private Integer type;


}
