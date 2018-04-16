package com.jifenbao.common.constants;

public interface TaoBaoConstants {
	
	/**
	 * 请求地址
	 */
	String REQUESTURL = "http://gw.api.taobao.com/router/rest";

	/**
	 * 淘宝的key
	 */
	String APPKEY = "23346442";
	
	/**
	 * 淘宝 app secret
	 */
	//String APPSECRET = "e44558d3d224f82d2dc767c69964978b"; 2017-03-01
	String APPSECRET = "dcdf30d08e87f94e1c70415c5866a30a";
	
	
	
	/**
	 * 注册时签名
	 */
    String  sms_sign_name_regsit="注册验证";
	
	/**
	 * 登录验证签名
	 */
	String  sms_sign_name_login="登录验证";
    
    /**
     * 登录验证签名
     */
    String  sms_sign_name_notice="积分宝平台";
    
    /**
     * 订单发货签名
     */
    String  sms_sign_name_sendOutGoods="方圆礼业";
    
    /**
     * 登录验证签名
     */
    String  sms_sign_name_auth="身份验证";
    /**
     * 发送取票号签名
     */
    String  sms_sign_name_ticket="中影汇";
    /**
     * 发送会员卡信息签名
     */
    String  sms_sign_name_sendMemberCard="身份验证";
	
	/**
	 * 短信注册模版ID
	 * 模版内容：验证码${code}，您正在注册成为${product}用户，感谢您的支持！
	 */
	//String sms_template_regsit="SMS_7800470";
	String sms_template_regsit="SMS_7800470";
	/**
	 * 短信登录模版ID
	 * 模版内容：验证码${code}，您正在登录${product}，若非本人操作，请勿泄露。
	 */
	//String sms_template_login="SMS_7800472";
	 String sms_template_login="SMS_7800472";
	/**
	 * 身份验证
	 * 模版内容：${name}; 示例：尊敬的${name}，您的快递已飞奔的路上，将会尽快送达您的手里，请注意接收
	 */
	String sms_template_notice="SMS_7760469";
//	 String sms_template_notice="SMS_7800469";
	/**
	 * 身份验证
	 * 模版内容：验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！
	 */
	String sms_template_auth="SMS_7800474";
	
	/**
	 * 取票验证码
	 * 模版内容：${filmCodeInfo}，如有问题请咨询积分宝客服：4000659958,祝观影愉快！
	 */
	String sms_template_ticket="SMS_11855084";
	
	/**
	 * 发送会员卡信息
	 * 模版内容： {name},您好！您在积分宝平台购买的会员卡购买成功，会员卡信息如下，请您妥善保管使用：{cardMsg}
	 */
	String sms_template_sendMemberCard="SMS_12495256";
	
	/**
	 * 订单发货用户提醒短信
	 * 收件人为${name}的订单商品已发货，[物流公司：${expressCompany}，物流单号：${expressNumber}]，物流信息可能会有延迟更新状态，请保持电话畅通，耐心等待！
	 */
	String sms_template_sendOutGoods="SMS_71295178";
	
	
	
}
