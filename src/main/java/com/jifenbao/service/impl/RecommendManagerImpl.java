/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */

package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.tools.util.DateTimeUtil;

import com.jifenbao.model.Recommend;
import com.jifenbao.service.RecommendManager;

/**
 *
 * @ClassName      RecommendManagerImpl
 * @Description
 * Recommend
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Recommend对象的CRUD函数.
 *
 * @author      wangyawei
 * @Date        2017-12-26 16:31:36
 * @version     1.0 
 *
 */

@Service(RecommendManager.BEAN_NAME)
@Transactional
public class RecommendManagerImpl extends MybatisServiceImpl<Recommend, Integer> implements RecommendManager {
    
    
	
	
	@Override
	public void batchDelete(Integer[] ids, String operUser) {
		for(Integer id:ids){
			Recommend bean  = this.findUniqueByProperty("id", id);
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
			Recommend bean  = this.findUniqueByProperty("id", id);
			if(bean!=null){
				bean.setUpdateUser(operUser);
				bean.setUpdateTime(DateTimeUtil.now());
				bean.setDisabledYn(oper);
  			this.modifyEntity(bean);
			}
		}
		
	}
}
