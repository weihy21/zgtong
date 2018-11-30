package com.zgtong.web.account.domain.request;

import com.zgtong.web.account.domain.response.AccountVO;
import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class AddUserReq extends ServiceRequest {

    public AddUserReq() {
        super();
    }

    public AddUserReq(ServiceRequest base) {
        super(base);
    }

    /**
     * 用户账户信息
     */
    private AccountVO accountVo;
    /**
     * 创建者账户id
     */
    private Long      currentUserId;
}
