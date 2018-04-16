/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */

package com.jifenbao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.CommissionClickcount;
import com.jifenbao.model.CustomerInfo;
import com.jifenbao.service.CommissionClickcountManager;
import com.jifenbao.service.CustomerInfoManager;
import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

/**
 *
 * @ClassName      CommissionClickcountManagerImpl
 * @Description
 * CommissionClickcount
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CommissionClickcount对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-22 15:41:31
 * @version     1.0 
 *
 */

@Service(CommissionClickcountManager.BEAN_NAME)
@Transactional
public class CommissionClickcountManagerImpl extends MybatisServiceImpl<CommissionClickcount, Long> implements CommissionClickcountManager {
    
	@Resource(name = CustomerInfoManager.BEAN_NAME)
	private CustomerInfoManager customerInfoManager;
    
	@Override
	public void addEntity(CommissionClickcount entity) {
		boolean exists = this.isExists(entity);
		
		if(!exists){
			super.addEntity(entity);
			
			//将用户的点击点击次数+1
			CustomerInfo customer = customerInfoManager.getEntity(entity.getCid());
			if(customer != null){
				customer.setClickCount((customer.getClickCount()==null?0:customer.getClickCount()) + 1);
				customerInfoManager.modifyEntity(customer);
			}
		}
	}
	
	@Override
	public void batchDelete(Long[] ids, String operUser) {
		for(Long id:ids){
			CommissionClickcount bean  = this.findUniqueByProperty("id", id);
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
			CommissionClickcount bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}
}
