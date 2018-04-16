/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;
import com.jifenbao.model.Company;
import com.jifenbao.model.Supplier;
import com.jifenbao.model.Warehouse;
import com.jifenbao.service.SupplierManager;
import com.jifenbao.service.WarehouseManager;

/**
 *
 * @ClassName      SupplierManagerImpl
 * @Description
 * Supplier
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Supplier对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-23 17:34:11
 * @version     1.0 
 *
 */

@Service(SupplierManager.BEAN_NAME)
@Transactional
public class SupplierManagerImpl extends MybatisServiceImpl<Supplier, Integer> implements SupplierManager {

	@Resource
	WarehouseManager warehouseManager;
	
	/*
	 * 查询该公司下面批量
	 * (non-Javadoc)
	 * @see com.jifenbao.service.SupplierManager#getSendSupplierByCompanyCode(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getSendSupplierByCompanyCode(String companyCode) {
		return this.findAll(entityClass.getSimpleName()+".selectSendSupplierByCompanyCode", companyCode);
    }

	@Override
	public Supplier addSupplierFromCompany(Company company) {
		Supplier supplier = new Supplier();
		supplier.setCompanyCode(company.getCode());
		supplier.setName(company.getName()+"-"+"批量供货");
		supplier.setType(2);//批量供货。不需要仓库
		supplier.setDisabledYn("0");
		supplier.setDeleteYn("0");
		supplier.setCreateUser(company.getCreateUser());
		supplier.setCreateTime(company.getCreateTime());
		supplier.setUpdateUser(company.getUpdateUser());
		supplier.setUpdateTime(company.getUpdateTime());
		this.addEntity(supplier);
		return supplier;
		/*if(company.getType().equals("1")){//需要同时添加仓库信息
			Warehouse  warehouse = new Warehouse();  
			warehouse.setName(company.getName()+"仓库");
			warehouse.setAddress(company.getWarehouseAddress());
			warehouse.setContact(company.getContractNo());
		}*/
		
	}
	
	@Override
	public Warehouse addSupplierAndWareHouseFromCompany(Company company) {
		Supplier supplier = new Supplier();
		supplier.setCompanyCode(company.getCode());
		supplier.setName(company.getName()+"-"+"一件代发");
		supplier.setType(1);//一件代发需要仓库
		supplier.setCreateUser(company.getCreateUser());
		supplier.setCreateTime(company.getCreateTime());
		supplier.setUpdateUser(company.getUpdateUser());
		supplier.setUpdateTime(company.getUpdateTime());
		supplier.setDisabledYn("0");
		supplier.setDeleteYn("0");
		this.addEntity(supplier);
		Warehouse  warehouse = new Warehouse();  
		
		warehouse.setName(company.getName()+"-仓库");
		warehouse.setType(1);//仓库类型为一件代发供应商仓库
		warehouse.setAddress(company.getWarehouseAddress());
		warehouse.setContact(company.getCustomerNo());
		warehouse.setPhone(company.getPhone());
		warehouse.setSupplierId(supplier.getId());
		warehouse.setDisabledYn("0");
		warehouse.setDeleteYn("0");
		warehouse.setCreateUser(company.getCreateUser());
		warehouse.setCreateTime(company.getCreateTime());
		warehouse.setUpdateUser(company.getUpdateUser());
		warehouse.setUpdateTime(company.getUpdateTime());
		warehouseManager.addEntity(warehouse);
		return warehouse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> findSupplierFromStockLevelId(Integer stockLevelId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("stockLevelId",  stockLevelId);
		return this.findAll(entityClass.getSimpleName()+".selectByStockLevelId", map);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jifenbao.service.SupplierManager#getSupplierByCompanyCode(java.lang.String, java.lang.String)
	 */
	@Override
	public Supplier getSupplierByCompanyCode(String companyCode, String type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("companyCode", companyCode);
		map.put("type", type);
		map.put("disabledYn", "0");
		map.put("deleteYn", "0");
		List<Supplier> list = this.findByMap(map);
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
    
    
}
