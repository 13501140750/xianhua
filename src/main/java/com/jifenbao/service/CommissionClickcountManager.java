/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.CommissionClickcount;

/**
 *
 * @ClassName      CommissionClickcountManager
 * @Description
 * CommissionClickcount
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CommissionClickcount对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-22 16:07:00
 * @version     1.0 
 *
 */

public interface CommissionClickcountManager extends BaseManager<CommissionClickcount, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "commissionClickcountManager";




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
