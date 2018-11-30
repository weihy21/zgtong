package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class GetAllRightsReq extends ServiceRequest {

    public GetAllRightsReq() {
        super();
    }

    public GetAllRightsReq(ServiceRequest base) {
        super(base);
    }

    private  Long roleID;

    private List<Long> rightIDs;

    private Long currentUserId;
}
