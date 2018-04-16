package com.jifenbao.service.result;

import java.io.Serializable;

public class BaseResult implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5965131132707550936L;

	/**
	 * 处理成功或失败
	 */
	private boolean success;

	/**
	 * 错误代码
	 */
	private String errorCode;

	/**
	 * 错误
	 */
	private String errorMsg;

    public BaseResult(){
    }
    
    public BaseResult(boolean success, String errorCode, String errorMsg){
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
