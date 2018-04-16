package com.jifenbao.service.result;

import java.util.List;

public class ListResult<T> extends BaseResult {

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1557153704222934069L;

	public ListResult(){
		super();
	}
	
	public ListResult(boolean success, String errorCode, String errorMsg){
		super(success, errorCode, errorMsg);
	}
	/**
	 * 多个返回结果
	 */
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
