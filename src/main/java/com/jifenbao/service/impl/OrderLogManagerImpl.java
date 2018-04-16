/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.OrderLog;
import com.jifenbao.service.FreightCompanyManager;
import com.jifenbao.service.OrderLogManager;

/**
 *
 * @ClassName      OrderLogManagerImpl
 * @Description
 * OrderLog
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对OrderLog对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-02-26 10:06:54
 * @version     1.0 
 *
 */

@Service(OrderLogManager.BEAN_NAME)
@Transactional
public class OrderLogManagerImpl extends MybatisServiceImpl<OrderLog, Long> implements OrderLogManager {

	 @Resource
	 FreightCompanyManager  freightCompanyManager;
	
	@Override
	public void addOrderLog(ExchangeOrder order) {
		Date now = DateTimeUtil.now();
		//添加订单日志信息
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderCode(order.getOrderCode());
        orderLog.setExectTime(now);
        if(order.getOrderStatus().equals("WAIT_ADUIT") || order.getOrderStatus().equals("NO_PAY")){
        	orderLog.setExectPerson(order.getCreateUser());
        }else{
        	orderLog.setExectPerson(order.getUpdateUser());
        }
        ////操作人需要判断是客户还是后台
        orderLog.setLogStatusName(order.getOrderStatus());
        orderLog.setLogcomment("");
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLog.setCreateUser(order.getCreateUser());
        orderLog.setUpdateUser(order.getUpdateUser());
        
        orderLog.setExpressCompany(freightCompanyManager.getFreightNameByName(order.getExpressCompany()));
        orderLog.setExpressNumber(order.getExpressNumber());
        
        String logComment = "";
        if(order.getOrderStatus().equals("NO_PAY")){
        	 logComment = "您的订单未支付，请尽快进行支付";
        	 orderLog.setExectPerson("客户");
        }
        if(order.getOrderStatus().equals("WAIT_ADUIT")){
        	logComment = "您提交了订单，请等待系统确认";
        	 orderLog.setExectPerson("客户");
        }
        else if(order.getOrderStatus().equals("WAIT_SELLER_SEND_GOODS")){
        	logComment = "您的订单已进入库房，准备出库";
        }
        else if(order.getOrderStatus().equals("WAIT_BUYER_CONFIRM_GOODS")){
        	String friName = freightCompanyManager.getFreightNameByName(order.getExpressCompany());
        	logComment = "商品移交给"+friName+"，运单号为:"+order.getExpressNumber();
        }
        
        else if(order.getOrderStatus().equals("TRADE_FINISHE")){
        	logComment = "客户已收货成功，订单完成";
        }
        else if(order.getOrderStatus().equals("TRADE_CLOSED")){
        	logComment = "订单已取消，取消原因："+order.getRefundReason()+"。订单关闭";
        }
        
        orderLog.setLogcomment(logComment);
        this.addEntity(orderLog);
	}
	
	
	
	public void addOrderLog(ExchangeOrder order,String info) {
		Date now = DateTimeUtil.now();
		//添加订单日志信息
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderCode(order.getOrderCode());
        orderLog.setExectTime(now);
        orderLog.setExectPerson(order.getUpdateUser());
        orderLog.setLogStatusName(order.getOrderStatus());
        /*orderLog.setExpressCompany(order.getExpressCompany());
        orderLog.setExpressNumber(order.getExpressNumber());
        orderLog.setLogcomment("");*/
        
        
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLog.setCreateUser(order.getUpdateUser());
        orderLog.setUpdateUser(order.getUpdateUser());
        orderLog.setLogcomment(info);
        this.addEntity(orderLog);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLog> findOrderLogByOrderCode(String orderCode) {
		return this.findAll(entityClass.getSimpleName()+".selectOrderLogByOrderCode", orderCode);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrderLog> findOrderLogByOrderCode(String orderCode, String orderType) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderCode", orderCode);
		map.put("orderType", orderType);
		return this.findAll(entityClass.getSimpleName()+".getOrderLogByOrderType", map);
	}
    
    
}
