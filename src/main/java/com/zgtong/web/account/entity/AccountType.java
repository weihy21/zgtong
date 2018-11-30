package com.zgtong.web.account.entity;

/**
 *
 */
public enum AccountType {

    NORMAL(1, "普通账户"), ADMIN(2, "超级管理员");

    public Integer code;
    public String  desc;

    AccountType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
