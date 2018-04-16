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

import com.jifenbao.model.CommissionLevel;
import com.jifenbao.service.CommissionLevelManager;

/**
 *
 * @ClassName      CommissionLevelManagerImpl
 * @Description
 * CommissionLevel
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CommissionLevel对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-11 16:45:04
 * @version     1.0 
 *
 */

@Service(CommissionLevelManager.BEAN_NAME)
@Transactional
public class CommissionLevelManagerImpl extends MybatisServiceImpl<CommissionLevel, Integer> implements CommissionLevelManager {
    
    
	
	@Override
	public void batchDelete(Integer[] ids, String operUser) {
		for(Integer id:ids){
			CommissionLevel bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDeleteYn(YesNot.YES.getCode());
  			this.modifyEntity(bean);
			}
		}
		
	}
	
	@Override
	public void batchDisabled(Integer[] ids, String operUser, String oper) {
		for(Integer id:ids){
			CommissionLevel bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}
}
