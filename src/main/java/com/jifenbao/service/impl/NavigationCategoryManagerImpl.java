/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;
import com.jifenbao.common.Constant;
import com.jifenbao.model.NavigationCategory;
import com.jifenbao.model.ProductCategory;
import com.jifenbao.service.NavigationCategoryManager;

/**
 *
 * @ClassName      NavigationCategoryManagerImpl
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

@Service(NavigationCategoryManager.BEAN_NAME)
@Transactional
public class NavigationCategoryManagerImpl extends MybatisServiceImpl<NavigationCategory, Integer> implements NavigationCategoryManager {

	@SuppressWarnings("unchecked")
	@Override
	public List<NavigationCategory> getTopCat() {
		return this.findAll(entityClass.getSimpleName()+".getTopCat", null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NavigationCategory> findCatByParentCode(String parCode) {
		return this.findAll(entityClass.getSimpleName()+".getSubCat", parCode);
	}

	@Override
	public List<NavigationCategory> findCatByParentCode(Map<String, Object> map) {
		return this.findAll(entityClass.getSimpleName()+".getSubCatByMap", map);
	}
	

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
	public void batchSave(String[] name, String parent) {
		if(name!=null){
			if(StringUtils.isBlank(parent)){
	        	  parent = "0";
	         }
			List<NavigationCategory> list = new ArrayList<NavigationCategory> ();
			for(String subName :name){
				NavigationCategory bean  = new NavigationCategory();
				bean.setName(subName);
				bean.setDisabledYn(YesNot.NOT.getCode());
	            bean.setDeleteYn(YesNot.NOT.getCode());
	            bean.setCreateUser("adminUser");
	            bean.setCreateTime(DateTimeUtil.now());
	            bean.setCode(this.genCode());
	            bean.setParent(parent);
	            list.add(bean);
	            this.addEntity(bean);
			}
			
			//this.batchInsert(NavigationCategory.class, list);
			
		}
		
		
	}

	@Override
	public void updateDelYn(int id) {
		NavigationCategory cat  =  this.getEntity(id);
		if(cat!=null){
			cat.setDeleteYn(YesNot.YES.getCode());
			this.modifyEntity(cat);
			this.update(entityClass.getSimpleName()+".delByParCode", cat.getCode());
		}
	}

	@Override
	public List<NavigationCategory> getParentProductCategory(String subCode, List<NavigationCategory> prdCatList) {
		if(prdCatList==null){
			prdCatList =  new ArrayList<NavigationCategory>();
		}
		if(StringUtils.isNotBlank(subCode) && !"0".equals(subCode)){//不是第一级类目
			NavigationCategory bean  = this.findUniqueByProperty("code", subCode);
			prdCatList.add(bean);
			this.getParentProductCategory(bean.getParent(), prdCatList);
			//查询父类目
			
		}else{//父类目已经是一级类目，则查询一级类目列表
			
			return prdCatList;
		}
		return prdCatList;
	}

	@Override
	public String getNavCatForName(String code) {
		if(StringUtils.isNotBlank(code)){
			return (String) super.findUniqueBy(entityClass.getSimpleName()+".getShowCatForPrd", code);
		}else{
			return "";
		}
		
	}

	@Override
	public List<NavigationCategory> getCusmNavList(String parentCode) {
		
		return this.findAll(entityClass.getSimpleName()+".findCusmNavList",parentCode);
	}

	@Override
	public List<NavigationCategory> getTopCatByMap(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return this.findAll(entityClass.getSimpleName()+".getTopCat", map);
	}

	@Override
	public List<NavigationCategory> getHomeShowList() {
		return this.findAll(entityClass.getSimpleName() + ".findHomeShowList", null);
	}

	
	
    
    
}
