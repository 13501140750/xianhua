/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.Brand;

/**
 *
 * @ClassName      BrandManager
 * @Description
 * Brand
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Brand对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-09 10:44:48
 * @version     1.0 
 *
 */

public interface BrandManager extends BaseManager<Brand, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "brandManager";
    
    
    /**
     * 自动生成的code
     * @return
     */
    public String genCode();
    
    /**
     * 根据ID批量删除品牌
     * @param ids
     */
    public void batUpdateDeleteYn(Long[] ids,String updateUser);


    /**
     * 根据ID批量启用或禁用
     * @param ids
     */
    public void updateDisabledYn(Long id,String oper,String updateUser);
    
    /**
     * 获取首页热门品牌
     * @return
     */
    public List<Brand> getFrontHotBrand();
    
    /**
     * 获取所有在前台显示的品牌
     * @return
     */
    public List<Brand> getFrontBrand();
    
    public List<Brand> queyryByLimt(Map map);
}
