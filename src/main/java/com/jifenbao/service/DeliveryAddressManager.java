/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jifenbao.model.DeliveryAddress;

/**
 *
 * @ClassName DeliveryAddressManager
 * @Description DeliveryAddress 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对DeliveryAddress对象的CRUD函数.
 *
 * @author liujing
 * @Date 2016-02-09 10:21:56
 * @version 1.0
 *
 */

public interface DeliveryAddressManager extends BaseManager<DeliveryAddress, Long> {
	/**
	 * Bean名称
	 */
	String BEAN_NAME = "deliveryAddressManager";

	/**
	 * 默认地址排序到前面
	 * 
	 * @param addressList
	 * @return
	 */
	List<DeliveryAddress> sortAddressListByDefault(List<DeliveryAddress> addressList);

	/**
	 * 设置默认收货地址
	 * 
	 * @param id
	 */
	void modifyDefault(Long id,Long customerId);
	
	

	public void modifyDefault(Long id,Long customerId,Integer type) ;

}
