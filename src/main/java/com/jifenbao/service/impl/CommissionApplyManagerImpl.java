/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */

package com.jifenbao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;
import com.jifenbao.common.JfbUtil;
import com.jifenbao.common.WxUtil;
import com.jifenbao.model.CommissionApply;
import com.jifenbao.model.CustomerCreditLog;
import com.jifenbao.model.CustomerInfo;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.service.CommissionApplyManager;
import com.jifenbao.service.CustomerCreditLogManager;
import com.jifenbao.service.CustomerInfoManager;
import com.jifenbao.service.ExchangeOrderDetailManager;
import com.jifenbao.service.ExchangeOrderManager;
import com.jifenbao.thirdAPI.WxPayConfig;

/**
 *
 * @ClassName      CommissionApplyManagerImpl
 * @Description
 * CommissionApply
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CommissionApply对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-26 12:44:19
 * @version     1.0 
 *
 */

@Service(CommissionApplyManager.BEAN_NAME)
@Transactional
public class CommissionApplyManagerImpl extends MybatisServiceImpl<CommissionApply, Long> implements CommissionApplyManager {
    
    @Resource(name = ExchangeOrderManager.BEAN_NAME)
    private ExchangeOrderManager exchangeOrderManager;
    
    @Resource(name = ExchangeOrderDetailManager.BEAN_NAME)
    private ExchangeOrderDetailManager exchangeOrderDetailManager;
    
    @Resource(name = CustomerInfoManager.BEAN_NAME)
    private CustomerInfoManager customerInfoManager;
    
    @Resource(name = CustomerCreditLogManager.BEAN_NAME)
    private CustomerCreditLogManager customerCreditLogManager;
	
	
	@Override
	public void batchDelete(Long[] ids, String operUser) {
		for(Long id:ids){
			CommissionApply bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDeleteYn(YesNot.YES.getCode());
  			this.modifyEntity(bean);
			}
		}
		
	}
	
	@Override
	public void batchDisabled(Long[] ids, String operUser, String oper) {
		for(Long id:ids){
			CommissionApply bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}

	@Override
	public CommissionApply getEntityById(Long id) {
		List list = this.findAll(entityClass.getSimpleName() + ".selectById", id);
		if(list != null && list.size() > 0){
			CommissionApply apply =(CommissionApply) list.get(0);
			String[] split = apply.getOrderIds().split(",");
			Long[] idArr = new Long[split.length];
			for (int i = 0; i < split.length; i++) {
				idArr[i] = Long.valueOf(split[i]);
			}
			List<ExchangeOrder> orderList = exchangeOrderManager.seldectOrderByIds(idArr);
			apply.setOrderList(orderList);
			return apply;
		}
		
		return null;
	}

	@Override
	public void check(Long id, List<ExchangeOrderDetail> orderDetailList, String operUser) {
		CommissionApply entity = this.getEntity(id);
		if(entity.getStatus() != 1){
			throw new BusinessException("此申请无法审核!");
		}
		if(orderDetailList == null || orderDetailList.size() < 1){
			throw new BusinessException("订单项为空");
		}
		Date now = DateTimeUtil.now();
		//将订单详情的status1的状态
		for (ExchangeOrderDetail exchangeOrderDetail : orderDetailList) {
			if(exchangeOrderDetail.getStatus1() == null){
				throw new BusinessException("审核状态不能为空");
			}
			exchangeOrderDetail.setCheckTime(now);
			exchangeOrderDetailManager.modifyEntity(exchangeOrderDetail);
		}
		
		//将提现申请状态设置为2已审核
		CommissionApply apply = new CommissionApply();
		apply.setId(id);
		apply.setStatus(2);
		apply.setCheckTime(now);
		apply.setUpdateUser(operUser);
		super.modifyEntity(apply);
		
	}

	@Override
	public void cancel(Long id, String name) {
		CommissionApply entity = this.getEntityById(id);
		if(entity.getStatus() != 2 && entity.getStatus() != -1){
			throw new BusinessException("此申请无法取消!");
		}
		
		entity.setStatus(1);
		entity.setCheckTime(null);
		Date now = DateTimeUtil.now();
		entity.setUpdateTime(now);
		entity.setUpdateUser(name);
		entity.setInvalidTime(null);
		int update = super.getSqlSession().update(entityClass.getSimpleName() + ".updateAll", entity);
		
		//订单详情状态修改
		List<ExchangeOrder> orderList = entity.getOrderList();
		for (ExchangeOrder exchangeOrder : orderList) {
			for (ExchangeOrderDetail detail : exchangeOrder.getOrderDetailList()) {
				detail.setStatus1(1);
				detail.setCheckTime(null);
				detail.setUpdateTime(now);
				detail.setUpdateUser(name);
				exchangeOrderDetailManager.updateCheckStatus(detail);
			}
		}
		
	}

	@Override
	public void refuse(Long id, String name) {
		CommissionApply entity = this.getEntityById(id);
		if(entity.getStatus() != 1){
			throw new BusinessException("此申请无法拒绝!");
		}
		
		Date now = DateTimeUtil.now();
		entity.setStatus(-2);
		entity.setRefuseTime(now);
		entity.setUpdateTime(now);
		entity.setUpdateUser(name);
		int update = super.getSqlSession().update(entityClass.getSimpleName() + ".updateAll", entity);
		
		//订单详情状态修改
		List<ExchangeOrder> orderList = entity.getOrderList();
		for (ExchangeOrder exchangeOrder : orderList) {
			for (ExchangeOrderDetail detail : exchangeOrder.getOrderDetailList()) {
				detail.setStatus1(0);
				detail.setUpdateTime(now);
				detail.setUpdateUser(name);
				exchangeOrderDetailManager.updateCheckStatus(detail);
			}
		}
		
	}

	@Override
	public void pay(Long id,  String name) {
		CommissionApply entity = this.getEntityById(id);
		if(entity.getStatus() != 2){
			throw new BusinessException("此申请不能打款!");
		}
		
		Double realMoney = entity.getRealMoney();
		
		Date now = DateTimeUtil.now();
		entity.setStatus(3);
		entity.setPayTime(now);
		entity.setUpdateTime(now);
		entity.setUpdateUser(name);
		int update = super.getSqlSession().update(entityClass.getSimpleName() + ".updateAll", entity);
		
		
		CustomerInfo customer = customerInfoManager.getEntity(entity.getCustomerId());
		if(entity.getType() == 1001){
			//提现到账户余额
			CustomerInfo updateCustomer = new CustomerInfo();
			updateCustomer.setId(customer.getId());
			updateCustomer.setCredit2(realMoney + customer.getCredit2());
			customerInfoManager.modifyEntity(updateCustomer);
			
			//创建日志记录
			CustomerCreditLog creditLog = new CustomerCreditLog();
			creditLog.setCustomerId(entity.getCustomerId());
			creditLog.setSource(entity.getApplyNo());
			creditLog.setSourceId(entity.getId());
			creditLog.setSourceType("account_balance");
			creditLog.setActionType(1);
			creditLog.setCreditAmount(realMoney);
			creditLog.setBlanceAmout(updateCustomer.getCredit2());
			creditLog.setCreateTime(now);
			creditLog.setCreateUser("system");
			creditLog.setDeleteYn(YesNot.NOT.getCode());
			creditLog.setDisabledYn(YesNot.NOT.getCode());
			customerCreditLogManager.addEntity(creditLog);
			
		}else if(entity.getType() == 1002){
			Map<String, String> params = new HashMap<String, String>();
			params.put("nonce_str", WxUtil.getRandomStringByLength(32));
			params.put("mch_billno", "xhhb" + JfbUtil.createCode(10));
			params.put("mch_id", WxPayConfig.mch_id);
			params.put("wxappid", WxPayConfig.api_id);
			params.put("mch_id", "xhhb" + WxPayConfig.mch_id);
			params.put("send_name", "红玫瑰鲜花平台");
			params.put("re_openid", customer.getOpenid());
			params.put("total_amount", realMoney * 100 + "");
			params.put("total_num", "1");
			params.put("wishing", "红玫瑰鲜花平台,祝您购物愉快");
			params.put("client_ip", "127.0.0.1");
			params.put("act_name", "佣金提现");
			params.put("remark", "分享成功订单越多,获取的佣金越多");
			params.put("sign", WxUtil.sign(params, WxPayConfig.key, "UTF-8"));
			String xml = WxUtil.getRequestXml(params);
			 
			try {
				String xmlResult = WxUtil.httpRequest(WxPayConfig.pay_url, "POST", xml); 
				Map map = WxUtil.doXMLParse(xmlResult);
				
				String return_code = (String) map.get("return_code");//返回状态码  
	            String result_code = (String) map.get("result_code");
	            if("SUCCESS".equals(return_code)){
	            	if("SUCCESS".equals(result_code)){
	            		 //成功 ,日志记录
	            	}else{
	            		throw new BusinessException((String)map.get("return_msg"));
	            	}
	               
	            }else{
	            	throw new BusinessException("通信异常" + (String)map.get("return_msg"));
	            }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(entity.getType() == 1003){
			
		}else{
			throw new BusinessException("提现方式不存在");
		}
		
		//订单详情状态修改
		List<ExchangeOrder> orderList = entity.getOrderList();
		for (ExchangeOrder exchangeOrder : orderList) {
			for (ExchangeOrderDetail detail : exchangeOrder.getOrderDetailList()) {
				detail.setPayTime(now);
				detail.setStatus1(3);
				detail.setUpdateTime(now);
				detail.setUpdateUser(name);
				exchangeOrderDetailManager.updateCheckStatus(detail);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("nonce_str", WxUtil.getRandomStringByLength(32));
		params.put("mch_billno", "xhhb" + JfbUtil.createCode(10));
		params.put("mch_id", WxPayConfig.mch_id);
		params.put("wxappid", WxPayConfig.api_id);
		params.put("send_name", "红玫瑰鲜花平台");
		params.put("re_openid", "oGhIi0cuZpDWViONfXK8GAQROcZs");
		params.put("total_amount", "1");
		params.put("total_num", "1");
		params.put("wishing", "红玫瑰鲜花平台,祝您购物愉快");
		params.put("client_ip", "127.0.0.1");
		params.put("act_name", "佣金提现");
		params.put("remark", "分享成功订单越多,获取的佣金越多");
		params.put("sign", WxUtil.sign(params, WxPayConfig.key, "UTF-8"));
		String xml = WxUtil.getRequestXml(params);
		 
		try {
			Map<String, String> map = WxUtil.doRefund("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack", xml, WxPayConfig.mch_id);
			
			String return_code = (String) map.get("return_code");//返回状态码  
			String result_code = map.get("result_code")==null?"" : (String)map.get("result_code");
            if("SUCCESS".equals(return_code)){
            	if("SUCCESS".equals(result_code)){
            		 //成功 ,日志记录
            	}else{
            		throw new BusinessException((String)map.get("return_msg"));
            	}
               
            }else{
            	throw new BusinessException((String)map.get("return_msg"));
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public double getTotalCommission(Map<String, Object> map) {
		Double sum = getSqlSession().selectOne(entityClass.getSimpleName() + ".getTotalCommission", map);
		if(sum != null){
			return sum;
		}
		return 0;
	}
	
}
