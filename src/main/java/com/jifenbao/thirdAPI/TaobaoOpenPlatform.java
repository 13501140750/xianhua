package com.jifenbao.thirdAPI;

import com.jifenbao.common.constants.TaoBaoConstants;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.TaobaoResponse;

/**
 * @author liujing
 */
public class TaobaoOpenPlatform {
	
	
	protected static TaobaoClient client;
	/**
	 * just log the response
	 * 
	 * @param response
	 */
	protected static String logInfo(TaobaoResponse response) {
		StringBuilder sb = new StringBuilder();
		
			sb.append("errorCode:").append(response.getErrorCode())
					.append(",msg:").append(response.getMsg())
					.append(",subCode:").append(response.getSubCode())
					.append(",subMsg:").append(response.getSubMsg())
					.append(",body:").append(response.getBody());
			System.out.println(sb.toString());
		
		return sb.toString();
	}


	public static String getSessionKey() {
		return  TaoBaoConstants.APPKEY;
	}
	
	
	public static String getSubSessionKey() {
		return  TaoBaoConstants.APPSECRET;
	}
	
	public static TaobaoClient getClient(){
			String server = TaoBaoConstants.REQUESTURL;
			String key = TaoBaoConstants.APPKEY;
			String secret =   TaoBaoConstants.APPSECRET;
			return new DefaultTaobaoClient(server, key,secret);
	}
	
	
	

	
}
