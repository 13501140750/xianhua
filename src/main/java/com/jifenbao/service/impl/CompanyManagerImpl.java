/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.jifenbao.model.Brand;
import com.jifenbao.model.Company;
import com.jifenbao.model.Supplier;
import com.jifenbao.model.Warehouse;
import com.jifenbao.service.CompanyManager;
import com.jifenbao.service.SupplierManager;
import com.jifenbao.service.WarehouseManager;

/**
 *
 * @ClassName      CompanyManagerImpl
 * @Description
 * Company
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Company对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-08 15:59:49
 * @version     1.0 
 *
 */

@Service(CompanyManager.BEAN_NAME)
@Transactional
public class CompanyManagerImpl extends MybatisServiceImpl<Company, Long> implements CompanyManager {
	
	@Resource
	SupplierManager supplierManager;
	
	@Resource
	WarehouseManager warehouseManager;

	@Override
	public String genCode() {
		String code =(String) this.findUniqueBy(entityClass.getSimpleName()+".getMaxCatCode");
        if(StringUtils.isBlank(code)) code="0";
		int num = Integer.parseInt(code);
		num ++;
		DecimalFormat df=new DecimalFormat("000000");
	    String str2=df.format(num);
		return str2;
	}

	@Override
	public void batUpdateDeleteYn(Long[] ids, String updateUser) {
		if(ids!=null){
			for(long id:ids){
				Company bean= this.getEntity(id);
				bean.setDeleteYn(YesNot.YES.getCode());
				bean.setUpdateTime(new Date());
				bean.setUpdateUser(updateUser);
	            this.modifyEntity(bean);
			}
		}
	}

	@Override
	public void batUpdateDisabledYn(Long[] ids,String disabled, String updateUser) {
		if(ids!=null){
			for(long id:ids){
				Company bean= this.getEntity(id);
				bean.setDisabledYn(disabled);
				bean.setUpdateTime(new Date());
				bean.setUpdateUser(updateUser);
	            this.modifyEntity(bean);
			}
		}
		
	}

	@Override
	public boolean vaildateCompany(Company bean) {
		boolean bl = false;
		if(StringUtils.isNotBlank(bean.getName())){
			Company com1  = new Company();
			com1.setName(bean.getName());
			com1.setId(bean.getId());
			if(!this.isExists(com1)){//如名称不重复则校验营业执照号
				if(StringUtils.isNotBlank(bean.getBusinessLicenceNo())){
					Company com2  = new Company();
					com2.setId(bean.getId());
					com2.setBusinessLicenceNo(bean.getBusinessLicenceNo());
					if(this.isExists(com2)){
						bl = false;
					}else{
						bl = true;
					}
				}else{
					bl = true;
				}
				
			}
			
		}
		
		return bl;
	}

	@Override
	public Company getCompanyByCardno(String cardno) {
		return (Company)super.findUniqueBy(entityClass.getSimpleName()+".getCompanyByCardno", cardno);
	}

	@Override
	public Company getCompanyByCustomName(String customerName) {
		return (Company)super.findUniqueBy(entityClass.getSimpleName()+".getCompanyByCustomName", customerName);
		
	}

	@Override
	public void addCompantAndRrelationship(Company bean) {
		
		if(StringUtils.isNotBlank(bean.getCoopModel())){//合作模式不为空
			String model = bean.getCoopModel();
			if(model.equals("0")){//供货，及一件代发,需建立两条供货关系以及新建仓库
				supplierManager.addSupplierFromCompany(bean);
				Warehouse house = supplierManager.addSupplierAndWareHouseFromCompany(bean);
				bean.setDefaultWarehouseCode(house.getId().toString());
			}else if(model.equals("1")){//一件代发,需新建仓库
				Warehouse house =  supplierManager.addSupplierAndWareHouseFromCompany(bean);
				bean.setDefaultWarehouseCode(house.getId().toString());
			}else if(model.equals("2")){//仅供货,不需新建仓库
				supplierManager.addSupplierFromCompany(bean);
			}
		}
		this.addEntity(bean);
		
	}

	@Override
	public void updateCompantAndRrelationship(Company bean) {
	    //this.modifyEntity(bean);
		Company oldCompany = this.getEntity(bean.getId());
		bean.setCode(oldCompany.getCode());
		if(oldCompany.getCoopModel().equals(bean.getCoopModel())){//合作方式没有编号则直接修改公司信息
			this.modifyEntity(bean);
		}else{
			String model = bean.getCoopModel();
			if(model.equals("0")){//供货，及一件代发  和  一件代发
				//查询当前公司下是否有对应的供货关系，有则不新建，没有则新建
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("companyCode", oldCompany.getCode());
				map.put("type", "1");
				map.put("deleteYn", "0");
				List<Supplier> supplierList =  supplierManager.findByMap(map);
				if(supplierList==null || supplierList.isEmpty()){
					Warehouse house = supplierManager.addSupplierAndWareHouseFromCompany(bean);
					if(StringUtils.isBlank(bean.getDefaultWarehouseCode())){
						bean.setDefaultWarehouseCode(house.getId()+"");
					}
				}
			}else{//批量供货
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("companyCode", oldCompany.getCode());
				map.put("type", "2");
				map.put("deleteYn", "0");
				List<Supplier> supplierList =  supplierManager.findByMap(map);
				if(supplierList==null || supplierList.isEmpty()){
					supplierManager.addSupplierFromCompany(bean);
				}
			}
			
			
		}
		this.update(bean);
	}
    
    
}
