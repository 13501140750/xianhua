/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.ProductParam;

/**
 *
 * @ClassName      ProductParamManager
 * @Description
 * ProductParam
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductParam对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2017-11-28 11:04:14
 * @version     1.0 
 *
 */

public interface ProductParamManager extends BaseManager<ProductParam, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productParamManager";




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

}
