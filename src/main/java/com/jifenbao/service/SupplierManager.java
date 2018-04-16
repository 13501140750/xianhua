/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.Company;
import com.jifenbao.model.Supplier;
import com.jifenbao.model.Warehouse;
import com.otc.framework.service.BaseManager;

/**
 *
 * @ClassName      SupplierManager
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

public interface SupplierManager extends BaseManager<Supplier, Integer> {
	
	
	
    /**
     * Bean名称
     */
    String BEAN_NAME = "supplierManager";

    /**
     * 根据供应关系类型查询该公司下的供应关系
     * @param companyCode  公司编码
     * @param type       1:一件代发  2：批量供货
     * @return
     */
    public Supplier  getSupplierByCompanyCode(String companyCode,String type);
    /**
     * 查询该公司下所有代营的供应商
     * @param companyCode
     * @return
     */
    public List<Supplier>  getSendSupplierByCompanyCode(String companyCode);
    
    /**
     * 新增供货关系不需要添加仓库
     */
    public Supplier  addSupplierFromCompany(Company company);
    
    /**
     * 新增供货关系同时添加仓库信息
     */
    public Warehouse  addSupplierAndWareHouseFromCompany(Company company);
    
    
    /**
     * 
     * 查询库存中该商品全部的供应商
     * @param stockLevelId
     * @return
     */
    public List<Supplier>  findSupplierFromStockLevelId(Integer stockLevelId);

}
