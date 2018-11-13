package com.zgtong.web.common.exception;


import com.zgtong.web.common.error.Error;
import com.zgtong.web.common.error.TransferableError;

/**
 * 业务异常
 * 
 * @author weihy on 18/11/09
 *
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Error error;

	public BizException(String message) {
		super(message);
	}

	public BizException(Error error, String message) {
		super(message);
		this.error = error;
	}

	public BizException(Error error, Throwable cause) {
		super(cause);
		this.error = error;
	}

	public BizException(Error error, String message, Throwable cause) {
		super(message, cause);
		this.error = error;
	}

	public BizException(TransferableError error, String message) {
		this(error.getFrom(), message);
	}

	public BizException(TransferableError error, Throwable cause) {
		this(error.getFrom(), cause);
	}

	public BizException(TransferableError error, String message, Throwable cause) {
		this(error.getFrom(), message, cause);
	}

	public Error getError() {
		return error;
	}
}
