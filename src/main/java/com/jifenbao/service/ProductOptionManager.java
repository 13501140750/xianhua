/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.Map;

import com.jifenbao.model.ProductOption;

/**
 *
 * @ClassName      ProductOptionManager
 * @Description
 * ProductOption
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductOption对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2017-12-03 15:55:25
 * @version     1.0 
 *
 */

public interface ProductOptionManager extends BaseManager<ProductOption, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productOptionManager";




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

	public void deleteByMap(Map<String, Object> optionMap);

}
