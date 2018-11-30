package com.zgtong.web.account.entity;

/**
 *
 */
public enum DepartmentStatus {

    OFF_LINE(0, "删除"),
    ON_LINE(1, "启用");

    public Integer code;
    public String  desc;

    DepartmentStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescr() {
        return desc;
    }

    public static DepartmentStatus valueOfCode(int code){
        for (DepartmentStatus ts : DepartmentStatus.values()){
            if (ts.getCode() == code){
                return ts;
            }
        }

        return null;
    }

}
