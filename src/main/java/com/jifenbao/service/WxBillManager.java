/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.WxBill;

/**
 *
 * @ClassName      WxBillManager
 * @Description
 * WxBill
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对WxBill对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2017-12-15 00:38:35
 * @version     1.0 
 *
 */

public interface WxBillManager extends BaseManager<WxBill, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "wxBillManager";

    /**
     * 通过唯一值获取对象
     * 
     * @param wxOrderCode
     * @return
     */
    WxBill getByWxOrderCode(java.lang.String wxOrderCode);
    
    /**
     * 通过唯一值获取对象
     * 
     * @param bzOrderCode
     * @return
     */
    WxBill getByBzOrderCode(java.lang.String bzOrderCode);
    



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

	void downloadBill(String dateStr, String string);

}
