/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.History;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductCategory;
import com.jifenbao.service.HistoryManager;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName      HistoryManagerImpl
 * @Description
 * History
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对History对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-25 10:35:51
 * @version     1.0 
 *
 */

@Service(HistoryManager.BEAN_NAME)
@Transactional
public class HistoryManagerImpl extends MybatisServiceImpl<History, Long> implements HistoryManager {
    
	@SuppressWarnings("unchecked")
	public List<ProductCategory> queryHistoryProCatsByUser(Map<String,Object>  map){
    	return this.findAll(entityClass.getSimpleName()+".selectHistoryProCatsByUser", map);
    }

	@SuppressWarnings("unchecked")
	public List<Product> queryHistoryProsByUser(Map<String,Object>  map){

    	 List<Product> list = this.findAll(entityClass.getSimpleName()+".selectHistoryProsByUser", map);
    	 
    	 return list;
    }
	 
	public int deleteByCon(Map<String,Object>  map){
	   return super.update(entityClass.getSimpleName()+".deleteByCon", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findHistoryDays(Map<String,Object> map) {
		return super.findAll(entityClass.getSimpleName()+".selectHistoryDays", map);
	}
}
