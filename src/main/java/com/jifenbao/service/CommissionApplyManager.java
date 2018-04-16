/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.CommissionApply;
import com.jifenbao.model.ExchangeOrderDetail;

/**
 *
 * @ClassName      CommissionApplyManager
 * @Description
 * CommissionApply
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CommissionApply对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-26 12:44:19
 * @version     1.0 
 *
 */

public interface CommissionApplyManager extends BaseManager<CommissionApply, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "commissionApplyManager";




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

	public CommissionApply getEntityById(Long id);

	
	/**
	 * 佣金提现申请审核
	 * @param id
	 * @param orderDetailList
	 * @param operUser
	 */
	public void check(Long id, List<ExchangeOrderDetail> orderDetailList, String name);

	/**
	 * 佣金提现撤销审核
	 * @param id
	 * @param name
	 */
	public void cancel(Long id, String name);

	/**
	 * 佣金提现拒绝
	 * @param id
	 * @param name
	 */
	public void refuse(Long id, String name);

	/**
	 * 佣金提现打款
	 * @param id
	 * @param name
	 */
	public void pay(Long id, String name);

	public double getTotalCommission(Map<String, Object> map);

}
