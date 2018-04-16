/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.Warehouse;

/**
 *
 * @ClassName      WarehouseManager
 * @Description
 * Warehouse
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Warehouse对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-28 11:48:49
 * @version     1.0 
 *
 */

public interface WarehouseManager extends BaseManager<Warehouse, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "warehouseManager";
    
    
    /**
     * 查询所有的有效仓库
     * @param map 
     * @return
     */
    public List<Warehouse> findAllWarehose();

    /**
     * 获取当前公司对应的默认仓库
     * @param map 
     * @return
     */
    public List<Warehouse> getWarehoseByCompanyCode(Map<String,Object> map);

}
