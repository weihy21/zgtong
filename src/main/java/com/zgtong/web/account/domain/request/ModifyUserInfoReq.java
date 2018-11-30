package com.zgtong.web.account.domain.request;

import com.zgtong.web.account.domain.response.AccountVO;
import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class ModifyUserInfoReq extends ServiceRequest {

    public ModifyUserInfoReq() {
        super();
    }

    public ModifyUserInfoReq(ServiceRequest base) {
        super(base);
    }

    /**
     * 用户账户信息
     */
    private AccountVO accountVo;
    /**
     * 修改者的用户id
     */
    private Long      currentUserId;


}
