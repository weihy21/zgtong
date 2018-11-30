package com.zgtong.web.account.domain.request;

import com.zgtong.web.common.domain.ServiceRequest;
import lombok.Data;

/**
 * @author weihy
 * @create 2018-11-16
 */
@Data
public class LoginReq extends ServiceRequest {

    private static final long serialVersionUID = 3782858267177279311L;

    public LoginReq() {
        super();
    }

    public LoginReq(ServiceRequest base) {
        super(base);
    }

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private String remember;


}
