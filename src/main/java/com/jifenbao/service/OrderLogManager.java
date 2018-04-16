/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.OrderLog;

/**
 *
 * @ClassName      OrderLogManager
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

public interface OrderLogManager extends BaseManager<OrderLog, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "orderLogManager";

    /**
     * 保存订单的日志信息
     * @param order
     */
    public void addOrderLog(ExchangeOrder order);
    
    /**
     * 保存订单的日志信息，日志具体内容为参数
     * @param order
     * @param info
     * @return
     */
    public void addOrderLog(ExchangeOrder order,String info);
    /**
     * 通过订单号获取日志信息
     * @param orderCode
     * @return
     */
    public  List<OrderLog>  findOrderLogByOrderCode(String orderCode);
    
    /**
     * 通过订单号和订单类型查询订单日志
     * @param orderCode
     * @param type
     * @return
     */
    public  List<OrderLog>  findOrderLogByOrderCode(String orderCode,String orderType); 
    
} 
