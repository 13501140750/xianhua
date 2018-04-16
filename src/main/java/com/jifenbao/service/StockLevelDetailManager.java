/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.Map;

import com.jifenbao.model.StockLevelDetail;
import com.otc.framework.service.BaseManager;

/**
 *
 * @ClassName      StockLevelDetailManager
 * @Description
 * StockLevelDetail
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对StockLevelDetail对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-23 17:09:18
 * @version     1.0 
 *
 */

public interface StockLevelDetailManager extends BaseManager<StockLevelDetail, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "stockLevelDetailManager";

   /**
    * 通过库存信息获取库存详情
    * @param productCode
    * @return
    */
   public StockLevelDetail getStockDetailByLevelId(Integer stockLevelId);
   
   
   /**
    * 通过产品编号获取产品对应的库存信息
    * @param productCode
    * @return
    */
   public StockLevelDetail getStockDetailByProduct(Map<String,Object> map);
   
   /**
    * 自动生成批次号
    * @return
    */
   public String createBathchNo();
}
