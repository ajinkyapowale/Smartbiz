package com.smartbiz.exception;

public class SmartbizException extends Exception {

	public SmartbizException() {
	}

	public SmartbizException(String message) {
		super(message);
	}

	public SmartbizException(Throwable cause) {
		super(cause);
	}

	public SmartbizException(String message, Throwable cause) {
		super(message, cause);
	}

	public SmartbizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
