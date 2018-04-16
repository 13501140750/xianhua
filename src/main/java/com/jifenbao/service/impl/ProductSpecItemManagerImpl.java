/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */

package com.jifenbao.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

import com.jifenbao.model.ProductSpecItem;
import com.jifenbao.service.ProductSpecItemManager;

/**
 *
 * @ClassName      ProductSpecItemManagerImpl
 * @Description
 * ProductSpecItem
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductSpecItem对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2017-11-28 11:10:14
 * @version     1.0 
 *
 */

@Service(ProductSpecItemManager.BEAN_NAME)
@Transactional
public class ProductSpecItemManagerImpl extends MybatisServiceImpl<ProductSpecItem, Long> implements ProductSpecItemManager {
    
    
	
	
	@Override
	public void batchDelete(Long[] ids, String operUser) {
		for(Long id:ids){
			ProductSpecItem bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDeleteYn(YesNot.YES.getCode());
  			this.modifyEntity(bean);
			}
		}
		
	}
	
	@Override
	public void batchDisabled(Long[] ids, String operUser, String oper) {
		for(Long id:ids){
			ProductSpecItem bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}

	@Override
	public void deleteByMap(Map<String, Object> map) {
		super.update(entityClass.getSimpleName() + ".deleteByMap", map);
	}
}
