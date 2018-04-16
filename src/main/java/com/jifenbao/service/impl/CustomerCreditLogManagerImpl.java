/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */

package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

import com.jifenbao.model.CustomerCreditLog;
import com.jifenbao.service.CustomerCreditLogManager;

/**
 *
 * @ClassName      CustomerCreditLogManagerImpl
 * @Description
 * CustomerCreditLog
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CustomerCreditLog对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-02-08 16:52:43
 * @version     1.0 
 *
 */

@Service(CustomerCreditLogManager.BEAN_NAME)
@Transactional
public class CustomerCreditLogManagerImpl extends MybatisServiceImpl<CustomerCreditLog, Long> implements CustomerCreditLogManager {
    
    
	
	
	@Override
	public void batchDelete(Long[] ids, String operUser) {
		for(Long id:ids){
			CustomerCreditLog bean  = this.findUniqueByProperty("id", id);
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
			CustomerCreditLog bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}
}
