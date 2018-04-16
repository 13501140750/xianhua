package com.jifenbao.common.constants;

public interface CreditLogActionType {

	/**
	 * 积分交易类型：企业发放积分
	 */
	String CUSTOMER_RECIEVE = "1";

	/**
	 * 积分交易类型：兑换礼品
	 */
	String CUSTOMER_EXCHANGE_GOODS = "2";
	

	/**
	 * 积分交易类型：卡册兑换
	 */
	String CUSTOMER_CARD_EXCHANGE = "3";

	/**
	 * 积分交易类型：退货
	 */
	String CUSTOMER_RETURN_GOODS = "4";
	/**
	 * 积分交易类型：交易订单取消
	 */
	String CUSTOMER_EXCHANGE_CANCEL = "5";
	
	/**
	 * 积分交易类型：积分兑换电影票
	 */
	String CUSTOMER_EXCHANGE_FILMGOODS = "6";
	
	/**
	 * 积分交易类型：会员卡充值积分
	 */
	String FILMCARD_RECHARGE = "7";
	/**
	 * 积分交易类型：卡合并积分
	 */
	String CARD_MERGE = "8";
	/**
	 * 积分交易类型：运动场馆订单消费
	 */
	String EXCHANGE_SPORT = "9";
	
	
	
}
