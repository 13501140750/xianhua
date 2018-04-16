/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.CommissionSetting;

/**
 *
 * @ClassName      CommissionSettingManager
 * @Description
 * CommissionSetting
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CommissionSetting对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-11 09:54:41
 * @version     1.0 
 *
 */

public interface CommissionSettingManager extends BaseManager<CommissionSetting, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "commissionSettingManager";




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

	public CommissionSetting getConfig();

}
