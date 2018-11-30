package com.zgtong.web.account.domain.request;


import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 *
 */
@Data
public class QueryUserInfoReq extends ServiceRequest {


    private static final long serialVersionUID = 3433656666056604012L;

    public QueryUserInfoReq(ServiceRequest base) {
        super(base);
    }
    public QueryUserInfoReq() {
        super();
    }

    /**
     * 目标用户id
     */
    private Long userId;
    /**
     * 当前用户id
     */
    private Long currentUserId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 是否需要密码
     */
    private  Boolean needPassword;

}
