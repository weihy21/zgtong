package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class RemoveUserReq extends ServiceRequest {

    public RemoveUserReq() {
        super();
    }

    public RemoveUserReq(ServiceRequest base) {
        super(base);
    }

    /**
     * 需要删除的用户id
     */
    private Long userId;
    /**
     * 当前用户id
     */
    private Long currentUserId;
    /**
     *  是否删除
     */
    private Boolean isDelete;

}
