package com.jifenbao.service;

import java.util.List;
import java.util.Map;
import com.jifenbao.model.StatisticsProduct;
import com.otc.framework.service.BaseManager;

public interface StatisticsManager extends BaseManager<StatisticsProduct, Integer>{
	
	 /**
     * Bean名称
     */
    String BEAN_NAME = "statisticsManager";

	/**
	 * 统计产品明细
	 */
	List<StatisticsProduct> stateProductDetail(Map<String,Object> map);
	
	/**
	 * 产品出入库统计
	 * @param map
	 * @return
	 */
    List<StatisticsProduct> stateProductInOut(Map<String, Object> map);
    
    
    /**
	 * 采购结算
	 * @param map
	 * @return
	 */
    List<Map<String,Object>> statePurchaseSettlement(Map<String, Object> map);
    
    /**
     * 卡册兑换情况统计表-按单位
     */
    List<Map<String,Object>> stateGiftCardByCompany(Map<String, Object> map);
    
    /**
     * 卡册对应的产品兑换情况
     */
    List<Map<String,Object>> stateProcutConvert(Map<String, Object> map);
    
    /**
     * 将订单中产品为组合的拆分子订单后的统计
     * @param map
     * @return
     */
    List<Map<String, Object>> stateProcutConvertNew(Map<String, Object> map);
    
    
    /**
     * 入库,出库,自动入库数统计按范围
     * @param map
     * @return
     */
    List<Map<String, Object>> stateProductInOuNewt(Map<String, Object> map);
    
    /**
     * 卡册兑换情况统计表-按单位(新)
     */
	Map<String, Object> stateGiftCardByCompanyNew(Map<String, Object> map);
	
	
	/**
	 * 按供应商订单商品分组
	 * @return
	 */
	List<Map<String, Object>> supplierOrderPrdGroup(Map<String, Object> map);

	/**
	 * 平台代发货订单商品统计
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> shippingOrderPrdGroupCompany(Map<String, Object> map);

	/**
	 * 订单商品待备货,代发货商品,平台库存统计
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> exchangeOrderProductGroup(Map<String, Object> map);
}
