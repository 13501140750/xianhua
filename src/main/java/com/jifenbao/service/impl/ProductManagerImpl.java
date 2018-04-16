/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.Product;
import com.jifenbao.model.ProductCategory;
import com.jifenbao.model.ProductGroup;
import com.jifenbao.model.ProductOption;
import com.jifenbao.model.ProductSpec;
import com.jifenbao.model.ProductSpecItem;
import com.jifenbao.model.StockLevelDetail;
import com.jifenbao.model.Supplier;
import com.jifenbao.model.SystemSetting;
import com.jifenbao.model.Warehouse;
import com.jifenbao.service.NavigationCategoryManager;
import com.jifenbao.service.ProductCategoryManager;
import com.jifenbao.service.ProductGroupManager;
import com.jifenbao.service.ProductManager;
import com.jifenbao.service.ProductOptionManager;
import com.jifenbao.service.ProductSpecItemManager;
import com.jifenbao.service.ProductSpecManager;
import com.jifenbao.service.StockLevelDetailManager;
import com.jifenbao.service.StockLevelManager;
import com.jifenbao.service.SupplierManager;
import com.jifenbao.service.SystemSettingManager;
import com.jifenbao.service.WarehouseManager;
import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.model.Order;
import com.otc.framework.page.Page;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName      ProductManagerImpl
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

@Service(ProductManager.BEAN_NAME)
@Transactional
public class ProductManagerImpl extends MybatisServiceImpl<Product, Long> implements ProductManager {
	
	 @Resource
	 ProductGroupManager productGroupManager;
	
	 @Resource
	 NavigationCategoryManager navigationCategoryManager;
	 
	 @Resource
	 ProductCategoryManager productCategoryManager;
	 
	 @Resource 
	 StockLevelManager  stockLevelManager;
	 
	 
	 @Resource 
	 StockLevelDetailManager  stockLevelDetailManager;
	 
	 @Resource(name = WarehouseManager.BEAN_NAME)
	 private WarehouseManager warehouseManager;
	 
	 
	 @Resource(name = SupplierManager.BEAN_NAME)
	 private SupplierManager supplierManager;
	 
	 @Resource(name = SystemSettingManager.BEAN_NAME)
	 private SystemSettingManager systemSettingManager;
	 
	 @Resource(name = ProductSpecManager.BEAN_NAME)
	 private ProductSpecManager productSpecManager;
	    
	 @Resource(name = ProductSpecItemManager.BEAN_NAME)
	 private ProductSpecItemManager productSpecItemManager;
	    
	 @Resource(name = ProductOptionManager.BEAN_NAME)
	 private ProductOptionManager productOptionManager;
	 

	/*
	 * 批量删除产品
	 * (non-Javadoc)
	 * @see com.jifenbao.service.ProductManager#batUpdateDeleteYn(java.lang.Long[], java.lang.String)
	 */
	@Override
	public void batUpdateDeleteYn(Long[] ids,String updateUser) {
		if(ids!=null){
			for(long id:ids){
				Product product= this.getEntity(id);
				product.setDeleteYn(YesNot.YES.getCode());
				product.setUpdateTime(new Date());
				product.setUpdateUser(updateUser);
	            this.modifyEntity(product);
	            if(product.getType()!=null && product.getType().equals("1")){
	            	productGroupManager.updateDelYnByGrpCode(product.getCode());
	            }
			}
		}
	}

	/*
	 * 根据ID删除产品，将delete设置成1
	 * (non-Javadoc)
	 * @see com.jifenbao.service.ProductManager#updateDeleteYn(java.lang.Long, java.lang.String)
	 */
	@Override
	public void updateDeleteYn(Long id,String updateUser) {
		Product product= this.getEntity(id);
		product.setDeleteYn(YesNot.YES.getCode());
		product.setUpdateTime(new Date());
		product.setUpdateUser(updateUser);
        this.modifyEntity(product);
	}

	/*
	 * 自动生成code，当前时间+4位随机数，如已经存在则继续生成
	 * (non-Javadoc)
	 * @see com.jifenbao.service.ProductManager#genCode()
	 */
	@Override
	public String genCode() {
		//logger.info("生成code");
		String code = RandomStringUtils.randomNumeric(8) ;//JfbUtil.createCode();
		//Product prd = (Product) this.ex.findUniqueBy(entityClass.getSimpleName()+".fingByCode", code);
		Product prd = new Product();
		prd.setCode(code);		
		if(this.isExists(prd)){
			logger.info("code已存在");
			return this.genCode();
		}else{
			logger.info("code为最新");
			return code;
		}
	}

	/*
	 *
	 * 生成code保存产品
	 * (non-Javadoc)
	 * @see com.jifenbao.service.ProductManager#savePrd(com.jifenbao.model.Product)
	 */
	@Override
	public Product savePrd(Product prd) {
		String code = this.genCode();
		prd.setCode(code);
		prd.setCount(1);
		prd.setDisabledYn(YesNot.NOT.getCode());
		prd.setDeleteYn(YesNot.NOT.getCode());
		if (StringUtils.isEmpty(prd.getShowYn())) {// 产品默认显示给客户
			prd.setShowYn(YesNot.NOT.getCode());
        }
       
       
        	this.addEntity(prd);
        
		
		
		return prd;
	}
	
	
	@Override
	public void editPrd(Product prd) {
	   
	   this.update(prd);
	}

	@Override
	public Product saveGroupPrd(Product prd, List<ProductGroup> PrdList) {
		String code = this.genCode();
		prd.setCode(code);
		prd.setCount(1);
		prd.setDisabledYn(YesNot.NOT.getCode());
		prd.setDeleteYn(YesNot.NOT.getCode());
		 // 如果为平台管理员权限可以自动设置的审核通过
		prd.setApprovalStatus(YesNot.NOT.getCode());
		if (StringUtils.isEmpty(prd.getShowYn())) {// 产品默认显示给客户
			prd.setShowYn(YesNot.NOT.getCode());
        }
		this.addEntity(prd);
		for(ProductGroup prdGroup:PrdList){
			if(prdGroup!=null && StringUtils.isNotBlank(prdGroup.getPrdCode())){
				prdGroup.setGroupPrdcode(code);
				prdGroup.setDeleteYn(YesNot.NOT.getCode());
				prdGroup.setDisabledYn(YesNot.NOT.getCode());
				prdGroup.setCreateUser(prd.getCreateUser());
				prdGroup.setCreateTime(DateTimeUtil.now());
				prdGroup.setUpdateTime(DateTimeUtil.now());
				prdGroup.setUpdateUser(prd.getUpdateUser());
				productGroupManager.addEntity(prdGroup);
			}
			
		}
		return null;
	}

	@Override
	public Product updateGroupPrd(Product prd, List<ProductGroup> PrdList) {
		String code = prd.getCode();
		prd.setCount(1);
		this.modifyEntity(prd);
		for(ProductGroup prdGroup:PrdList){
			if(prdGroup!=null && StringUtils.isNotBlank(prdGroup.getPrdCode())){
				prdGroup.setGroupPrdcode(code);
				prdGroup.setDeleteYn(YesNot.NOT.getCode());
				prdGroup.setDisabledYn(YesNot.NOT.getCode());
				prdGroup.setUpdateTime(DateTimeUtil.now());
				prdGroup.setUpdateUser(prd.getUpdateUser());
				if(prdGroup.getId()!=null){
					productGroupManager.modifyEntity(prdGroup);
				}else{
					prdGroup.setCreateUser(prd.getCreateUser());
					prdGroup.setCreateTime(DateTimeUtil.now());
					productGroupManager.addEntity(prdGroup);
				}
			}
			
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<Product> findPrdByCardCode(String cardCode){
		return this.findAll(entityClass.getSimpleName()+".selectPrdByCardCode", cardCode);
	}

	///////////////前台//////////////////////////////////////////
	/*
	 * 获取首页显示的热卖产品，可以根据品牌，显示类目查询,分页查询,前台可以换一批
	 * (non-Javadoc)
	 * @see com.jifenbao.service.ProductManager#getFrontHotProduct(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<Product> getFrontHotProduct(Map<String, Object> map,int pageNo,int pageSize) {
		return this.findPage(entityClass.getSimpleName()+".pageQueryForHot", entityClass.getSimpleName()+".pageCountForHot", pageNo, pageSize, map);
	}

	@Override
	public Page<Product> getProductByProductCat(Map<String, Object> map, int pageNo, int pageSize) {
		
		//Map<String, Object> map = new HashMap<String, Object>();
		map.put("approvalStatus", 0);
		map.put("salesStatus", "Y");
		map.put("priPrdCode", "0");//不显示子商品
		
		
		if(map.get("productCat")!=null && !map.get("productCat").toString().equals("0")){
			String productCat = map.get("productCat").toString();
			//ProductCategory prdCategory  = productCategoryManager.findUniqueByProperty("code", productCat);
			List<ProductCategory> subPrdCatList = productCategoryManager.findCatByParentCode(productCat)  ;
			
			List<String> prdCodeString  = new ArrayList<String>();
			prdCodeString.add(productCat);
			if(subPrdCatList!=null && !subPrdCatList.isEmpty()){
				for(ProductCategory prdCat:subPrdCatList){
					prdCodeString.add(prdCat.getCode());
				}
			}
			map.put("prdCodeList", prdCodeString);
		}
		
		
		return this.findPage(map, pageNo, pageSize);
	}

	@Override
	public Page<Product> getProductList(Map<String,Object> map,int pageNo,int pageSize) {
		map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
		map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		map.put("approvalStatus", 0);
		map.put("salesStatus", "Y");
//		map.put("showYn", "Y");
		map.put("priPrdCode", "0");//不显示子商品
		//map.put("navcatCode", navCat);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		param.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
		param.put("systemKey", "search_product_y");
		SystemSetting search_product_y = systemSettingManager.findUniqueByProperty("systemKey", "search_product_y");
		if(search_product_y.getSystemValue() == null || !"1".equals(search_product_y.getSystemValue())){
			map.remove("deliveryCityLike");
		}
		
		//价格区间查询
    	if(map.get("priceRange")!=null){
    		String priceRange = map.get("priceRange").toString();
    		String[] range = priceRange.split("-");
    		
    		if(range[0]!=null){
    			map.put("lowestSalePrice", range[0]);
    		}
    		if(range.length>1 && range[1]!=null){
    			map.put("highestSalePrice", range[1]);
    		}
    	}
		//按照分类查询
    	if(map.get("productCat")!=null && !"".equals(map.get("productCat"))){
    		String productCat = map.get("productCat").toString();
    		//List<ProductCategory> subPrdCatList = productCategoryManager.findCatByParentCode(productCat)  ;
    		List<String> prdCodeString  = productCategoryManager.getSubProductCatCode(productCat);
    		/*prdCodeString.add(productCat);
    		if(subPrdCatList!=null && !subPrdCatList.isEmpty()){
    			for(ProductCategory prdCat:subPrdCatList){
    				prdCodeString.add(prdCat.getCode());
    				if(prdCat.getSubCatList()!=null){//第三级
    					for(ProductCategory subprdCat:prdCat.getSubCatList()){
    						prdCodeString.add(subprdCat.getCode());
    					}
    				}
    			}
    		}*/
    		map.put("prdCodeList", prdCodeString);
    	}
    	
		List<Order> orderby = new ArrayList<Order>();
		/************************************************/
		if(map.get("sort") != null && !"".equals(map.get("sort"))){
			String sort = (String) map.get("sort");
			if("1".equals(sort)){
				orderby.add(Order.desc("hotYn"));
			}else if("2".equals(sort)){
				orderby.add(Order.asc("salesPrice"));
			}else if("3".equals(sort)){
				orderby.add(Order.desc("salesPrice"));
			}else if("3".equals(sort)){
				orderby.add(Order.asc("salesPrice"));
			}else if("4".equals(sort)){
				orderby.add(Order.desc("createTime"));
			}
		}else{
			orderby.add(Order.desc("id"));
		}
		/************************************************/
//        orderby.add(Order.desc("id"));
        map.put(DataTransferKey.ORDERBY_NAME, orderby);
		return this.findPage(map, pageNo, pageSize);
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public Page<Product> searchPrd(Map<String, Object> map, int pageNo, int pageSize) {
		return this.findPageByMap(entityClass.getSimpleName()+".pageQueryForSearch", entityClass.getSimpleName()+".pageCount", pageNo, pageSize, map);
	}

	@Override
	public Product getProductByCode(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (Product)this.findUniqueBy(entityClass.getSimpleName()+".selectProductByCodeAndCompany", map);
	}

	@Override
	public boolean existsByCode(Product bean) {
		// TODO Auto-generated method stub
		return super.isExists(entityClass.getSimpleName()+".existsByCode", bean);
	}

	@Override
	public void savePrd(Product prd, List<ProductSpec> specs, List<ProductOption> options, String operUser) {
		if(prd.getHasoption() == null){
			prd.setHasoption("0");
		}
		prd.setHighestSalePrice(prd.getSalesPrice());
		prd.setLowestSalePrice(prd.getSalesPrice());
		if(prd.getId() == null){
			String code = this.genCode();
			prd.setCode(code);
			prd.setCount(1);
			prd.setDisabledYn(YesNot.NOT.getCode());
			prd.setDeleteYn(YesNot.NOT.getCode());
			if (StringUtils.isEmpty(prd.getShowYn())) {// 产品默认显示给客户
				prd.setShowYn(YesNot.NOT.getCode());
	        }
	        	this.addEntity(prd);
		}else{
			this.update(prd);
			Product entity = this.getEntity(prd.getId());
			prd.setCode(entity.getCode());
		}
		
		
		
        	if(specs != null && specs.size() > 0){
        		 Long[] specIds = new Long[specs.size()];
     	        List<ProductSpecItem> spec_items = new ArrayList<ProductSpecItem>();
     	        for (int i = 0; i < specs.size(); i++) {
     	        	ProductSpec spec = specs.get(i);
     	        	spec.setProductId(prd.getId());
     	        	spec.setDisplayOrder(i);
     	        	if(StringUtils.isNumeric(spec.getIdStr())){
     	        		spec.setId(Long.valueOf(spec.getIdStr()));
     	        		spec.setUpdateTime(DateTimeUtil.now());
     	        		spec.setUpdateUser(operUser);
     	        		productSpecManager.modifyEntity(spec);
     	        	}else{
     	        		spec.setCreateTime(DateTimeUtil.now());
     	        		spec.setCreateUser(operUser);
     	        		spec.setDisabledYn(YesNot.NOT.getCode());
     	        		spec.setDeleteYn(YesNot.NOT.getCode());
     	        		productSpecManager.addEntity(spec);
     	        	}
     	        	
     	        	specIds[i] = spec.getId();
     	        	
     	        	List<Long> itemIds = new ArrayList<Long>();
     	        	if(spec.getSpecItems() != null && spec.getSpecItems().size() > 0){
     	        		for (int x = 0; x < spec.getSpecItems().size(); x++) {
     	        			ProductSpecItem specItem = spec.getSpecItems().get(x);
     	        			specItem.setSpecId(spec.getId());
     	        			specItem.setDisplayOrder(x);
     	        			if(StringUtils.isNumeric(specItem.getIdStr())){
     	        				specItem.setId(Long.valueOf(specItem.getIdStr()));
     	        				specItem.setUpdateTime(DateTimeUtil.now());
     	        				specItem.setUpdateUser(operUser);
     	        				productSpecItemManager.modifyEntity(specItem);
     	        			}else{
     	        				specItem.setCreateTime(DateTimeUtil.now());
     	        				specItem.setCreateUser(operUser);
     	        				specItem.setDeleteYn(YesNot.NOT.getCode());
     	        				specItem.setDisabledYn(YesNot.NOT.getCode());
     	        				productSpecItemManager.addEntity(specItem);
     	        			}
     	        			
     	        			itemIds.add(specItem.getId());
     	        			spec_items.add(specItem);
     					}
     	        	}
     	        	Map<String, Object> map = new HashMap<String, Object>();
     	            map.put("specId",spec.getId());
     	            map.put("updateTime", DateTimeUtil.now());
     	            map.put("updateUser", operUser);
     	            if(itemIds.size() > 0){
     	            	map.put("notIds", itemIds);
     	            }
     	        	productSpecItemManager.deleteByMap(map);
     	        	
     	        	
     			}
     	        Map<String, Object> map = new HashMap<String, Object>();
     	        map.put("deleteYn", YesNot.NOT.getCode());
     	        map.put("productId",prd.getId());
     	        map.put("updateTime", DateTimeUtil.now());
     	        map.put("updateUser", operUser);
     	        if(specIds.length > 0){
     	        	map.put("notIds", specIds);
     	        }
     	        productSpecManager.deleteByMap(map);
     	        
     	        
     	        //添加规格
    	        if(options != null && options.size() > 0){
    	        	double maxPrice = 0.0;
         	        double minPrice = 0.0;
    	        	List<Long> option_ids = new ArrayList<Long>();
    	        	int cdx = 0;
    	        	for (ProductOption option : options) {
    	        		if(cdx == 0){
    	        			maxPrice = option.getProductPrice();
    	        			minPrice = option.getProductPrice();
    	        		}else{
    	        			if(maxPrice < option.getProductPrice()){
        	        			maxPrice = option.getProductPrice();
        	        		}
        	        		if(minPrice > option.getProductPrice()){
        	        			minPrice = option.getProductPrice();
        	        		}
    	        		}
    	        		cdx++;
    	        		
    	        		option.setDisplayOrder(cdx);
    	        		option.setProductId(prd.getId());
    	        		option.setProductCode(prd.getCode());
    					String optionStr = option.getIdStr();
    					String[] optionIds = optionStr.split("_");
    					String[] newIds = new String[optionIds.length];
    					for(int z = 0; z < optionIds.length; z++){
    						for (ProductSpecItem spec_item : spec_items) {
    							if(optionIds[z].equals(spec_item.getIdStr())){
    								newIds[z] = spec_item.getId() + "";
    								break;
    							}
    						}
    						
    					}
    					Arrays.sort(newIds);
    					String join = StringUtils.join(newIds, "_");
    					option.setSpecs(join);
    					
    					if(option.getId() == null){
    						option.setCreateTime(DateTimeUtil.now());
    						option.setCreateUser(operUser);
    						option.setDeleteYn(YesNot.NOT.getCode());
    						option.setDisabledYn(YesNot.NOT.getCode());
    						productOptionManager.addEntity(option);
    					}else{
    						option.setUpdateTime(DateTimeUtil.now());
    						option.setUpdateUser(operUser);
    						productOptionManager.modifyEntity(option);
    					}
    					option_ids.add(option.getId());
    					
    				}
    	        	prd.setHighestSalePrice(maxPrice);
    	        	prd.setLowestSalePrice(minPrice);
    	        	this.modifyEntity(prd);
    	        	
    	        	
    	        	Map<String, Object> optionMap = new HashMap<String, Object>();
    	        	optionMap.put("productId",prd.getId());
    	        	optionMap.put("deleteYn", YesNot.NOT.getCode());
    	        	optionMap.put("updateTime", DateTimeUtil.now());
    	        	optionMap.put("updateUser", operUser);
     	            if(option_ids.size() > 0 && !"0".equals(prd.getHasoption())){
     	            	optionMap.put("notIds", option_ids);
     	            }
     	            
     	        	productOptionManager.deleteByMap(optionMap);
    	        	
    	        }
        	}
	        
		
	}

	@Override
	public Product selectById(Long id) {
		Object result = super.findUniqueBy(entityClass.getSimpleName() + ".selectById", id);
		if(result != null){
			return (Product) result;
		}
		return null;
	}

	@Override
	public Product selectByCode(String code) {
		Object result = super.findUniqueBy(entityClass.getSimpleName() + ".selectByCode", code);
		if(result != null){
			return (Product) result;
		}
		return null;
	}

	
	

}
