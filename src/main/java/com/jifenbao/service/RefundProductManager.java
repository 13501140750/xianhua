/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.Product;
import com.jifenbao.model.Refund;
import com.jifenbao.model.RefundProduct;

/**
 *
 * @ClassName      RefundProductManager
 * @Description
 * RefundProduct
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对RefundProduct对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-06-17 13:28:25
 * @version     1.0 
 *
 */

public interface RefundProductManager extends BaseManager<RefundProduct, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "refundProductManager";

    /**
     * 保存售后中换货的商品信息
     * @param detailOrder  原子订单
     * @param refund       售后订单
     */
    public  void  saveExchangeProductInfo(ExchangeOrderDetail detailOrder,Refund refund);
    
    /**
     * 通过售后订单号查询退换货产品信息
     * @param refundOrder
     * @return
     */
    public List<Product> getExchangeProduct(String refundCode,String orderCode);
}
