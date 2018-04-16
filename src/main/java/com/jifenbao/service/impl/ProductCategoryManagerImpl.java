/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.ProductCategory;
import com.jifenbao.service.ProductCategoryManager;
import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      ProductCategoryManagerImpl
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

@Service(ProductCategoryManager.BEAN_NAME)
@Transactional
public class ProductCategoryManagerImpl extends MybatisServiceImpl<ProductCategory, Long> implements ProductCategoryManager {

	/*
	 * (non-Javadoc)
	 * @see com.jifenbao.service.ProductCategoryManager#getTopCat()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategory> getTopCatByMap(Map<String,Object> map) {
		return this.findAll(entityClass.getSimpleName()+".getTopCat", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategory> findCatByParentCode(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return this.findAll(entityClass.getSimpleName()+".getSubCatByMap", map);
	}

	@Override
	public String getTreehtml(List<ProductCategory> list) {
		StringBuffer bf = new StringBuffer();
		if(list!=null && !list.isEmpty()){
			for(int i=0;i<list.size();i++){
				ProductCategory cat = list.get(i);
				bf.append("<tr data-level=\"1\"")
				.append(" id=\"level_1_")
				.append(cat.getId())
				.append("\" >");
				/*bf.append("<td class=\"data\">"+cat.getCode()+"</td>");*/
				bf.append("<td class=\"data\"><input type=\"text\" class=\"form-control\" name=\"name\" value=\""+cat.getName()+"\"/></td>");
				bf.append("<td class=\"data\">"+cat.getCreateTimeString()+"</td>");
				bf.append("<td class=\"data\">删除    查看</td>");
				bf.append("</tr>");
				String subString = this.getSubCat(cat, 1);
				bf.append(subString);
			}
		}
		return bf.toString();
	}
	
	public String getSubCat(ProductCategory cat,int level){
		List <ProductCategory> sublist = cat.getSubCatList();
		StringBuffer bf = new StringBuffer();
		if(sublist!=null && !sublist.isEmpty()){
			for(int i=0;i<sublist.size();i++){
				ProductCategory subcat = sublist.get(i);
				bf.append("<tr data-level=\"")
				  .append(level+1).append("\"")
				  .append(" id=\"level_").append(level+1).append("_").append(cat.getCode()).append("_").append(subcat.getId()).append("\" >");
				/*bf.append("<td class=\"data\">"+cat.getCode()+"</td>");*/
				bf.append("<td class=\"data\"><input type=\"text\" name=\"name\" class=\"form-control\" value=\""+subcat.getName()+"\"/></td>");
				bf.append("<td class=\"data\">"+subcat.getCreateTimeString()+"</td>");
				bf.append("<td class=\"data\">删除    查看</td>");
				bf.append("</tr>");
				//List<ProductCategory> ssubList = cat.getSubCatList();
				bf.append(this.getSubCat(subcat, level+1));
			}
		}
		return bf.toString();
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
			if(StringUtils.isNotBlank(parent)){
	          	 ProductCategory parCat = this.findUniqueByProperty("code", parent);
	             //将父类对象标志设置为Y
	             if(parCat!=null && (StringUtils.isBlank(parCat.getParentYn()) || parCat.getParentYn().equals("N"))){
	            	 parCat.setParentYn("Y");
	               	 this.modifyEntity(parCat);
	             }
	          }else{
	        	  parent = "0";
	          }
			List<ProductCategory> list = new ArrayList<ProductCategory> ();
			for(String subName :name){
				ProductCategory bean  = new ProductCategory();
				bean.setName(subName);
				bean.setDisabledYn(YesNot.NOT.getCode());
	            bean.setDeleteYn(YesNot.NOT.getCode());
	            bean.setParentYn(YesNot.NOT.getCode());
	            //bean.setCreateUser(getLoginUser().getLoginId());
	            bean.setCreateTime(DateTimeUtil.now());
	            bean.setCode(this.genCode());
	            bean.setParent(parent);
	            list.add(bean);
	            this.addEntity(bean);
			}
			
			//this.batchInsert(ProductCategory.class, list);
			
		}
		
		
	}

	@Override
	 public void batupdateDelYn(String[] codes,String update) {
		for(String code:codes){
			ProductCategory bean  = this.findUniqueByProperty("code", code);
			if(bean!=null){
				bean.setUpdateUser(update);
				bean.setUpdateTime(DateTimeUtil.now());
    			bean.setDeleteYn(YesNot.YES.getCode());
    			this.modifyEntity(bean);
			}
		}
		
	}

	@Override
	public Map<String, List<ProductCategory>> getParentsCat(String subCode,Map<String, List<ProductCategory>> prdCatMap) {
		/*ProductCategory bean  = this.findUniqueByProperty("code", subCode);
		String parentCode =  bean.getParent();//当前子类的父类目
*/		
		if(prdCatMap==null) {
			
			prdCatMap = new TreeMap<String, List<ProductCategory>>();
		}
		
		if(StringUtils.isNotBlank(subCode) && !"0".equals(subCode)){//不是第一级类目
			ProductCategory bean  = this.findUniqueByProperty("code", subCode);
			//查询父类目的同级类目
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", bean.getParent());
			List<ProductCategory> prdCatList  =  this.findCatByParentCode(map);
			prdCatMap.put(subCode, prdCatList);
			this.getParentsCat(bean.getParent(), prdCatMap);
		}else{//父类目已经是一级类目，则查询一级类目列表
			return prdCatMap;
		}
		return prdCatMap;
	}

	@Override
	public String getShowCatName(String subCode, String showCatName) {
		if(showCatName==null)  {
			showCatName = "";
		}
		if(StringUtils.isNotBlank(subCode) && !"0".equals(subCode)){//不是第一级类目
			ProductCategory bean  = this.findUniqueByProperty("code", subCode);
			//查询父类目
			//ProductCategory parCat  = this.findUniqueByProperty("code", bean.getParent()) ;
			showCatName = bean.getName() + " > " + showCatName ;
			showCatName = this.getShowCatName(bean.getParent(), showCatName);
		}else{//父类目已经是一级类目，则查询一级类目列表
			
			return showCatName;
		}
		
		return showCatName;
	}

	@Override
	public List<ProductCategory> getParentProductCategory(String subCode, List<ProductCategory> prdCatList) {
		if(prdCatList==null){
			prdCatList =  new ArrayList<ProductCategory>();
		}
		if(StringUtils.isNotBlank(subCode) && !"0".equals(subCode)){//不是第一级类目
			ProductCategory bean  = this.findUniqueByProperty("code", subCode);
			prdCatList.add(bean);
			this.getParentProductCategory(bean.getParent(), prdCatList);
			//查询父类目
			
		}else{//父类目已经是一级类目，则查询一级类目列表
			
			return prdCatList;
		}
		return prdCatList;
	}

	@Override
	public List<ProductCategory> getAllProductCategory() {
		
		return this.findAll(entityClass.getSimpleName()+".getAllCat",null);
	}

	@Override
	public List<ProductCategory> findCatByParentCode(String code) {
		return this.findAll(entityClass.getSimpleName()+".getSubCat", code);
	}

	@Override
	public List<String> getSubProductCatCode(String productCatCode) {
		List<String>  prdCatCodeList = new ArrayList<String>();
		List<ProductCategory> prdCatList = this.findCatByParentCode(productCatCode) ;
		prdCatCodeList.add(productCatCode);
		return this.getCodeList(prdCatList, prdCatCodeList);
	}
    
    
	public  List<String> getCodeList(List<ProductCategory> prdCatList,List<String>  prdCatCodeList){
		if(prdCatList!=null &&  !prdCatList.isEmpty()){
			for(ProductCategory prdCat:prdCatList){
				prdCatCodeList.add(prdCat.getCode());
				if(prdCat.getSubCatList()!=null && !prdCat.getSubCatList().isEmpty()){
					this.getCodeList(prdCat.getSubCatList(), prdCatCodeList);
				}
			}
		}
		return prdCatCodeList;
	}

	@Override
	public List<ProductCategory> findByParentCode(Map<String, Object> catMap) {
		return null;
	}
}
