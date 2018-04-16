package com.jifenbao.model.helper;

import java.util.List;

public class Kuaidi {
  
	private String  EBusinessID;//用户ID
	private String  OrderCode ;//订单编号
	private String  ShipperCode;//快递公司编码
	private String  LogisticCode;//物流运单号
	private String  Success;//成功与否
	private String  Reason;//失败原因
	private int     State;//物流状态：2-在途中,3-签收,4-问题件
	private String ShipperName;//快递公司名称
	private String Traces; //详细信息
	private List<KuaidiTrace> kuaidiTraces;//详细信息
	
	public String getEBusinessID() {
		return EBusinessID;
	}
	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getShipperCode() {
		return ShipperCode;
	}
	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}
	public String getLogisticCode() {
		return LogisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}
	public String getSuccess() {
		return Success;
	}
	public void setSuccess(String success) {
		Success = success;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	
	
	
	
	public String getTraces() {
		return Traces;
	}
	public void setTraces(String traces) {
		Traces = traces;
	}
	public List<KuaidiTrace> getKuaidiTraces() {
		return kuaidiTraces;
	}
	public void setKuaidiTraces(List<KuaidiTrace> kuaidiTraces) {
		this.kuaidiTraces = kuaidiTraces;
	}
	public String getShipperName() {
		return ShipperName;
	}
	
	public void setShipperName(String shipperName) {
		ShipperName = shipperName;
	}
	
	public String getStateString(){
		String stateString =  "";
		switch(State){
		 case 2:
			    stateString = "在途中"; 
			    break;
		 case 3:
				stateString = "签收"; 
				break;
		 case 4:
				stateString = "问题件"; 
				break;
		}
		return  stateString;
	}
	
}
