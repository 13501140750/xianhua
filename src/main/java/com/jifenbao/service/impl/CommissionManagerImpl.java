package com.jifenbao.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.common.BusinessErrorCodeEx;
import com.jifenbao.common.JfbUtil;
import com.jifenbao.model.CommissionApply;
import com.jifenbao.model.CommissionSetting;
import com.jifenbao.model.CustomerInfo;
import com.jifenbao.model.ExchangeOrder;
import com.jifenbao.model.ExchangeOrderDetail;
import com.jifenbao.service.CommissionApplyManager;
import com.jifenbao.service.CommissionSettingManager;
import com.jifenbao.service.CustomerInfoManager;
import com.jifenbao.service.ExchangeOrderDetailManager;
import com.jifenbao.service.ExchangeOrderManager;
import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.page.Page;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;

/** 
* @author 作者 wangyawei: 
* @version 创建时间：2018年1月25日 下午6:07:56 
* 类说明 
*/
@Service("commissionManager")
@Transactional
public class CommissionManagerImpl extends MybatisServiceImpl<Serializable, Serializable>{
	
	public static final String BEAN_NAME = "commissionManager";
	
	@Resource(name = CommissionSettingManager.BEAN_NAME)
	private CommissionSettingManager commissionSettingManager;
	
	@Resource(name = CustomerInfoManager.BEAN_NAME)
	private CustomerInfoManager customerInfoManager;
	
	@Resource(name = CommissionApplyManager.BEAN_NAME)
	private CommissionApplyManager commissionApplyManager;
	
	@Resource(name = ExchangeOrderManager.BEAN_NAME)
	private ExchangeOrderManager exchangeOrderManager;
	
	@Resource(name = ExchangeOrderDetailManager.BEAN_NAME)
	private ExchangeOrderDetailManager exchangeOrderDetailManager;
	
	public String genCode() {
        String code = JfbUtil.createCode(null);
      
        CommissionApply bean = new CommissionApply();
        bean.setApplyNo(code);
        if (commissionApplyManager.isExistsProperty(bean)) {
            logger.info("code已存在");
            return this.genCode();
        } else {
            logger.info("code为最新");
            return code;
        }
    }
	
	
	
	/**
	 * 通过客户id 查询该客户佣金统计数据
	 * @param customerId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object>selectCommissionByCustomerId(Long customerId){
		Map<String, Object> map =  (Map<String, Object>) this.findUniqueBy("Commission.selectCommissionByCustomerId", customerId);
		return  map;
	}
	
	
	public List<Long> getAgentOrderIdByCustomerId(Long customerId){
		@SuppressWarnings("unchecked")
		List<Long> list = this.findAll("Commission.getAgentOrderIdByCustomerId", customerId);
		return list;
	}
	
	public List<Long> getAgentOrderDetailIdByCustomerId(Long customerId){
		@SuppressWarnings("unchecked")
		List<Long> list = this.findAll("Commission.getAgentOrderDetailIdByCustomerId", customerId);
		return list;
	}
	
	
	public void apply(Long customerId, Integer type){
		Map<String, Object> map = selectCommissionByCustomerId(customerId);
		CommissionSetting setting = commissionSettingManager.getConfig();
		double commission_ok = (double)map.get("commission_ok");
		//手续费
		double deductionMoney = 0;
		//实际到账金额
		double realMoney = commission_ok;
		map.put("deductionMoney", deductionMoney);
		
		//是否有手续费
		if(setting.getWithdraw() != null && setting.getWithdraw() > 0){
			if(!(commission_ok>= setting.getWithdrawBegin() && commission_ok <= setting.getWithdrawEnd())){
				deductionMoney =  commission_ok * setting.getWithdraw() / 100;
				realMoney = commission_ok - deductionMoney;
			}
		}
		
		boolean cansettle = realMoney >= setting.getWithdraw() ? true : false;
		//满足提现条件
		if(cansettle){
			List<Long> list = getAgentOrderIdByCustomerId(customerId);
			String ids = "";
			for (Long s : list) {
				ids += s + ",";
			}
			ids = ids.substring(0, ids.length() -1);
			
			
			List<Long> detailIds = getAgentOrderDetailIdByCustomerId(customerId);
			for (Long detailId : detailIds) {
				ExchangeOrderDetail exchangeOrderDetail = new ExchangeOrderDetail();
				exchangeOrderDetail.setId(detailId);
				exchangeOrderDetail.setStatus1(1);
				exchangeOrderDetail.setUpdateTime(DateTimeUtil.now());
				exchangeOrderDetail.setUpdateUser("");
				exchangeOrderDetailManager.modifyEntity(exchangeOrderDetail);
			}
			
			
			
			CommissionApply apply = new CommissionApply();
			apply.setApplyNo("yjtx" + genCode());
			apply.setOrderIds( ids);
			apply.setType(type);
			apply.setCustomerId(customerId);
			apply.setCommission(commission_ok);
			apply.setCommissionPay(realMoney);
			apply.setStatus(1);
			apply.setRealMoney(realMoney);
			apply.setApplyTime(DateTimeUtil.now());
			apply.setCreateTime(DateTimeUtil.now());
			apply.setCharge(setting.getWithdrawCharge());
			apply.setDeductionMoney(deductionMoney);
			apply.setBeginMoney(commission_ok);
			apply.setEndMoney(realMoney);
			apply.setAlipay("");
			apply.setAlipay1("");
			apply.setBankCard("");
			apply.setBankCard1("");
			apply.setRealName("");
			apply.setBankName1("");
			apply.setBankName("");
			apply.setBankName1("");
			
			//添加提现订单
			commissionApplyManager.addEntity(apply);
			
			//改变订单项的状态
			
		}
	}



	public Page<ExchangeOrder> getCommissionOrderPage(String orderStatus, Long agentId, Integer pageNo, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
		map.put("agentId", 16180);
		if("NO_FINISHE".equals(orderStatus)){
			map.put("NO_FINISHE", orderStatus);
		}else if("FINISHE".equals(orderStatus)){
			map.put("FINISHE", orderStatus);
		}else{
			map.put("orderStatus", orderStatus);
		}
		return exchangeOrderManager.findPage(map, pageNo, pageSize);
		
	}



	public double getCommissionPrice(String orderStatus, Long agentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agentId", 16180);
		if("NO_FINISHE".equals(orderStatus)){
			map.put("NO_FINISHE", orderStatus);
		}else if("FINISHE".equals(orderStatus)){
			map.put("FINISHE", orderStatus);
		}else{
			map.put("orderStatus", orderStatus);
		}
		Object result = getSqlSession().selectOne("Commission.getCommissionPrice", map);
		if(result != null){
			return (double) result;
		}
		return 0;
	}
	
	
}
 