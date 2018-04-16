/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.common.JfbUtil;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.Refund;

/**
 *
 * @ClassName      ExchangeOrderDetailManager
 * @Description
 * ExchangeOrderDetail
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ExchangeOrderDetail对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-02-02 14:27:56
 * @version     1.0 
 *
 */

public interface ExchangeOrderDetailManager extends BaseManager<ExchangeOrderDetail, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "exchangeOrderDetailManager";
    
    
    
    /**
     * 通过主订单号查询子订单
     * @param orderCode
     * @return
     */
    public List<ExchangeOrderDetail>  getOrderDetailByOrderCode(String orderCode);
    
    /**
     * 子订单号
     * @param subOrderCode
     * @return
     */
    public ExchangeOrderDetail getOrderDetailBysubOrderCode(String subOrderCode);


    /**
     * 修改子订单退款状态
     */
    public void modifySubOrderRefundStatus(ExchangeOrder order);
    
    /**
     * 判断子订单中的商品是否为组合，如为组合则拆分多个子订单
     * @param detailList
     * @return
     */
    public ExchangeOrder getDetailListByProduct(ExchangeOrder order);
    /**
     * 判断子订单中的商品是否为组合，如为组合则拆分多个子订单
     * @param detailList
     * @return
     */
    public List<ExchangeOrderDetail>  getDetailListByProduct( List<ExchangeOrderDetail> detailList);
    
    /**
     * 更换订单中的商品
     * @param order
     * @param oldDetailList
     * @param newDetailList
     */
    public void exchangeProduct(ExchangeOrder order,Refund refund);
    
    /**
     * 保存订单详情，如产品为组合产品，则拆分子订单
     * @param detailOrder
     */
    public void addDetailOrder(ExchangeOrderDetail detailOrder);
    
    
    
    /**
     * 生成subOrderCode
     */
    public String genSubCode();

	/**
	 * 修改佣金审核状态
	 * @param detail
	 */
	public void updateCheckStatus(ExchangeOrderDetail detail);
    
}
