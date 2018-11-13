package com.zgtong.web.common.domain;

import java.io.Serializable;

/**
 * request基类
 * Created by weihy on 18/11/09.
 */

public class ServiceRequest extends TraceObject implements Serializable {

    private static final long serialVersionUID = 3985181007473773289L;

    /**
     * 不需要默认的构造函数,以免trace id被遗忘
     */
    public ServiceRequest() {
    }

    /**
     * 入参请传null
     * @param traceId
     */
    public ServiceRequest(String traceId) {
    }

    /**
     * 入参请传null
     * @param base
     */
    public ServiceRequest(ServiceRequest base) {
    }
}
