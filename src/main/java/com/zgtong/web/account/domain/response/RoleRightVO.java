package com.zgtong.web.account.domain.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
public class RoleRightVO implements Serializable{
    private  Integer id;
    private  Long roleID;
    private  Long rightID;
    private  Date createTime;
    private  Date updateTime;
    private  String name;
    private  String desc;
    private  Boolean type;
    private  Long parentID;
}
