package com.zgtong.web.account.domain.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
public class RoleVO implements Serializable{
    private static final long serialVersionUID = 7733273886021555087L;
    private  Long id;
    private  String name;
    private  String description;
    private  Long parentId;
    private  Integer departmentId;
    private  Boolean type;
    private Date createTime;
    private Date updateTime;
}
