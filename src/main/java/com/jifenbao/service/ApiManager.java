/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.Api;

/**
 *
 * @ClassName      ApiManager
 * @Description
 * Api
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Api对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-16 15:06:29
 * @version     1.0 
 *
 */

public interface ApiManager extends BaseManager<Api, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "apiManager";




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
