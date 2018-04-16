/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.ProductEvaluate;

/**
 *
 * @ClassName      ProductEvaluateManager
 * @Description
 * ProductEvaluate
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductEvaluate对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2017-12-19 12:38:06
 * @version     1.0 
 *
 */

public interface ProductEvaluateManager extends BaseManager<ProductEvaluate, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productEvaluateManager";




    /**
     * 批量删除
     * @param ids
     * @param operUser
     */
    public void batchDelete(Integer[] ids,String operUser);
	
	/**
     * 批量启用或禁用
     * @param ids
     * @param operUser
     */
	public void batchDisabled(Integer[] ids, String operUser, String oper);

}
