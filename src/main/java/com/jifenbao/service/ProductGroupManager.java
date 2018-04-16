/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.model.Product;
import com.jifenbao.model.ProductGroup;

/**
 *
 * @ClassName      ProductGroupManager
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

public interface ProductGroupManager extends BaseManager<ProductGroup, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productGroupManager";
    
    /**
     * 通过产品组合编码获取产品列表
     * @param code
     * @return
     */
    public List<Product>  getPrdListByGroupCode(String code);
    
    /**
     * 通过组合ID修改删除标记
     * @param code
     */
    public  void updateDelYnByGrpCode(String code);


}
