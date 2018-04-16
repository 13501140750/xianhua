/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.Warehouse;
import com.jifenbao.service.WarehouseManager;

/**
 *
 * @ClassName      WarehouseManagerImpl
 * @Description
 * Warehouse
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Warehouse对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-28 11:48:49
 * @version     1.0 
 *
 */

@Service(WarehouseManager.BEAN_NAME)
@Transactional
public class WarehouseManagerImpl extends MybatisServiceImpl<Warehouse, Integer> implements WarehouseManager {

	@SuppressWarnings("unchecked")
	@Override
	public List<Warehouse> getWarehoseByCompanyCode(Map<String,Object> map) {
		return this.findAll(entityClass.getSimpleName()+".selectWarehoseByCompanyCode",map);
	}

	@Override
	public List<Warehouse> findAllWarehose() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("disabledYn", "0");
		map.put("deleteYn", "0");
		return this.findByMap(map);
	}
    
    
}
