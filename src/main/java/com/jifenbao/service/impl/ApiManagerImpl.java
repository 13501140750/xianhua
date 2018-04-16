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

import com.jifenbao.model.Api;
import com.jifenbao.service.ApiManager;

/**
 *
 * @ClassName      ApiManagerImpl
 * @Description
 * Api
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Api对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-16 15:06:29
 * @version     1.0 
 *
 */

@Service(ApiManager.BEAN_NAME)
@Transactional
public class ApiManagerImpl extends MybatisServiceImpl<Api, Long> implements ApiManager {
    
    
	
	
	@Override
	public void batchDelete(Long[] ids, String operUser) {
		for(Long id:ids){
			Api bean  = this.findUniqueByProperty("id", id);
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
			Api bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}
}
