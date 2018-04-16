/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.Map;

import com.jifenbao.model.Refund;

/**
 *
 * @ClassName      RefundManager
 * @Description
 * Refund
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Refund对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-06-08 10:55:28
 * @version     1.0 
 *
 */

public interface RefundManager extends BaseManager<Refund, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "refundManager";
    /**
     * 生成随机退款单号
     * @return
     */
    public String genCode();
    
    /**
     * 新增退款单
     * @param refund
     * @param orderId
     */
    public void addEntity(Refund refund,Long orderId);

    /**
     * 同意退换货
     */
    public void agreeRefund(Refund refund);
    
    /**
     * 拒绝退换货
     */
    public void refuseRefund(Refund refund);
    
    /**
     * 收到退换货
     * @param refund
     */
    public void receiveGoods(Refund refund);
    
    /**
     * 申请退款或退货时退还积分或重置卡号状态
     * @param refund
     */
    public  void  backPriceOrCard(Refund refund);

	/**
	 * 退款
	 * @param transaction_id
	 * @param out_refund_no
	 * @param all_total_fee
	 * @param refund_fee
	 * @return
	 */
	Map<String, String> wechatRefund(String transaction_id, String out_refund_no, int all_total_fee, int refund_fee);

}
