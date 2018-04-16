/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.OrderExpress;

/**
 *
 * @ClassName      OrderExpressManager
 * @Description
 * OrderExpress
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对OrderExpress对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-02-25 17:35:15
 * @version     1.0 
 *
 */

public interface OrderExpressManager extends BaseManager<OrderExpress, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "orderExpressManager";


    public void addOrderExpressByOrder(ExchangeOrder bean);
    
}
