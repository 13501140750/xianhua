/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
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

import com.jifenbao.model.ProductComment;
import com.jifenbao.service.ProductCommentManager;

/**
 *
 * @ClassName      ProductCommentManagerImpl
 * @Description
 * ProductComment
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductComment对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-06 17:18:38
 * @version     1.0 
 *
 */

@Service(ProductCommentManager.BEAN_NAME)
@Transactional
public class ProductCommentManagerImpl extends MybatisServiceImpl<ProductComment, Long> implements ProductCommentManager {

	@Override
	public ProductComment findUniqueByprdCodeAndComCode(String productCode, String companyCode) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("productCode", productCode);
		map.put("companyCode", companyCode);
		return (ProductComment)this.findUniqueBy(entityClass.getSimpleName()+".getByprdCodeAndComCode", map);
	}

	@Override
	public void saveAll(List<ProductComment> list) {
		super.batchInsert(entityClass, list);
	}

	@Override
	public void deleteCommentByCompanyCode(String companyCode) {
		// TODO Auto-generated method stub
		ProductComment comment = new ProductComment();
		comment.setCompanyCode(companyCode);
		super.deleteEntity(comment);
	}
    
    
}
