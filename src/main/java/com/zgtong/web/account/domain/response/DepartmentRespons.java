package com.zgtong.web.account.domain.response;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class DepartmentRespons implements Serializable{

    private static final long serialVersionUID = 3675933498811088463L;
    /**
     * 部门ID
     */
    private  Integer departId;

    /**
     * 部门名称
     */
    private  String  departmentName;

    /**
     * 部门描述
     */
    private String description;

    /**
     * 创建时间
     */
    private  String createDate;

    /**
     * 修改时间
     */
    private  String updateDate;



}
