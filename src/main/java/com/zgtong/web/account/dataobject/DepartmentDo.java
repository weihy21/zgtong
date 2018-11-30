package com.zgtong.web.account.dataobject;

import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class DepartmentDo {
    private Integer id;
    private String  name;
    private String  description;
    private Integer status;
    private Long lastUpdateUser;
    private Date createTime;
    private Date updateTime;
}
