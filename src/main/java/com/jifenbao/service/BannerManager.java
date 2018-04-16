/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.Banner;

/**
 *
 * @ClassName      BannerManager
 * @Description
 * Banner
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Banner对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-16 13:01:59
 * @version     1.0 
 *
 */

public interface BannerManager extends BaseManager<Banner, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "bannerManager";

    /**
     * 根据ID批量删除banner
     * @param ids
     */
    public void batUpdateDeleteYn(Integer[] ids,String updateUser);
    
    /**
     * 根据ID批量启用或禁用
     * @param ids
     */
    public void updateDisabledYn(Integer id,String oper,String updateUser);
    
    
    /**********************前台使用********************************/
    /**
     * 获取首页轮播图片
     * @return
     */
    public List<Banner>  getFrontImageBanner();
    
    /**
     * 获取首页热门推荐
     * @return
     */
    public List<Banner>  getFrontTuanGouBanner(); 
    
    /**
     * 获取首页设置信息
     * @return
     */
    public List<Banner>  getFrontBanner(Map<String,Object> map); 

}
