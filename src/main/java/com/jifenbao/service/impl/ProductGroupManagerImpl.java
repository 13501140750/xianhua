/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductGroup;
import com.jifenbao.service.ProductGroupManager;

/**
 *
 * @ClassName      ProductGroupManagerImpl
 * @Description
 * ProductGroup
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductGroup对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-21 12:56:42
 * @version     1.0 
 *
 */

@Service(ProductGroupManager.BEAN_NAME)
@Transactional
public class ProductGroupManagerImpl extends MybatisServiceImpl<ProductGroup, Integer> implements ProductGroupManager {

	@Override
	public List<Product> getPrdListByGroupCode(String code) {
		return this.findAll(entityClass.getSimpleName()+".selectPrdListByGroupCode", code);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDelYnByGrpCode(String code) {
		// TODO Auto-generated method stub
		this.findAll(entityClass.getSimpleName()+".updateDelYnByGrpCode", code);
	}
    
	
}
