package com.jifenbao.model.helper;

import org.apache.commons.lang3.StringUtils;

import com.jifenbao.common.constants.TaoBaoConstants;

public class TaobaoMessage {

	/**
	 * 短信模版编号
	 */
	private String sms_template_code;
	
	/**
	 * 短信签名模版
	 */
	private String  sms_free_sign_name;
	
	/**
	 * 短信接受号码
	 */
	private String rec_num;
	
	/**
	 * 传入参数
	 * {"code":"1234","product":"alidayu"}
	 */
	private String sms_param;
	
	/**
	 * 短信类型
	 * 默认是：normal
	 */
	private String sms_type;
	/**
	 * 公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，
	 * 用户可以根据该会员ID识别是哪位会员使用了你的应用
	 */
	private String extend;
	
	/**
	 * 返回model
	 */
	private String rspModel;
	
	/**
	 * 错误原因
	 */
	private String  errorMsg;
	
	/**
	 * 调用是否成功
	 */
	private boolean isSuccess = false;
	
	private String msgResponse;
	
	private String msgRequest;
	
	
	/**
	 * 短信类型
	 * 1：注册
	 * 2: 登录
	 * 3：发货通知
	 * 4：验证身份
	 * 5: 发送取票验证啊
	 */
	private int type;
	
	
	

	public String getSms_template_code() {
		switch(this.getType()){
		  case 1:
			   return TaoBaoConstants.sms_template_regsit ;
		  case 2:	
			  return TaoBaoConstants.sms_template_login;
          case 3:   
              return TaoBaoConstants.sms_template_notice;
          case 4:   
              return TaoBaoConstants.sms_template_auth;
          case 5:   
              return TaoBaoConstants.sms_template_ticket;
          case 6:   
              return TaoBaoConstants.sms_template_sendMemberCard;
          case 7:   
        	  return TaoBaoConstants.sms_template_sendOutGoods;
		}
		return sms_template_code;
	}

	public void setSms_template_code(String sms_template_code) {
		this.sms_template_code = sms_template_code;
	}

	public String getSms_free_sign_name() {
		switch(this.getType()){
		  case 1:
			   return TaoBaoConstants.sms_sign_name_regsit ;
		  case 2:	
			  return TaoBaoConstants.sms_sign_name_login;
		  case 3:	
			  return TaoBaoConstants.sms_sign_name_notice;
          case 4:   
              return TaoBaoConstants.sms_sign_name_auth;
          case 5:   
              return TaoBaoConstants.sms_sign_name_ticket;
          case 6:   
              return TaoBaoConstants.sms_sign_name_sendMemberCard;
          case 7:   
              return TaoBaoConstants.sms_sign_name_sendOutGoods;
		}
		return sms_free_sign_name;
	}

	public void setSms_free_sign_name(String sms_free_sign_name) {
		this.sms_free_sign_name = sms_free_sign_name;
	}

	public String getRec_num() {
		return rec_num;
	}

	public void setRec_num(String rec_num) {
		this.rec_num = rec_num;
	}

	public String getSms_param() {
		return sms_param;
	}

	public void setSms_param(String sms_param) {
		this.sms_param = sms_param;
	}

	public String getSms_type() {
		return StringUtils.isBlank(sms_type)?"normal":sms_type;
	}

	public void setSms_type(String sms_type) {
		this.sms_type = sms_type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getRspModel() {
		return rspModel;
	}

	public void setRspModel(String rspModel) {
		this.rspModel = rspModel;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	

	public String getMsgRequest() {
		return msgRequest;
	}

	public void setMsgRequest(String msgRequest) {
		this.msgRequest = msgRequest;
	}

	public String getMsgResponse() {
		return msgResponse;
	}

	public void setMsgResponse(String msgResponse) {
		this.msgResponse = msgResponse;
	}
	
	
	
	
}
