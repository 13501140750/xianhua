/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.common.Constant;
import com.jifenbao.model.Company;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductOption;
import com.jifenbao.model.StockLevel;
import com.jifenbao.model.StockLevelDetail;
import com.jifenbao.model.StockLog;
import com.jifenbao.model.Warehouse;
import com.jifenbao.service.CompanyManager;
import com.jifenbao.service.ProductGroupManager;
import com.jifenbao.service.ProductManager;
import com.jifenbao.service.StockLevelDetailManager;
import com.jifenbao.service.StockLevelManager;
import com.jifenbao.service.StockLogManager;
import com.jifenbao.service.SupplierManager;
import com.jifenbao.service.WarehouseManager;
import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.model.Order;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName StockLevelManagerImpl
 * @Description StockLevel 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对StockLevel对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-23 17:26:16
 * @version 1.0
 *
 */

@Service(StockLevelManager.BEAN_NAME)
@Transactional
public class StockLevelManagerImpl extends MybatisServiceImpl<StockLevel, Integer> implements StockLevelManager {

	@Resource
	StockLevelDetailManager stockLevelDetailManager;
	
	@Resource
	WarehouseManager warehouseManager;
	
	@Resource
    ProductManager productManager;
	
	
	@Resource
    CompanyManager companyManager;
	
	@Resource
    SupplierManager supplierManager;
	
	
	@Resource
    ProductGroupManager groupManager;
	 
	@Resource(name = StockLogManager.BEAN_NAME)
    private StockLogManager stockLogManager;
	
    public void addEntity(StockLevel stockLevel) {
        // 根据仓库id和产品code判重
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("warehouseId", stockLevel.getWarehouseId());
        map.put("productCode", stockLevel.getProductCode());
        if(super.findByMap(map).size() > 0){
            throw new BusinessException("product already exist in the warehouse");
        }
        super.addEntity(stockLevel);
    }

	@Override
	public StockLevel getStockLevelByProduct(Map<String,Object> map) {
		//return this.getByObject(entityClass.getSimpleName()+".selectStockLevelByProductCode", productCode);
		//Map<String, Object> map = new HashMap<String, Object>();
		map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
		List<Order> orderby = new ArrayList<Order>();
		orderby.add(Order.asc("level"));
	    orderby.add(Order.asc("id"));
	    map.put(DataTransferKey.ORDERBY_NAME, orderby);
	    
		List<StockLevel> stockList = new ArrayList<StockLevel>();
		stockList = this.findByMap(map);
		if(stockList!=null && !stockList.isEmpty()){
			return  stockList.get(0);
		}else{
			return null;
		}
		 
	}

//	@Override
	public StockLevelDetail  addStockLevelByProduct(Product prd, ProductOption prdOption) {
		StockLevelDetail detail = new StockLevelDetail();
		Date now = DateTimeUtil.now();
		StockLevel level = new StockLevel();
		Integer warehouseId = null;
		if(StringUtils.isBlank(prd.getDefalutWarehouse())){
			Company company = companyManager.findUniqueByProperty("code", Constant.XNS_COMPANY_CODE);
			if(StringUtils.isNotBlank(company.getDefaultWarehouseCode())){
				  warehouseId = Integer.parseInt(company.getDefaultWarehouseCode());
			  }
		}else{
			 warehouseId = Integer.parseInt(prd.getDefalutWarehouse());
		}
		
		
		
        level.setWarehouseId(warehouseId);
        level.setProductId(prdOption.getProductId());
        level.setProductCode(prdOption.getProductCode());
        level.setProductOptionId(prdOption.getId());
        level.setType("1");
        level.setAmount(0);
        level.setAlertAmount(10);
        level.setDefectiveAmount(0);
        level.setLevel(0);
        level.setFactoryCode(prd.getOutPrdCode());
        level.setCreateTime(now);
        level.setCreateUser("system");
        level.setDeleteYn(YesNot.NOT.getCode());
        level.setDisabledYn(YesNot.NOT.getCode());
        this.addEntity(level);
        Integer supplierId = prd.getSupplierId();
        if(prd.getSupplierId()==null){//商品所属供应关系
        	Warehouse house = warehouseManager.getEntity(warehouseId);
        	supplierId = house.getSupplierId();
        }
        
        detail.setSupplierPrdCode(prd.getOutPrdCode());
    	detail.setStockLevelId(level.getId());
    	detail.setSupplierId(supplierId);
    	detail.setPrice(prdOption.getCostPrice());
    	detail.setBatchNo(stockLevelDetailManager.createBathchNo());
    	//detail.setBatchNo("00"+level.getId());
    	detail.setAmount(0);
    	detail.setDefectiveAmount(level.getDefectiveAmount());
    	detail.setCreateTime(now);
    	detail.setCreateUser("system");
    	detail.setDeleteYn(YesNot.NOT.getCode());
    	detail.setDisabledYn(YesNot.NOT.getCode());
    	try{
    		stockLevelDetailManager.addEntity(detail);
    		detail.setStockLevel(level);
    	}catch(Exception e){
    		logger.error("保存商品库存详情异常："+e.getMessage());
    	}
    	
      return detail;  
        
		
	}

	@Override
	public void autoStockInOrOut(String productCode, Integer stockOutCount, String wasehoseId, StockLog stockLog) {
		Product product = productManager.findUniqueByProperty("code", productCode);
		List<Product> prdList  = new ArrayList<Product>();
		if(product!=null && StringUtils.isNotBlank(product.getType()) && product.getType().equals("1")){//该产品为组合产品
			prdList = groupManager.getPrdListByGroupCode(productCode);	
		}else{
			product.setCount(1);
			prdList.add(product);
		}
		for(Product prd: prdList){
			StockLevelDetail levelDetail = this.getStockLevelDetailByProduct(prd,wasehoseId,stockLog.getCreateUser());
	 		if(stockOutCount!=null && prd.getCount()!=null){
	 			stockLog.setAmount(stockOutCount*prd.getCount());
	 		}else{
	 			stockLog.setAmount(stockOutCount);
	 		}
	        
	        stockLog.setString1(productCode);//出库产品
	        stockLog.setStockLevelId(levelDetail.getStockLevelId());
	        stockLog.setStockLevelDetailId(levelDetail.getId());
	        stockLogManager.modifySotckLog(stockLog);
		  }
		
	}

	
	/**
	 * 
	 * @param prd
	 * @param wasehoseId
	 * @param operUser
	 * @return
	 */
	@Override
	public StockLevelDetail getStockLevelDetailByProduct(Product prd,String wasehoseId,String operUser){
		
			Integer supplierId = 0;
 			if(prd.getSupplierId()==null){//商品未指定供应商，则供应商默认为仓库所属的供应商
 	        	Warehouse house = warehouseManager.getEntity(Integer.parseInt(wasehoseId));
 	        	supplierId = house.getSupplierId();
 	        }
 			prd.setSupplierId(supplierId);
			prd.setDefalutWarehouse(wasehoseId);
			//通过商品以及仓库ID查询对应的库存详情
	 		Map<String, Object> map = new HashMap<String, Object>();
	 		String productCode = prd.getCode();
	 		map.put("productCode", productCode);
	 		map.put("warehouseId", wasehoseId);
	 		StockLevel level = this.getStockLevelByProduct(map);//查找仓库中是否有这个商品
	 		//StockLevelDetail 
	 		StockLevelDetail levelDetail  = new StockLevelDetail();
	 		if(level==null || level.getId()==null){
//	 			levelDetail = this.addStockLevelByProduct(prd);
	 		}else{
	 			map.put("stockLevelId", level.getId());
	 			levelDetail = stockLevelDetailManager.getStockDetailByProduct(map);//查询对应仓库中的对应商品的库存详情
	 		    if(levelDetail==null){
	 		    	levelDetail = new StockLevelDetail();
	 				levelDetail.setSupplierPrdCode(prd.getOutPrdCode());
	 				levelDetail.setStockLevelId(level.getId());
	 				levelDetail.setSupplierId(supplierId);
	 				levelDetail.setPrice(prd.getSupplyPrice());
	 				levelDetail.setBatchNo(stockLevelDetailManager.createBathchNo());
	 		    	//levelDetail.setBatchNo("00"+level.getId());
	 		    	levelDetail.setAmount(0);
	 		    	levelDetail.setDefectiveAmount(level.getDefectiveAmount());
	 		    	levelDetail.setCreateTime(DateTimeUtil.now());
	 		    	levelDetail.setCreateUser(operUser);
	 		    	levelDetail.setDeleteYn(YesNot.NOT.getCode());
	 		    	levelDetail.setDisabledYn(YesNot.NOT.getCode());
	 		    	stockLevelDetailManager.addEntity(levelDetail);
	 		    }
	 		}
	 		return  levelDetail;
	}

	@Override
	public StockLevelDetail  addStockLevelByProduct(Product prd) {
		StockLevelDetail detail = new StockLevelDetail();
		Date now = DateTimeUtil.now();
		StockLevel level = new StockLevel();
		Integer warehouseId = null;
		if(StringUtils.isBlank(prd.getDefalutWarehouse())){
			Company company = companyManager.findUniqueByProperty("code", Constant.XNS_COMPANY_CODE);
			if(StringUtils.isNotBlank(company.getDefaultWarehouseCode())){
				  warehouseId = Integer.parseInt(company.getDefaultWarehouseCode());
			  }
		}else{
			 warehouseId = Integer.parseInt(prd.getDefalutWarehouse());
		}
		
		
		
        level.setWarehouseId(warehouseId);
        level.setProductId(prd.getId());
        level.setProductCode(prd.getCode());
        level.setType("1");
        level.setAmount(0);
        level.setAlertAmount(10);
        level.setDefectiveAmount(0);
        level.setLevel(0);
        level.setFactoryCode(prd.getOutPrdCode());
        level.setCreateTime(now);
        level.setCreateUser("system");
        level.setDeleteYn(YesNot.NOT.getCode());
        level.setDisabledYn(YesNot.NOT.getCode());
        this.addEntity(level);
        Integer supplierId = prd.getSupplierId();
        if(prd.getSupplierId()==null){//商品所属供应关系
        	Warehouse house = warehouseManager.getEntity(warehouseId);
        	supplierId = house.getSupplierId();
        }
        
        detail.setSupplierPrdCode(prd.getOutPrdCode());
    	detail.setStockLevelId(level.getId());
    	detail.setSupplierId(supplierId);
    	detail.setPrice(prd.getSupplyPrice());
    	detail.setBatchNo(stockLevelDetailManager.createBathchNo());
    	//detail.setBatchNo("00"+level.getId());
    	detail.setAmount(0);
    	detail.setDefectiveAmount(level.getDefectiveAmount());
    	detail.setCreateTime(now);
    	detail.setCreateUser("system");
    	detail.setDeleteYn(YesNot.NOT.getCode());
    	detail.setDisabledYn(YesNot.NOT.getCode());
    	try{
    		stockLevelDetailManager.addEntity(detail);
    		detail.setStockLevel(level);
    	}catch(Exception e){
    		logger.error("保存商品库存详情异常："+e.getMessage());
    	}
    	
      return detail;  
        
		
	}
}
