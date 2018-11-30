package com.zgtong.web.account.dataobject;

import lombok.Data;

import java.util.Date;

/**
 */
@Data
public class RightsDo {

    private Long id;
    private String name;
    private String desc;
    private String pathPrefix;
    private Date createTime;
    private Date updateTime;
    private Long parentId;
    private Integer type;
    private String resource;
}
