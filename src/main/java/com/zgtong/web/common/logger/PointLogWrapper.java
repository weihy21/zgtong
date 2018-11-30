package com.zgtong.web.common.logger;

import lombok.Data;

import java.io.Serializable;


@Data
public class PointLogWrapper implements Serializable{

    private String facade;
    private String method;
    private Object request;
    private Object response;

}
