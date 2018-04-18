/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
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

import com.jifenbao.common.constants.AdminConstants;
import com.jifenbao.common.constants.CreditLogActionType;
import com.jifenbao.model.CustomerCreditLog;
import com.jifenbao.model.CustomerInfo;
import com.jifenbao.model.SystemSetting;
import com.jifenbao.service.CustomerCreditLogManager;
import com.jifenbao.service.CustomerInfoManager;
import com.jifenbao.service.SystemSettingManager;
import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName      CustomerInfoManagerImpl
 * @Description
 * CustomerInfo
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CustomerInfo对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-10 22:46:25
 * @version     1.0 
 *
 */

@Service(CustomerInfoManager.BEAN_NAME)
@Transactional
public class CustomerInfoManagerImpl extends MybatisServiceImpl<CustomerInfo, Long> implements CustomerInfoManager {

	@Resource(name = SystemSettingManager.BEAN_NAME)
	private SystemSettingManager systemSettingManager;
	
	@Resource(name = CustomerCreditLogManager.BEAN_NAME)
	private CustomerCreditLogManager customerCreditLogManager;
	
	@Override
	public void bonusPoints(Long customerId) {
		if(customerId != null){
			Map<String, Object> map = new HashMap<String, Object>();
    		map.put(DataTransferKey.DISABLED_YN, "N");
    		map.put(DataTransferKey.DELETE_YN, "N");
    		map.put("systemKey", AdminConstants.BONUS_POINTS);
    		List<SystemSetting> list = systemSettingManager.findByMap(map);
    		if(list == null || list.size() == 0){
    			throw new BusinessException("未找到奖励积分配置信息,请联系管理员配置");
    		}
    		
    		//加积分
    		String systemValue = list.get(0).getSystemValue();
    		Integer value = Integer.valueOf(systemValue);
    		CustomerInfo customerInfo = this.getEntity(customerId);
    		customerInfo.setCredit1(value + customerInfo.getCredit1());
    		customerInfo.setUpdateTime(DateTimeUtil.now());
    		super.update(customerInfo);
    		
    		//创建积分交易记录
    		CustomerCreditLog creditLog = new CustomerCreditLog();
    		creditLog.setCreateTime(DateTimeUtil.now());
    		creditLog.setCustomerId(customerId);
    		creditLog.setSourceType("1");
    		creditLog.setCreditAmount(Double.valueOf(value));
    		creditLog.setBlanceAmout(Double.valueOf(customerInfo.getCredit1()));
    		creditLog.setDisabledYn(YesNot.NOT.getCode());
    		creditLog.setDeleteYn(YesNot.NOT.getCode());
    		creditLog.setCreateTime(DateTimeUtil.now());
    		creditLog.setActionType(CreditLogActionType.CUSTOMER_SHARE);
    		creditLog.setSource("fenxiang");
    		customerCreditLogManager.addEntity(creditLog);
    		
		}
		
	}
	
	
	
    
}
