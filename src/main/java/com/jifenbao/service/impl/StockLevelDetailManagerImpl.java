/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.StockLevelDetail;
import com.jifenbao.service.StockLevelDetailManager;
import com.jifenbao.service.StockLevelManager;
import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.model.Order;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName      StockLevelDetailManagerImpl
 * @Description
 * StockLevelDetail
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对StockLevelDetail对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-23 17:09:18
 * @version     1.0 
 *
 */

@Service(StockLevelDetailManager.BEAN_NAME)
@Transactional
public class StockLevelDetailManagerImpl extends MybatisServiceImpl<StockLevelDetail, Integer> implements StockLevelDetailManager {

	@Resource
	StockLevelManager stockLevelManager;
	
	@Override
	public StockLevelDetail getStockDetailByLevelId(Integer stockLevelId) {
	
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("stockLevelId",stockLevelId);
			map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
			map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
			List<Order> orderby = new ArrayList<Order>();
			orderby.add(Order.desc("amount"));
		    orderby.add(Order.asc("id"));
			List<StockLevelDetail> list = this.findByMap(map);
			if(list!=null && !list.isEmpty()){
				return list.get(0);
			}
		
		return null;
	}

	@Override
	public StockLevelDetail getStockDetailByProduct(Map<String, Object> map) {
		return (StockLevelDetail) this.findUniqueBy(entityClass.getSimpleName()+".selectByProduct", map);
	}

	
	/**
	 * 自动生成批次号
	 */
	@Override
	public String createBathchNo() {
		String batchNo = "";
		String code =(String) this.findUniqueBy(entityClass.getSimpleName()+".getMaxBatchCode");
		Date now = DateTimeUtil.now();
		int year = DateTimeUtil.getYearOfDate(now);
		int month = DateTimeUtil.getMonthOfDate(now);
        String numString = "";
		if(StringUtils.isBlank(code)) {
        	code = "";
        	numString = "0";
        	if(month<10){
        		code = year+"0"+month;
        	}else{
        		code = year+""+month;
        	}
        }else{
        	int oYear = Integer.parseInt(code.substring(0, 4));
        	
        	if(oYear!=year){//新的一年是code从新的一年开始
        		
            	if(month<10){
            		code = year+"0"+month;
            	}else{
            		code = year+""+month;
            	}
            	numString = "0";
        	}else{
        		numString = code.substring(code.length()-4,code.length());
        		code = code.substring(0,6);
        	}
        }
		int num = Integer.parseInt(numString);
		num ++;
		DecimalFormat df=new DecimalFormat("000000");
		batchNo = code + df.format(num);
		
		
		
		
		return batchNo;
	}
	
	
    
}
