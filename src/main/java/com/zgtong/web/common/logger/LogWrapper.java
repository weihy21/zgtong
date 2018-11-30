package com.zgtong.web.common.logger;

import lombok.Data;


@Data
public class LogWrapper {

    public LogWrapper(String traceId , Object value){
        this.traceId = traceId;
        this.value = value;
    }

    private String traceId;
    private Object value;

    @Override
    public String toString() {
        return "LogWrapper{" +
                "traceId='" + traceId + '\'' +
                ", value=" + value +
                '}';
    }
}
