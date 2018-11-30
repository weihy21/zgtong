package com.zgtong.web.account.entity;

/**
 *
 */
public enum AccountStatus {

    NORMAL(1, "正常"), FROZEN(2, "冻结");

    public Integer code;
    public String  desc;

    private AccountStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
