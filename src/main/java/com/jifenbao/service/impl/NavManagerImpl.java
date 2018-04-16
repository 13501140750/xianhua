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

import com.jifenbao.model.Nav;
import com.jifenbao.service.NavManager;

/**
 *
 * @ClassName      NavManagerImpl
 * @Description
 * Nav
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Nav对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2018-01-18 11:59:04
 * @version     1.0 
 *
 */

@Service(NavManager.BEAN_NAME)
@Transactional
public class NavManagerImpl extends MybatisServiceImpl<Nav, Integer> implements NavManager {
    
    
	
	
	@Override
	public void batchDelete(Integer[] ids, String operUser) {
		for(Integer id:ids){
			Nav bean  = this.findUniqueByProperty("id", id);
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
			Nav bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}
}
