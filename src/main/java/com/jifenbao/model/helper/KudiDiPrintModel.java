package com.jifenbao.model.helper;

import com.jifenbao.common.PropertyConfig;
import com.otc.framework.utils.DateTimeUtil;



public class KudiDiPrintModel {
     private  int    printType;//快递单类型(1:同城速递,2:宅急送 3:顺丰)
     private  String senderCompany;//寄件人公司
     private  String cardComment;//是否为渠道
	 private  String bigClientCode;//大客户代码
	 private  String items;//寄托物品
	 private  String inform;//接受短信通
	 private  String sendTime;//寄件时间
	 private  String sign;//寄件人签名
	 private  String courier;//快递员签名
	 private  String orininal;//收寄局
	 private  String sender;//寄件人
	 private  String senderPhone;//寄件人电话
	 private  String senderAdd;//寄件人地址
	 private  String senderCode;//寄件人邮编
	 private  String sendGp; 
	 
	 
	
	 private String  receiver;//收件人
	 private String  receiverPhone;//收件人电话
	 private String  receiverCompany;//收件人公司
	 private String  receiverTel;//收件人座机
	 private String  receiverPro;//收件人省
	 private String  receiverCity;//收件人市
	 private String  receiverAdd;//收件人地址
	 private String  comments;
	 
	
	 public String getSendTime() {
			return DateTimeUtil.format(DateTimeUtil.now(), "yyyy-MM-dd");
		 }
	 
	public int getPrintType() {
		return printType;
	}
	public void setPrintType(int printType) {
		this.printType = printType;
	}
	public String getSender() {
		return PropertyConfig.getPropertyValue("sender");
	}
	public String getSenderPhone() {
		return PropertyConfig.getPropertyValue("senderPhone");
	}
	public String getSenderCompany() {
		if(senderCompany==null||senderCompany.equals(""))
		  return PropertyConfig.getPropertyValue("senderCompany");
		else  return  senderCompany;
	}
	public String getSenderAdd() {
		return PropertyConfig.getPropertyValue("senderAdd");
	}
	public String getSenderCode() {
		return PropertyConfig.getPropertyValue("senderCode");
	}
	public String getBigClientCode() {
		return bigClientCode;
	}
	public String getItems() {
		return items;
	}
	public String getInform() {
		return inform;
	}
	
	public String getReceiver() {
		return receiver;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public String getReceiverCompany() {
		return receiverCompany;
	}
	public String getReceiverTel() {
		return receiverTel;
	}
	public String getReceiverAdd() {
		return receiverAdd;
	}
	public String getComments() {
		return comments;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}
	public void setSenderAdd(String senderAdd) {
		this.senderAdd = senderAdd;
	}
	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}
	public void setBigClientCode(String bigClientCode) {
		this.bigClientCode = bigClientCode;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public void setReceiverCompany(String receiverCompany) {
		this.receiverCompany = receiverCompany;
	}
	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}
	public void setReceiverAdd(String receiverAdd) {
		this.receiverAdd = receiverAdd;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getReceiverPro() {
		return receiverPro;
	}
	public void setReceiverPro(String receiverPro) {
		this.receiverPro = receiverPro;
	}
	public String getReceiverCity() {
		return receiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}
	public String getCardComment() {
		return cardComment;
	}
	public void setCardComment(String cardComment) {
		this.cardComment = cardComment;
	}
	public String getSign() {
		return PropertyConfig.getPropertyValue("sign");
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getCourier() {
		return PropertyConfig.getPropertyValue("courier");
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public String getOrininal() {
		 return PropertyConfig.getPropertyValue("orininal");
	}
	public void setOrininal(String orininal) {
		this.orininal = orininal;
	}
	public String getSendGp() {
		return sendGp;
	}
	public void setSendGp(String sendGp) {
		this.sendGp = sendGp;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	 
}
