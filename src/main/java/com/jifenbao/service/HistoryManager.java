/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.History;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductCategory;

/**
 *
 * @ClassName      HistoryManager
 * @Description
 * History
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对History对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-25 10:35:51
 * @version     1.0 
 *
 */

public interface HistoryManager extends BaseManager<History, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "historyManager";
    
	public List<ProductCategory> queryHistoryProCatsByUser(Map<String,Object>  map);
    
    public List<Product> queryHistoryProsByUser(Map<String,Object>  map);
    
    public int deleteByCon(Map<String,Object>  map);
    
    /**
     * 查询浏览记录最近的7天
     * @param map
     * @return
     */
    public List<String> findHistoryDays(Map<String,Object> map);

}
