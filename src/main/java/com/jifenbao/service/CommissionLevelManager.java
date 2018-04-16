/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.CommissionLevel;

/**
 *
 * @ClassName      CommissionLevelManager
 * @Description
 * CommissionLevel
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CommissionLevel对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-11 16:45:04
 * @version     1.0 
 *
 */

public interface CommissionLevelManager extends BaseManager<CommissionLevel, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "commissionLevelManager";




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
