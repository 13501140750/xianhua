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

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.model.Order;
import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.FreightCompany;
import com.jifenbao.service.FreightCompanyManager;

/**
 *
 * @ClassName      FreightCompanyManagerImpl
 * @Description
 * FreightCompany
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对FreightCompany对象的CRUD函数.
 *
 * @author      kevin.wang
 * @Date        2015-12-13 23:17:35
 * @version     1.0 
 *
 */

@Service(FreightCompanyManager.BEAN_NAME)
@Transactional
public class FreightCompanyManagerImpl extends MybatisServiceImpl<FreightCompany, Integer> implements FreightCompanyManager {

	@Override
	public List<FreightCompany> findAllFreightCompany() {
		
		   Map<String,Object> map = new HashMap<String,Object>();
	       // map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
	       List<Order> orderList = new ArrayList<Order>();
	       orderList.add(Order.desc(DataTransferKey.DELETE_YN));
	       orderList.add(Order.asc("sort"));
	       orderList.add(Order.asc("freightName"));
	       map.put(DataTransferKey.ORDERBY_NAME,orderList);
	       map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		  return this.findByMap(map);
	}

	@Override
	public String getFreightNameByName(String freightCode) {
		if(StringUtils.isNotBlank(freightCode)){
			return (String) this.findUniqueBy(entityClass.getSimpleName()+".getFreightNameByName", freightCode);	
		}else{
			return "";
		}
		
		
	}
    
    
}
