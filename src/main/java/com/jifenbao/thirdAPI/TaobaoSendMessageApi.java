package com.jifenbao.thirdAPI;

import com.jifenbao.model.helper.TaobaoMessage;
import com.taobao.api.ApiException;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class TaobaoSendMessageApi extends TaobaoOpenPlatform{

	/**
	 * 短信发送
	 * @param message
	 * @return
	 * @throws ApiException
	 */
	public static TaobaoMessage  sendMessage(TaobaoMessage message) throws ApiException{
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		
		req.setExtend(message.getExtend());
		req.setSmsType(message.getSms_type());
		req.setSmsFreeSignName(message.getSms_free_sign_name());
		req.setSmsParamString(message.getSms_param());//{\"code\":\"1234\",\"product\":\"alidayu\"}
		req.setRecNum(message.getRec_num());
		req.setSmsTemplateCode(message.getSms_template_code());
		AlibabaAliqinFcSmsNumSendResponse rsp = getClient().execute(req);
		//System.out.println(req.getSmsParam()+","+req.getRecNum()+","+req.getExtend()+","+req.getSmsType());
		
		message.setMsgRequest(req.getSmsParam()+","+req.getRecNum()+","+req.getExtend()+","+req.getSmsType());
		message.setMsgResponse(rsp.getBody());
		if(rsp.isSuccess()){//调用成功
			message.setSuccess(true);
			message.setRspModel(rsp.getResult().getModel());
			return message;
		}else{
			message.setSuccess(false);
			message.setErrorMsg(logInfo(rsp));
		}
		return message;
	}
}
