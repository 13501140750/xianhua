/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.Map;

import com.jifenbao.model.ProductSpecItem;

/**
 *
 * @ClassName      ProductSpecItemManager
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

public interface ProductSpecItemManager extends BaseManager<ProductSpecItem, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productSpecItemManager";




    /**
     * 批量删除
     * @param ids
     * @param operUser
     */
    public void batchDelete(Long[] ids,String operUser);
	
	/**
     * 批量启用或禁用
     * @param ids
     * @param operUser
     */
	public void batchDisabled(Long[] ids, String operUser, String oper);

	public void deleteByMap(Map<String, Object> map);

}
