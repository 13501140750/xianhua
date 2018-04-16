/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.model.Region;

/**
 *
 * @ClassName      RegionManager
 * @Description
 * Region
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Region对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-16 22:40:04
 * @version     1.0 
 *
 */

public interface RegionManager extends BaseManager<Region, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "regionManager";

    /**
     * 获取省列表
     * @return
     */
    public List<Region>  getProvinces();
    
    
    /**
     * 通过上一级code获取下一级列表
     * @return
     */
    public List<Region>  getChildren(Integer parent);
    
    
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
}
