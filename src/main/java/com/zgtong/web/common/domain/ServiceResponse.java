package com.zgtong.web.common.domain;


import com.zgtong.web.common.error.CommonError;
import com.zgtong.web.common.error.Error;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * response 标准模板,请勿继承
 */
@Getter
public final class ServiceResponse<T> extends TraceObject implements Serializable {
	/**
	 * 请使用ServiceResponse.newResponse()替换此方法
	 *
	 * @param traceId
	 */
	@Deprecated
	public ServiceResponse(String traceId) {
	}

	/**
	 * 请使用ServiceResponse.newResponse()替换此方法
	 *
	 * @param traceId
	 * @param error
	 */
	@Deprecated
	public ServiceResponse(String traceId, Error error) {
		this.code = error.getCode();
		this.desc = error.getDescr();
	}

	/**
	 * 请使用ServiceResponse.newResponse()替换此方法
	 *
	 * @param traceId
	 * @param code
	 * @param desc
	 */
	@Deprecated
	public ServiceResponse(String traceId, int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	/**
	 * 请使用ServiceResponse.newResponse()替换此方法
	 *
	 * @param traceId
	 * @param error
	 * @param data
	 */
	@Deprecated
	public ServiceResponse(String traceId, Error error, T data) {
		this.code = error.getCode();
		this.desc = error.getDescr();
		this.data = data;
	}

	private ServiceResponse() {
	}

	/**
	 * 推荐使用此方法
	 *
	 * @param error
	 */
	public ServiceResponse(Error error) {
		this.code = error.getCode();
		this.desc = error.getDescr();
	}

	/**
	 * 推荐使用此方法
	 *
	 * @param code
	 * @param desc
	 */
	public ServiceResponse(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	/**
	 * 推荐使用此方法
	 *
	 * @param error
	 * @param data
	 */
	public ServiceResponse(Error error, T data) {
		this.code = error.getCode();
		this.desc = error.getDescr();
		this.data = data;
	}

	@Deprecated
	public static ServiceResponse newResponse(TraceObject trace, Error error) {
		ServiceResponse response = new ServiceResponse(error);
		return response;
	}

	@Deprecated
	public static <T> ServiceResponse newResponse(TraceObject trace, Error error, T data) {
		ServiceResponse response = new ServiceResponse(error, data);
		return response;
	}

	@Deprecated
	public static ServiceResponse newResponse(TraceObject trace, int code, String desc) {
		ServiceResponse response = new ServiceResponse(code, desc);
		return response;
	}

	public static <T> ServiceResponse<T> successResponse(T data) {
		return new ServiceResponse<T>(CommonError.SUCCESS, data);
	}

	private int code;
	private String desc;
	@Setter
	private T data;
	@Getter
	@Setter
	private Map<String, Object> extension;

	public boolean isSuccess() {
		return this.code == CommonError.SUCCESS.getCode();
	}

	@Override
	public String toString() {
		return "{" + "\"code\":" + code + ", \"desc\":'" + desc + '\'' + ", \"data\":" + data + '}';
	}
}
