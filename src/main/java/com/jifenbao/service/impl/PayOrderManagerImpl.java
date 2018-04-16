/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.Order;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;
import com.jifenbao.common.JsonHelper;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.PayOrder;
import com.jifenbao.service.PayOrderManager;
import com.jifenbao.service.result.BaseResult;
import com.jifenbao.service.result.SingleResult;
import com.jifenbao.thirdAPI.aliPay.config.AlipayConfig;
import com.jifenbao.thirdAPI.aliPay.util.AlipaySubmit;

/**
 *
 * @ClassName      PayOrderManagerImpl
 * @Description
 * PayOrder
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对PayOrder对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-05-24 09:17:44
 * @version     1.0 
 *
 */

@Service(PayOrderManager.BEAN_NAME)
@Transactional
public class PayOrderManagerImpl extends MybatisServiceImpl<PayOrder, Long> implements PayOrderManager {

	@Value(value = "${alipay_show_url}")
	String alipay_show_url;
	@Value(value = "${alipay_return_url}")
	String alipay_return_url;
	@Value(value = "${alipay_notify_url}")
	String alipay_notify_url;
	
	@Override
	public PayOrder getPayOrderFromExchangeOrder(ExchangeOrder order) {
		//校验当期支付订单状态
		PayOrder payOrder = new PayOrder();
		payOrder.setCporderid(order.getOrderCode());
		payOrder.setCompanyCode(order.getCompanyCode());
		payOrder.setPrice(order.getPrice());
		payOrder.setAppuserid(order.getCustomerName());
		payOrder.setSendtime(DateTimeUtil.format(DateTimeUtil.now(), "yyyyMMddHHmmss"));
		//Double totlePrice = 0.0;
		if(order.getOrderDetailList()!=null){
			//ExchangeOrderDetail detail = order.getOrderDetailList().get(0);
			String wasename = "";
			
			if(order.getConvertWay().equals("C3") || order.getConvertWay().equals("C4")){
				wasename = "自定义面值卡";
			}else{
				for(ExchangeOrderDetail detail:order.getOrderDetailList()){
//					wasename += detail.getGiftcard().getTitle()+",";
					//totlePrice += difetail.getPrice()*detail.getProductCount();
				}
				if(wasename.endsWith(",")){
					wasename = wasename.substring(0, wasename.length()-1);
				}
			}
			
			
			payOrder.setWaresname(wasename);
		}
		//payOrder.setPrice(totlePrice);
		return payOrder;
	}

	@Override
	public String getAlipayString(PayOrder payOrder) {
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.service);
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_id", AlipayConfig.seller_id);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", AlipayConfig.payment_type);
		sParaTemp.put("notify_url", AlipayConfig.notify_url);
		sParaTemp.put("return_url", AlipayConfig.return_url);
		sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
		sParaTemp.put("out_trade_no", payOrder.getCporderid());
		sParaTemp.put("subject", payOrder.getWaresname());
		sParaTemp.put("total_fee", payOrder.getPrice()+"");
		sParaTemp.put("body", payOrder.getAppuserid());
        //String strResult = AlipaySubmit.buildRequest("", "", param);
        String strResult = AlipaySubmit.buildRequest(sParaTemp, "post", "确认");
        return strResult;
	}

	@Override
	public void updatePayResp(PayOrder payOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cporderid", payOrder.getCporderid());
		map.put("resultisnull", "1");
//		map.put("price", payOrder.getPrice());
		
		List<PayOrder> list = this.findByMap(map);
		if(list!=null && !list.isEmpty()){
			PayOrder newOrder = list.get(0);
			newOrder.setTransid(payOrder.getTransid());
			newOrder.setTranstime(payOrder.getTranstime());
			newOrder.setResult(payOrder.getResult());
			newOrder.setBuyerId(payOrder.getBuyerId());
			newOrder.setUpdateUser("微信通知");
			newOrder.setUpdateTime(DateTimeUtil.now());
			this.update(newOrder);
		}
		
	}
    
	
	public BaseResult checkPayOrderStatus(ExchangeOrder order){
		BaseResult result = new BaseResult();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cporderid", order.getOrderCode());
		map.put("resultisnotcussess", "0");
		
		List<PayOrder> list = this.findByMap(map);
		if(list!=null && !list.isEmpty()){//查询是否已存在支付成功的订单
			PayOrder oldPayOrder = list.get(0);
			if(StringUtils.isBlank(oldPayOrder.getResult())){
				result.setSuccess(false);
				result.setErrorMsg("订单正在付款中，不能重复支付");
			}
			result.setSuccess(true);
		}else{
			result.setSuccess(true);
		}
		return result;
	}
    
}
