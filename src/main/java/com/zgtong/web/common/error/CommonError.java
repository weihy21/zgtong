package com.zgtong.web.common.error;


import java.lang.*;

/**
 * 公共异常信息定义
 * Created by weihy on 18/11/09.
 */
public enum CommonError implements Error {

    /**
     * 当前操作,需要用户是登录状态
     */
    SUCCESS(                        10000,"成功"),
    NEED_LOGIN(                     11990001,"请登录"),
    INVALID_PARAMTER(               11990002,"缺少必要参数"),
    INVALID_COMMON_PARAMTER(        11990003,"缺少公共参数必要参数"),
    UNKNOW_ERROR(                   11999999,"未捕获的异常"),
    SYSTEM_BUSY(                   99999999,"System busy."),

    ;

    private Integer code;
    private String descr;

    CommonError(Integer code, String descr){
        this.code = code;
        this.descr = descr;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescr() {
        return descr;
    }

    public static CommonError valueOfCode(int code){
        for (CommonError ts : CommonError.values()){
            if (ts.getCode() == code){
                return ts;
            }
        }

        return null;
    }

}
