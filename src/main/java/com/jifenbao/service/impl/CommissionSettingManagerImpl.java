/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */

package com.jifenbao.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

import com.jifenbao.model.CommissionSetting;
import com.jifenbao.service.CommissionSettingManager;

/**
 *
 * @ClassName      CommissionSettingManagerImpl
 * @Description
 * CommissionSetting
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CommissionSetting对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-11 09:54:41
 * @version     1.0 
 *
 */

@Service(CommissionSettingManager.BEAN_NAME)
@Transactional
public class CommissionSettingManagerImpl extends MybatisServiceImpl<CommissionSetting, Integer> implements CommissionSettingManager {
    
    
	
	
	@Override
	public void batchDelete(Integer[] ids, String operUser) {
		for(Integer id:ids){
			CommissionSetting bean  = this.findUniqueByProperty("id", id);
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
			CommissionSetting bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}

	@Override
	public CommissionSetting getConfig() {
		List<CommissionSetting> findAll = this.findAll();
		if(findAll == null || findAll.size() == 0){
			throw new BusinessException("分销配置信息不存在");
		}else if(findAll.size() > 1){
			throw new BusinessException("分销配置信息大于1条");
		}else{
			return findAll.get(0);
		}
	}
	
	
	
}
