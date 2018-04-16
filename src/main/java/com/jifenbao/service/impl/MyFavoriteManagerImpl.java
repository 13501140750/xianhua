/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.MyFavorite;
import com.jifenbao.model.Product;
import com.jifenbao.service.MyFavoriteManager;
import com.jifenbao.service.ProductManager;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.page.Page;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      MyFavoriteManagerImpl
 * @Description
 * MyFavorite
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对MyFavorite对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-29 14:33:06
 * @version     1.0 
 *
 */

@Service(MyFavoriteManager.BEAN_NAME)
@Transactional
public class MyFavoriteManagerImpl extends MybatisServiceImpl<MyFavorite, Long> implements MyFavoriteManager {

	  @Resource
	  ProductManager productManager;
	/*
	 * (non-Javadoc)
	 * @see com.jifenbao.service.MyFavoriteManager#getCountByProduct(java.lang.String)
	 */
	@Override
	public int getCountByProduct(String productCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productCode", productCode);
		return this.getCount(map);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jifenbao.service.MyFavoriteManager#addToFavorite(java.lang.String, java.lang.String)
	 */
	@Override
	public void addToFavorite(String productCode, String customerName) {
		MyFavorite favorite = new MyFavorite();
		favorite.setProductCode(productCode);
		favorite.setCustomName(customerName);
		if(!this.isExists(favorite)){
			Product bean = productManager.findUniqueByProperty("code", productCode);
			if(bean!=null){
				favorite.setCreateTime(DateTimeUtil.now());
				favorite.setCreateUser(customerName);
				favorite.setDisabledYn(YesNot.NOT.getCode());
				favorite.setDeleteYn(YesNot.NOT.getCode());
				favorite.setProductCatCode(bean.getPrdCatCode());
				this.addEntity(favorite);
			}
			
		}else{
			throw new BusinessException("已收藏过此商品");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Page<MyFavorite> selectMyfavoriteProsByUserPage(Map<String,Object> params, int pageNo, int pageSize){
		return this.findPageByMap(entityClass.getSimpleName()+".selectMyfavoriteProsByUserPage", entityClass.getSimpleName()+".selectMyfavoriteProsByUserPageCount", pageNo, pageSize, params);
	}
    
    
}
