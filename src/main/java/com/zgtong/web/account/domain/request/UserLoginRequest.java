package com.zgtong.web.account.domain.request;

import lombok.Data;


@Data
public class UserLoginRequest extends LoginReq {

    private static final long serialVersionUID = 7010038210038765904L;
    private String remember;

}
