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
import com.otc.framework.exception.BusinessErrorCode;
import com.otc.framework.model.Order;
import com.otc.framework.page.Page;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductRs;
import com.jifenbao.service.ProductRsManager;
import com.jifenbao.service.result.ResultHelper;

/**
 *
 * @ClassName      ProductRsManagerImpl
 * @Description
 * ProductRs
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductRs对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-16 17:11:13
 * @version     1.0 
 *
 */

@Service(ProductRsManager.BEAN_NAME)
@Transactional
public class ProductRsManagerImpl extends MybatisServiceImpl<ProductRs, Integer> implements ProductRsManager {

	@Override
	public void batOperHotAndRecommend(String[] ids, String operUser, Integer oper) {
		for(String id:ids){
			if(this.checkProductRs(id, oper)){
				 ProductRs bean = new  ProductRs();
				 bean.setProductCode(id);
				 bean.setDisabledYn(YesNot.NOT.getCode());
                 bean.setDeleteYn(YesNot.NOT.getCode());
                 bean.setCreateUser(operUser);
                 bean.setCreateTime(DateTimeUtil.now());
                 bean.setRecommendId(oper);
                 bean.setSort(0);
                 this.addEntity(bean);
			}
		}
		
	}

	@Override
	public boolean checkProductRs(String productCode, Integer oper) {
		
		 ProductRs bean = new  ProductRs();
    	 bean.setProductCode(productCode);
    	 bean.setDeleteYn(YesNot.NOT.getCode());
    	 bean.setRecommendId(oper);
    	 if(this.isExistsProperty(bean)){
    		 return false;
    	 }else{
    		 return true;
    	 }
	}

	 @Override
	  public Page<ProductRs> getFrontRecommend(Map<String,Object> map,int pageNo,int pageSize) {
		//Map<String,Object> map = new HashMap<String,Object>();
        //map.put("type", "2");
        List<Order> orderby = new ArrayList<Order>();
        orderby.add(Order.asc("sort"));
        orderby.add(Order.desc("id"));
        map.put(DataTransferKey.ORDERBY_NAME, orderby);
		return this.findPage(map, pageNo, pageSize);
	}


    
    
}
