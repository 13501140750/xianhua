/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.News;

/**
 *
 * @ClassName      NewsManager
 * @Description
 * News
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对News对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-16 15:41:27
 * @version     1.0 
 *
 */

public interface NewsManager extends BaseManager<News, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "newsManager";

    /**
     * 根据ID批量删除banner
     * @param ids
     */
    public void batUpdateDeleteYn(Long[] ids,String updateUser);
    
    /**
     * 根据ID批量启用或禁用
     * @param ids
     */
    public void updateDisabledYn(Long id,String oper,String updateUser);
    
    /**
     * 获取首页显示新闻
     * @return
     */
    public List<News> getFrontNews();
    
    /**
     * 获取首页显示公告
     */
    public List<News> getFrontNotice();
    
    public List<String>  getDateByType(Map<String,Object> map);
    
    
    
}
