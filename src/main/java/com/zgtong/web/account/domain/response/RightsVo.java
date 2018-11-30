package com.zgtong.web.account.domain.response;

import lombok.Data;

import java.io.Serializable;

/**
 */
@Data
public class RightsVo implements Serializable{

    /**
     * 权限id
     */
    private Long   id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限描述
     */
    private String desc;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 资源URL
     */
    private String resource;

}
