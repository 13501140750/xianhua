/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.page.Page;
import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.Product;
import com.jifenbao.model.ProductRs;

/**
 *
 * @ClassName      ProductRsManager
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

public interface ProductRsManager extends BaseManager<ProductRs, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productRsManager";
    
    /**
     * 批量操作热卖或推荐
     * @param ids
     * @param operUser
     * @param oper
     */
    public  void batOperHotAndRecommend(String[] ids,String operUser,Integer oper);

    /**
     * 校验此产品是否已经添加了操作
     * @param productCode
     * @param oper
     */
    public  boolean  checkProductRs(String productCode,Integer oper);
    
    /**
     * 获取首页热卖推荐商品
     * @return
     */
    public Page<ProductRs> getFrontRecommend(Map<String,Object> map,int pageNo,int pageSize);

    
}
