/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.page.Page;
import com.otc.framework.service.BaseManager;

import java.util.Map;

import com.jifenbao.model.MyFavorite;

/**
 *
 * @ClassName      MyFavoriteManager
 * @Description
 * MyFavorite
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对MyFavorite对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-29 14:33:06
 * @version     1.0 
 *
 */

public interface MyFavoriteManager extends BaseManager<MyFavorite, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "myFavoriteManager";
    
    /**
     * 统计该商品被收藏数量
     * @param productCode
     * @return
     */
    public  int getCountByProduct(String productCode); 
    
    /**
     * 加入收藏夹
     * @param productCode
     * @param customerId
     */
    public void addToFavorite(String productCode,String customerName);

    public Page<MyFavorite> selectMyfavoriteProsByUserPage(Map<String,Object> params, int pageNo, int pageSize);
    
}
