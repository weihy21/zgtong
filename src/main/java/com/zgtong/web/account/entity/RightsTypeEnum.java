package com.zgtong.web.account.entity;

/**
 *
 */
public enum RightsTypeEnum {

    MENU(1, "菜单"),
    PAGE(2, "页面"),
    FUNCTION(3,"功能"),
    FILE(4,"文件"),
    ;

    public Integer code;
    public String  desc;

    RightsTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
