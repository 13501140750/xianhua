package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.jifenbao.model.StatisticsProduct;
import com.jifenbao.service.StatisticsManager;
import com.otc.framework.service.impl.MybatisServiceImpl;


@Service(StatisticsManager.BEAN_NAME)
public class StatisticsManagerImpl  extends MybatisServiceImpl<StatisticsProduct, Integer> implements StatisticsManager{

	@SuppressWarnings("unchecked")
	@Override
	public List<StatisticsProduct> stateProductDetail(Map<String, Object> map) {
		return super.findAll("Statistics.selectPorductByProvide", map);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StatisticsProduct> stateProductInOut(Map<String, Object> map) {
		return super.findAll("Statistics.selectPorductStock", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> statePurchaseSettlement(Map<String, Object> map) {
		return super.findAll("Statistics.getPurchaseSettlement", map);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> stateGiftCardByCompany(Map<String, Object> map) {
		return super.findAll("Statistics.getGiftCardByCompany", map);
	}
	
	@Override
	@SuppressWarnings("all")
	public Map<String, Object> stateGiftCardByCompanyNew(Map<String, Object> map) {
		List<Map<String, Object>> list1 = super.findAll("Statistics.getGiftCardByCompanyNew", map);
		List<Map<String, Object>> list2 = super.findAll("Statistics.giftcardExchangeProduct", map);
		Map<String, Object> newMap = new HashMap<String, Object>();
		//处理时间填充
		String ddateBegin = (String) map.get("createDateBegin");
		String ddateEnd = (String) map.get("createDateEnd");
		String ddate = null;
		if(StringUtils.isNotBlank(ddateBegin) && StringUtils.isNotBlank(ddateEnd)){
			ddate = ddateBegin + " - " + ddateEnd;
		}else if(StringUtils.isNotBlank(ddateBegin)){
			ddate = ddateBegin;
		}else if(StringUtils.isNotBlank(ddateEnd)){
			ddate = ddateEnd;
		}
		if(StringUtils.isEmpty(ddate)){
			ddate = "所有";
		}
		
		for (Map map1 : list1) {
			map1.put("createDate", ddate);
			List<Map> mapList = new ArrayList<Map>();
			for (Map map2 : list2) {
				if(map2.get("companyCode").toString().equals(map1.get("companyCode").toString()) && map2.get("giftCardCode").toString().equals(map1.get("giftCardCode").toString())){
					mapList.add(map2);
				}
			}
			newMap.put(map1.get("companyCode").toString() + map1.get("giftCardCode").toString(), mapList);
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list1);
		returnMap.put("returnMap", newMap);
		
		return returnMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> stateProcutConvert(Map<String, Object> map) {
		return super.findAll("Statistics.getProductConvert", map);
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> stateProcutConvertNew(Map<String, Object> map) {
		return super.findAll("Statistics.getProductConvertNew", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> stateProductInOuNewt(Map<String, Object> map) {
		List<Map<String, Object>> list = super.findAll("Statistics.selectPorductStockNew", map);
		
		
		if(list != null && list.size() > 0){
			String ddateBegin = (String) map.get("ddateBegin");
			String ddateEnd = (String) map.get("ddateEnd");
			String ddate = null;
			if(StringUtils.isNotBlank(ddateBegin) && StringUtils.isNotBlank(ddateEnd)){
				ddate = ddateBegin + " - " + ddateEnd;
			}else if(StringUtils.isNotBlank(ddateBegin)){
				ddate = ddateBegin;
			}else if(StringUtils.isNotBlank(ddateEnd)){
				ddate = ddateEnd;
			}
			if(StringUtils.isEmpty(ddate)){
				ddate = "所有";
			}
			for (Map<String, Object> map2 : list) {
				map2.put("ddate", ddate);
			}
			
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> supplierOrderPrdGroup(Map<String, Object> map) {
		return super.findAll("Statistics.supplierOrderPrdGroup", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> shippingOrderPrdGroupCompany(Map<String, Object> map) {
		return super.findAll("Statistics.shippingOrderPrdGroupCompany", map);
	}

	@SuppressWarnings({ "all" })
	@Override
	public List<Map<String, Object>> exchangeOrderProductGroup(Map<String, Object> map) {
		List<Map<String, Object>> list = super.findAll("Statistics.exchangeOrderProductGroup", map);
		if(list!=null && list.size()>0){
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Map<String, Object> itemMap = (Map<String, Object>) iterator.next();
				if( ("0".equals(itemMap.get("beihuo") + "")) && ("0".equals(itemMap.get("fahuo") + "")) && ("0".equals(itemMap.get("gys_beihuo") + "")) && ("0".equals(itemMap.get("gys_fahuo") + "")) ){
					iterator.remove();
				}
				
			}
		}
		return list;
	}
	

}
