package com.zgtong.web.account.domain.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
public class UserRoleVO implements Serializable {
    private  Integer id;
    private  Long userID;
    private  Long RoleID;
    private  String roleName;
    private  String desc;
    private  Date createTime;
    private  Date updateTime;
}
