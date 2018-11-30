package com.zgtong.web.account.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * 
 */
@Data
public class AccountRightsDo {

    private Long    id;
    private Long    userId;
    private Long    rightsId;
    private Date    createTime;
    private Date    updateTime;

}
