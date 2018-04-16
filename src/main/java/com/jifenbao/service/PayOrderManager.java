/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.PayOrder;
import com.jifenbao.service.result.BaseResult;

/**
 *
 * @ClassName      PayOrderManager
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

public interface PayOrderManager extends BaseManager<PayOrder, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "payOrderManager";
    
    /**
     * 通过订单获取支付信息
     * @param order
     * @return
     */
    PayOrder getPayOrderFromExchangeOrder(ExchangeOrder order); 
    
    /**
     * 获取支付宝支付url
     * @param payOrder
     * @return
     */
    String getAlipayString(PayOrder payOrder); 
    
    
    void updatePayResp(PayOrder payOrder);

    /**
     * 校验支付订单状态，是否可以支付
     * @param payOrder
     * @return
     */
    BaseResult checkPayOrderStatus(ExchangeOrder order);
}
