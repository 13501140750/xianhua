/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.DeliveryAddress;
import com.jifenbao.service.DeliveryAddressManager;

/**
 *
 * @ClassName DeliveryAddressManagerImpl
 * @Description DeliveryAddress 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对DeliveryAddress对象的CRUD函数.
 *
 * @author liujing
 * @Date 2016-02-09 10:21:56
 * @version 1.0
 *
 */

@Service(DeliveryAddressManager.BEAN_NAME)
@Transactional
public class DeliveryAddressManagerImpl extends MybatisServiceImpl<DeliveryAddress, Long>
        implements DeliveryAddressManager {

	@Override
	public List<DeliveryAddress> sortAddressListByDefault(List<DeliveryAddress> addressList) {
		List<DeliveryAddress> sortedAddressList = new ArrayList<DeliveryAddress>();
		if (addressList != null && addressList.size() > 0) {
			for (DeliveryAddress item : addressList) {
				if (item.getDefaulted() != null && item.getDefaulted()) {
					sortedAddressList.add(item);
					break;
				}
			}
			for (DeliveryAddress item : addressList) {
				if (item.getDefaulted() == null || !item.getDefaulted()) {
					sortedAddressList.add(item);
				}
			}
		}
		return sortedAddressList;
	}

	@Override
	public void modifyDefault(Long id,Long customerId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("defaulted", true);
		map.put("customerId", customerId);
		map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
		// 取消默认设置
		List<DeliveryAddress> list = this.findByMap(map);
		for (DeliveryAddress da : list) {
			da.setDefaulted(false);
			this.update(da);
		}
		// 新增默认设置
		DeliveryAddress da = this.getEntity(id);
		da.setDefaulted(true);
		this.update(da);
	}

	@Override
	public void modifyDefault(Long id, Long customerId, Integer type) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(type==null)
			type = 0;
		map.put("type", type);
		map.put("defaulted", true);
		map.put("customerId", customerId);
		map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
		// 取消默认设置
		List<DeliveryAddress> list = this.findByMap(map);
		for (DeliveryAddress da : list) {
			da.setDefaulted(false);
			this.update(da);
		}
		// 新增默认设置
		DeliveryAddress da = this.getEntity(id);
		da.setDefaulted(true);
		this.update(da);
		
	}

	

}
