/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
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
import com.otc.framework.model.Order;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;
import com.jifenbao.model.Region;
import com.jifenbao.service.RegionManager;

/**
 *
 * @ClassName      RegionManagerImpl
 * @Description
 * Region
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Region对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-16 22:40:04
 * @version     1.0 
 *
 */

@Service(RegionManager.BEAN_NAME)
@Transactional
public class RegionManagerImpl extends MybatisServiceImpl<Region, Integer> implements RegionManager {

	@Override
	public List<Region> getProvinces() {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("deleteYn", YesNot.NOT.getCode());
		map.put("disabledYn", YesNot.NOT.getCode());
		map.put("level", "1");
		List<Order> orderBy = new ArrayList<Order>();
		orderBy.add(Order.asc("code"));
		map.put(DataTransferKey.ORDERBY_NAME, orderBy);
		return this.findByMap(map);
	}

	@Override
	public List<Region> getChildren(Integer parent) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("deleteYn", YesNot.NOT.getCode());
		map.put("disabledYn", YesNot.NOT.getCode());
		map.put("parent", parent);
		List<Order> orderBy = new ArrayList<Order>();
		orderBy.add(Order.asc("code"));
		map.put(DataTransferKey.ORDERBY_NAME, orderBy);
		return this.findByMap(map);
	}

	@Override
	public void batchDelete(Integer[] ids, String operUser) {
		for(Integer id:ids){
			Region bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDeleteYn(YesNot.YES.getCode());
  			this.modifyEntity(bean);
			}
		}
		
	}
	
	@Override
	public void batchDisabled(Integer[] ids, String operUser, String oper) {
		for(Integer id:ids){
			Region bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}
    
}
