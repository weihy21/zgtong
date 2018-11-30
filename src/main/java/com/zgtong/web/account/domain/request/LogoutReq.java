package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class LogoutReq extends ServiceRequest {

    public LogoutReq() {
        super();
    }

    public LogoutReq(ServiceRequest base) {
        super(base);
    }

    /**
     * 用户id
     */
    private Long userId;

}
