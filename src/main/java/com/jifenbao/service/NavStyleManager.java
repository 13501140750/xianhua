/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.model.NavStyle;

/**
 *
 * @ClassName      NavStyleManager
 * @Description
 * NavStyle
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对NavStyle对象的CRUD函数.
 *
 * @author      jing68.liu
 * @Date        2016-10-24 14:30:51
 * @version     1.0 
 *
 */

public interface NavStyleManager extends BaseManager<NavStyle, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "navStyleManager";

    
    public List<NavStyle> getNavStyleList();

    /**
     * 根据ID批量删除品牌
     * @param ids
     */
    public void batUpdateDeleteYn(Integer[] ids,String updateUser);


    /**
     * 根据ID批量启用或禁用
     * @param ids
     */
    public void updateDisabledYn(Integer id,String oper,String updateUser);
}
