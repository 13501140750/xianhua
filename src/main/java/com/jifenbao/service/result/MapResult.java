package com.jifenbao.service.result;

import java.util.Map;

public class MapResult<T, D> extends BaseResult {

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1557153704222934069L;

	public MapResult(){
		super();
	}
	
	public MapResult(boolean success, String errorCode, String errorMsg){
		super(success, errorCode, errorMsg);
	}
	/**
	 * 多个返回结果
	 */
	private Map<T, D> data;

	public Map<T, D> getData() {
		return data;
	}

	public void setData(Map<T, D> data) {
		this.data = data;
	}
}
