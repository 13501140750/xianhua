/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.NavigationCategory;
import com.jifenbao.model.ProductCategory;
import com.otc.framework.service.BaseManager;

/**
 *
 * @ClassName      NavigationCategoryManager
 * @Description
 * NavigationCategory
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对NavigationCategory对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-12 21:20:20
 * @version     1.0 
 *
 */

public interface NavigationCategoryManager extends BaseManager<NavigationCategory, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "navigationCategoryManager";
    
    
    
    /**
     * 查询第一级别类目，同时查询出子目录列表
     * @return  目录列表
     */
    public List<NavigationCategory>  getTopCat() ;
    
    /**
     * 查询第一级别类目，同时查询出子目录列表
     * @return  目录列表
     */
    public List<NavigationCategory>  getTopCatByMap(Map<String,Object> map) ;
    
    /**
     * 通过父code查询子类code
     * @param parCode
     * @return
     */
    public List<NavigationCategory> findCatByParentCode(String parCode);
    
    /**
     * 通过父code查询子类code
     * @param map
     * @return
     */
    public List<NavigationCategory> findCatByParentCode(Map<String,Object> map);
    
   

    /**
     * 自动生成的code
     * @return
     */
    public String genCode();
    
    /**
     * 批量插入类目
     * @param name
     * @param parent
     */
    public void  batchSave(String[] name,String parent);
    
    /**
     * 修改删除标志位
     * @param id
     */
    public void updateDelYn(int id);
    
    
    public List<NavigationCategory> getParentProductCategory(String subCode, List<NavigationCategory> prdCatList);
    
    
    public String getNavCatForName(String code);
    
    /**
     * 通过上级类目获取所有一级可以定制的栏目
     * @return
     */
    public List<NavigationCategory> getCusmNavList(String parentCode);

	/**
	 * 获取首页显示的展示分类
	 * @return
	 */
	public List<NavigationCategory> getHomeShowList();
    
   

}
