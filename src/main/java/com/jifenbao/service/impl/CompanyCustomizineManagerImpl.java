/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;
import com.jifenbao.common.JfbUtil;
import com.jifenbao.model.CompanyCustomizine;
import com.jifenbao.model.Product;
import com.jifenbao.model.ProductComment;
import com.jifenbao.service.CompanyCustomizineManager;
import com.jifenbao.service.ProductCommentManager;
import com.jifenbao.service.ProductGroupManager;
import com.jifenbao.service.ProductManager;

/**
 *
 * @ClassName      CompanyCustomizineManagerImpl
 * @Description
 * CompanyCustomizine
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CompanyCustomizine对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-04-20 16:44:53
 * @version     1.0 
 *
 */




@Service(CompanyCustomizineManager.BEAN_NAME)
@Transactional
public class CompanyCustomizineManagerImpl extends MybatisServiceImpl<CompanyCustomizine, Integer> implements CompanyCustomizineManager {

	
	 @Resource
	 ProductManager productManager;
	 
	 @Resource
	 ProductCommentManager productCommentManager;
	
	@Override
	public boolean validateCompanyCode(CompanyCustomizine bean) {
		// TODO Auto-generated method stub
		CompanyCustomizine vailBean = new CompanyCustomizine();
		vailBean.setCompanyCode(bean.getCompanyCode());
		vailBean.setNotId(bean.getId());
		vailBean.setDeleteYn(YesNot.NOT.getCode());
		vailBean.setDisabledYn(YesNot.NOT.getCode());
		return !this.isExists(entityClass.getSimpleName()+".existsCompanyCode", vailBean);
		
	}

	@Override
	public void addCompanyCustomizine(CompanyCustomizine bean) {
		/*if(StringUtils.isNotBlank(bean.getModifyPrdPriceYn()) && bean.getModifyPrdPriceYn().equals("Y")){//定制价格
			this.adjustProduct(bean);
        }*/
		this.addEntity(bean);
	}
    
	
	/**
	 * 根据公司配置定制产品价格
	 * @param bean
	 */
    public void  adjustProduct(CompanyCustomizine bean){
     	Map<String,Object> map = new HashMap<String,Object>();
     	map.put("salesStatus", "Y");
     	map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
     	map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
     	List<Product> list = productManager.findByMap(map);
     	List<ProductComment> commentList = new ArrayList<ProductComment>();
     	if(list!=null){
     		Double rate = bean.getMadePriceRate();
     		if(rate!=0 && rate!=0.0){
     			rate = rate/100;
     		}
     		Double priceAdjust = bean.getPriceAdjust();
     		for(Product product:list){
     			ProductComment prdComment = new ProductComment();
     			prdComment.setCompanyCode(bean.getCompanyCode());
     			prdComment.setPrdShowPriceType(bean.getProductShowType());
     			
     			prdComment.setProductCode(product.getCode());
     			prdComment.setTitle(product.getTitle());
     			prdComment.setShowCode(product.getShowCode());
     			prdComment.setFeatures(product.getFeatures());
     			prdComment.setDescription(product.getDescription());
     			prdComment.setPurchasePrice(product.getSupplyPrice());
     			prdComment.setMarketPrice(product.getMarketPrice());
     			
     			Double price = 0.0;
        	    if(StringUtils.isNotBlank(bean.getMadePriceType())&&bean.getMadePriceType().equals("1")){//按销售价格
        	    	price = product.getSalesPrice();
        	    }else if(StringUtils.isNotBlank(bean.getMadePriceType())&&bean.getMadePriceType().equals("2")){//按采购价格
        	    	price = product.getSupplyPrice();
        	    }
           	   
           	    price = price+JfbUtil.doubleMult(price, rate)+priceAdjust;
           	    
           	    prdComment.setSalesPrice(price);
           	    
     			prdComment.setDisabledYn(YesNot.NOT.getCode());
     			prdComment.setDeleteYn(YesNot.NOT.getCode());
     			prdComment.setCreateUser(bean.getCreateUser());
     			prdComment.setCreateTime(bean.getCreateTime());
     			commentList.add(prdComment);
     		}
     		productCommentManager.deleteCommentByCompanyCode(bean.getCompanyCode());
     		productCommentManager.saveAll(commentList);//批量保存
     	}
    }

	@Override
	public void modifyCustomizine(CompanyCustomizine bean) {
	
		/*if(bean.getModifyPrdPriceYn().equals("Y")){//定制价格
			this.adjustProduct(bean);
        }else{
        	productCommentManager.deleteCommentByCompanyCode(bean.getCompanyCode());
        }*/
		
		this.addEntity(bean);
	}

	@Override
	public void deleteCustomizine(CompanyCustomizine bean) {
		bean.setDeleteYn(YesNot.YES.getCode());
		this.modifyEntity(bean);
		//productCommentManager.deleteCommentByCompanyCode(bean.getCompanyCode());
	}

	@Override
	public CompanyCustomizine getByCompanyCode(String companyCode) {
		// TODO Auto-generated method stub
		return (CompanyCustomizine) super.findUniqueBy(entityClass.getSimpleName()+".selectByCompanyCode", companyCode);
	}
	
	@Override
	public Double getCompayJiFeRate(String companyCode){
		Double showPriceRate = 1.0;
		CompanyCustomizine customizine = this.getByCompanyCode(companyCode);
		if(customizine!=null && customizine.getPriceExchangeRate()!=null)
		    showPriceRate = customizine.getPriceExchangeRate();
		return  showPriceRate;
	}
	
}
