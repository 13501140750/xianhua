/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.CustomerInfo;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.model.PayOrder;
import com.otc.framework.service.BaseManager;

/**
 *
 * @ClassName      ExchangeOrderManager
 * @Description
 * ExchangeOrder
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ExchangeOrder对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-02-02 14:56:30
 * @version     1.0 
 *
 */

public interface ExchangeOrderManager extends BaseManager<ExchangeOrder, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "exchangeOrderManager";
    
    /**
     * 自动生成订单编号
     * @return
     */
    public String genCode() ;
    
    /**
     * 自动生成子订单编号
     * @return
     */
    public String genSubCode() ;

    /**
     * 直接保存订单和子订单以及日志信息,订单未支付
     * @param bean
     */
    public void saveBaseOrder(ExchangeOrder bean);
    
    /**
     * 订单支付
     * @param bean
     */
    public void payForOrder(ExchangeOrder bean);
    /**
     * 保存订单信息，并生成子订单
     * @param bean
     */
    public void saveOrder(ExchangeOrder bean);
    
    /**
     * 不拆分订单直接保存订单信息，
     * @param bean
     * @param cusInfo
     */
    public void saveOrderForNotBreakUpOrder(ExchangeOrder bean, CustomerInfo cusInfo);
    
    /**
     * 保存定制卡订单信息，并生成子订单
     * @param bean
     */
    public void saveOrderForDz(ExchangeOrder bean);

    /**
     * 撤销订单
     * @param bean
     */
    public void updateDisableYn(String orderCode,String updateUser);
    
    /**
     * 撤销订单
     * @param bean
     */
    public void auditOrder(ExchangeOrder bean);
    
    /**
     * 操作订单
     * @param bean
     */
    public void operOrder(ExchangeOrder bean);
    
    /**
     * 操作订单
     * @param bean        需要操作的订单
     * @param addLogFlag  是否增加操作日志
     */
    public void operOrder(ExchangeOrder bean,boolean addLogFlag);
    
    /**
     * 操作子订单
     * @param bean
     */
    public void operOrder(ExchangeOrder bean,String subOrderCoed);
    
    
    /**
     * 通过订单号查询订单
     * @param orderCode
     * @return
     */
    public ExchangeOrder getExchangeOrderByOrderCode(String orderCode);
    
    /**
     * 查询未支付的订单列表
     * @param orderCode
     * @return
     */
    public ExchangeOrder getNoPayOrderByOrderCode(String orderCode);
    
    /**
     * 通过卡号查询订单
     * @param cardCode
     * @return
     */
    public ExchangeOrder  getExchangeOrderByCardCode(String cardCode);
    
    /**
     * 通过产品所属仓库拆分订单
     * @param bean
     */
    public void breakUpOrder(ExchangeOrder bean, CustomerInfo cusInfo);
    
    /**
     * 导出订单
     * @param map
     * @return
     */
    public List<ExchangeOrder> exportOrder(Map<String,Object> map);
    
    /**
	 * 转代发货,修改主订单的仓库信息，同时修改子订单对应的stockleveldetailid
	 * @param bean
	 * @param subOrderCoed 当前需要代发货的子订单
	 */
	public void dropship(ExchangeOrder bean,String subOrderCoed);
	
	/**
	 * 转回平台发货
	 * @param bean
	 * @param subOrderCoed 当前需要转回子订单
	 */
	public void backship(ExchangeOrder bean,String subOrderCoed);
	
	/**
	 * 通过支付结果修改订单状态
	 */
	public boolean updateExchangeOrderStatusByPay(PayOrder payOrder,double jifenRate,String payType);
	
	/**
	 * 复制一个新订单
	 * @param bean
	 * @return
	 */
	public ExchangeOrder copyOrder(ExchangeOrder bean);
	
	/**
	 * 新增补发货或换货的订单
	 * @param bean
	 */
	public void saveRefundOrder(ExchangeOrder bean);
	
	/**
	 * 通过主订单设置子订单信息
	 * @param detail
	 * @param bean
	 * @return
	 */
	public  ExchangeOrderDetail getDeatilFromOrder(ExchangeOrderDetail detail,ExchangeOrder bean);
	
	
	
	/**
	 * 查询订单和订单详情
	 * @param orderCode
	 * @return
	 */
	public ExchangeOrder getExchangeOrderAndDetailByOrderCode(String orderCode);
	
	
	public void breakUpOrderNew(ExchangeOrder bean, CustomerInfo cusInfo);

	/**
	 * 手动拆分订单
	 * @param ids
	 * @param bean
	 */
	public void splitOrder(Integer[] ids, ExchangeOrder bean);

	public List<ExchangeOrder> seldectOrderByIds(Long[] idArr);

	public void batchSendGoods(Long[] idArr, String name);


}
