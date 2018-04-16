package com.jifenbao.service.result;

public class SingleResult<T> extends BaseResult {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 7453128474626461360L;

	private T data;
	
	public SingleResult(){
		
	}

	public SingleResult(boolean success, String code, String message) {
		super(success, code, message);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
