/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.Map;

import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductOption;
import com.jifenbao.model.StockLevel;
import com.jifenbao.model.StockLevelDetail;
import com.jifenbao.model.StockLog;

/**
 *
 * @ClassName      StockLevelManager
 * @Description
 * StockLevel
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对StockLevel对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-23 17:26:16
 * @version     1.0 
 *
 */

public interface StockLevelManager extends BaseManager<StockLevel, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "stockLevelManager";
    
    /**
     * 通过产品编号获取产品对应的库存信息
     * @param productCode
     * @return
     */
    public StockLevel getStockLevelByProduct(Map<String,Object> map);
    
    /**
     * 添加产品的同时添加库存信息
     * @param prd
     */
    public StockLevelDetail addStockLevelByProduct(Product prd, ProductOption prdOption);
    /**
     * 产品自动出入库 
     * @param productCode   出库产品编码
     * @param stockOutCount 出库数量
     * @param wasehoseId    出库仓库
     * @param bean          出库订单
     */
    public void autoStockInOrOut(String productCode,Integer stockOutCount,String wasehoseId,StockLog stockLog);
    
    /**
     * 通过产品和对应的仓库获取对应的库存详情，如该商品未入仓库，子自动添加库存信息
     * @param prd
     * @param wasehoseId
     * @param operUser
     * @return
     */
    public StockLevelDetail getStockLevelDetailByProduct(Product prd,String wasehoseId,String operUser);

	public StockLevelDetail addStockLevelByProduct(Product product);

    
    
}
