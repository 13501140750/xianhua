/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.List;
import java.util.Map;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductCategory;

/**
 *
 * @ClassName      ProductCategoryManager
 * @Description
 * ProductCategory
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductCategory对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-11-30 16:16:25
 * @version     1.0 
 *
 */

public interface ProductCategoryManager extends BaseManager<ProductCategory, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productCategoryManager";
    
    /**
     * 查询第一级别类目，同时查询出子目录列表
     * @return  目录列表
     */
    public List<ProductCategory>  getTopCatByMap(Map<String,Object> map) ;
    
    /**
     * 通过父code查询子类code
     * @param parCode
     * @return
     */
    public List<ProductCategory> findCatByParentCode(Map<String,Object> map);
    
    /**
     * 将对象转换为tree html
     * @param list
     * @return
     */
    public String getTreehtml(List<ProductCategory> list);

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
     * 批量删除标志位
     * @param id
     */
    public void batupdateDelYn(String[] codes,String update);
    
    /**
     * 根据叶子类目获取上一级类目
     * @param subCode
     * @return
     */
    public Map<String,List<ProductCategory>>  getParentsCat(String subCode,Map<String, List<ProductCategory>> prdCatMap);
    
    /**
     * 获取产品完成的类目名称，从一级到叶子类目
     * @param subCode
     * @param bf
     * @return
     */
    public String getShowCatName(String subCode,String showCatName);
    
    /**
     * 获取当前类目的上级类目
     * @param subCode
     * @param prdCatList 
     * @return
     */
    public List<ProductCategory> getParentProductCategory(String subCode,List<ProductCategory> prdCatList);
    
    
    /**
     * 获取所有分类
     * @return
     */
    public List<ProductCategory> getAllProductCategory();
    
    
    public List<ProductCategory> findCatByParentCode(String code);
    
    
    
    /**
     * 根据父类目获取所有根节点类目CODE的集合，用于查询父类目所对应的产品
     * @param productCatCode
     * @return
     */
    public List<String> getSubProductCatCode(String productCatCode);

	/**
	 * 查找指定code下的分类
	 * @param catMap
	 * @return
	 */
	public List<ProductCategory> findByParentCode(Map<String, Object> catMap);

}
