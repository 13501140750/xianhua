/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.Recommend;

/**
 *
 * @ClassName      RecommendManager
 * @Description
 * Recommend
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Recommend对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2017-12-26 16:31:36
 * @version     1.0 
 *
 */

public interface RecommendManager extends BaseManager<Recommend, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "recommendManager";




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
