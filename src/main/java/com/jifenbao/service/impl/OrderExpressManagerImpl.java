/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.OrderExpress;
import com.jifenbao.service.OrderExpressManager;

/**
 *
 * @ClassName      OrderExpressManagerImpl
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

@Service(OrderExpressManager.BEAN_NAME)
@Transactional
public class OrderExpressManagerImpl extends MybatisServiceImpl<OrderExpress, Long> implements OrderExpressManager {

	@Override
	public void addOrderExpressByOrder(ExchangeOrder bean) {
		
		OrderExpress expree =  new OrderExpress();
		expree.setOrderCode(bean.getOrderCode());
		expree.setExpressNumber(bean.getExpressNumber());
		expree.setFreightCode(bean.getExpressCompany());
		expree.setExpressPrice(bean.getExpressPrice());
	}

	
    
}
