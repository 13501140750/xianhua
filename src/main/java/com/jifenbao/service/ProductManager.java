/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.page.Page;
import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.jifenbao.model.Product;
import com.jifenbao.model.ProductGroup;
import com.jifenbao.model.ProductOption;
import com.jifenbao.model.ProductSpec;

/**
 *
 * @ClassName      ProductManager
 * @Description
 * Product
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Product对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-16 12:59:15
 * @version     1.0 
 *
 */

public interface ProductManager extends BaseManager<Product, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productManager";
    
    
    /**
     * 根据ID批量删除 产品
     * @param ids
     */
    public void updateDeleteYn(Long id,String updateUser);
    
    /**
     * 根据ID批量 产品
     * @param ids
     */
    public void batUpdateDeleteYn(Long[] ids,String updateUser);
    
    /**
     * 自动生成code
     */
    public String genCode();
    
    /**
     * 保存产品信息，并通过供应商信息添加库存信息
     * @param prd
     */
    public Product  savePrd(Product  prd);
    
    /**
     * 
     * 编辑产品信息，并通过供应商信息修改库存信息
     *
     * @param prd
     */
     public void editPrd(Product  prd);

    /**
     *     
     * @param prd
     * @param PrdList
     * @return
     */
    public Product  saveGroupPrd(Product prd, List<ProductGroup> PrdList);
    
    /**
     *     
     * @param prd
     * @param PrdList
     * @return
     */
    public Product  updateGroupPrd(Product prd, List<ProductGroup> PrdList);
    
    /**
     * 查询礼品卡对应的产品
     * @param cardCode
     * @return
     */
    public List<Product> findPrdByCardCode(String cardCode);
    
    
    /////////////////////////front//////////////////////////////////////
    /**
     * 获取首页显示的热卖产品，可以根据品牌，显示类目查询,分页查询,前台可以换一批
     * @param map
     * @return
     */
    public Page<Product> getFrontHotProduct(Map<String,Object> map,int pageNo,int pageSize);
    
    /**
     * 通过后台类目查询商品
     * @param productCat  商品类目code
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Product>  getProductByProductCat(Map<String, Object> map,int pageNo,int pageSize);
    
    /**
     * 通过前台显示类目查询商品
     * @param navCat  显示类目code
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Product>  getProductList(Map<String,Object> map,int pageNo,int pageSize);
    
    /**
     * 查询产品，用于返回简单字段
     * @param map
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Product> searchPrd(Map<String,Object> map,int pageNo,int pageSize);
    
    /**
     * 查询产品详情，前台展示时使用，根据不同公司显示不同价格
     * @param map
     * @return
     */
    public Product getProductByCode(Map<String,Object> map);
    
   
    
    public boolean existsByCode(Product bean);

	public void savePrd(Product bean, List<ProductSpec> specs, List<ProductOption> options, String name);
	
	
	/**
	 * 商品id查询商品对象,返回结果包含规格
	 */
	public Product selectById(Long id);
	
	
	/**
	 * 商品code查询商品对象,返回结果包含规格
	 */
	Product selectByCode(String code);
}
