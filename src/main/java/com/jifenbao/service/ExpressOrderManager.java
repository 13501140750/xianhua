/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExpressOrder;
import com.jifenbao.model.Warehouse;

/**
 *
 * @ClassName ExpressOrderManager
 * @Description ExpressOrder 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对ExpressOrder对象的CRUD函数.
 *
 * @author liujing
 * @Date 2016-04-29 13:13:48
 * @version 1.0
 *
 */

public interface ExpressOrderManager extends BaseManager<ExpressOrder, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "expressOrderManager";

    /**
     * 通过快递鸟 在线下单
     * 
     * @param userId
     * @param order
     * @param warehouse
     * @return
     * @throws Exception
     */
    ExpressOrder addExpressOrderByKDN(String userId, ExchangeOrder order, Warehouse warehouse, String filePath) throws Exception;

    
    /**
     * 发货时保存快递信息
     * @param bean
     */
    public void addOrderExpressByOrder(ExchangeOrder bean);
}
