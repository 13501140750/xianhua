package com.jifenbao.thirdAPI;

import org.apache.commons.lang3.StringUtils;

import com.jifenbao.common.JfbUtil;
import com.jifenbao.common.PropertyConfig;

/** 
* @author 作者 wangyawei: 
* @version 创建时间：2017年11月30日 下午2:14:42 
* 类说明 
*/
public class WxPayConfig {
	
	/**支付相关信息*/
	//小程序appid
	public static final String api_id = "wx47bdcaa92f82ef60";  
    //微信支付的商户id  
    public static final String mch_id = "1493316982";  
    //微信支付的商户密钥  
    public static final String key = "6g2pto3agv37a2jm35uq9fv4vjqijpi2";  
    //支付成功后的服务器回调url  
    public static String notify_url = "https://wx.movie158.cn/wxpay/wxNotify";  
    //签名方式，固定值  
    public static final String SIGNTYPE = "MD5";  
    //交易类型，小程序支付的固定值为JSAPI  
    public static final String TRADETYPE = "JSAPI";  
    
    //微信统一下单接口地址  
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	//下载对账单接口地址
    public static final String bill_url = "https://api.mch.weixin.qq.com/pay/downloadbill";
    //申请退款接口地址
    public static final String refund_url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    //查询订单接口地址
    public static final String orderquery_url = "https://api.mch.weixin.qq.com/pay/orderquery";
    //查询退款接口地址
    public static final String refundquery_url = "https://api.mch.weixin.qq.com/pay/refundquery";
    
    
    
    
    /**下边登录相关信息*/
	
    //微信登录code 换取 session_key地址
	public static final String url = "https://api.weixin.qq.com/sns/jscode2session";
	//小程序的 app secret
	public static final String app_secret = "c3d408da31311cb3b82acd15ae01f446";
	//授权（必填）
    public static final String grant_type = "authorization_code";
	public static String p2Url = "/root/cert/apiclient_cert.p12";
	
	static{
		String p2url = PropertyConfig.getPropertyValue("p2Url");
		if(StringUtils.isNotBlank(p2Url)){
			p2Url = p2url;
		}
		String notifyUrl = PropertyConfig.getPropertyValue("wxPay.notifyUrl");
		if(StringUtils.isNotBlank(notifyUrl)){
			notify_url = PropertyConfig.getPropertyValue("wxPay.notifyUrl");
		}
	}
    
    //拼接登录获取session_keyurl
    public static String getRequestUrl(String jsCode){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(url).append("?")
    	.append("appid=")
    	.append(api_id)
    	.append("&secret=")
    	.append(app_secret)
    	.append("&js_code=")
    	.append(jsCode)
    	.append("&grant_type=")
    	.append(grant_type);
    	return buffer.toString();
    }
    
}
 