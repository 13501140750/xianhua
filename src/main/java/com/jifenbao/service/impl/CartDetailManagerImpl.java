/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.CartDetail;
import com.jifenbao.service.CartDetailManager;

/**
 *
 * @ClassName      CartDetailManagerImpl
 * @Description
 * CartDetail
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CartDetail对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-31 00:54:11
 * @version     1.0 
 *
 */

@Service(CartDetailManager.BEAN_NAME)
@Transactional
public class CartDetailManagerImpl extends MybatisServiceImpl<CartDetail, String> implements CartDetailManager {


	@SuppressWarnings("unchecked")
	@Override
	public List<CartDetail> findByIds(String[] cartDetailIds) {
		return super.findAll(entityClass.getSimpleName() + ".selectByIds", cartDetailIds);
	}

	@Override
	public void deleteByArrPK(String[] cartDetailIds) {
		super.findAll(entityClass.getSimpleName() + ".deleteByArrPK", cartDetailIds);
	}
    
    
}
