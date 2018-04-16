/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;
import com.jifenbao.model.FreightTemplate;
import com.jifenbao.service.FreightTemplateManager;

/**
 *
 * @ClassName      FreightTemplateManagerImpl
 * @Description
 * FreightTemplate
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对FreightTemplate对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-05 12:01:59
 * @version     1.0 
 *
 */

@Service(FreightTemplateManager.BEAN_NAME)
@Transactional
public class FreightTemplateManagerImpl extends MybatisServiceImpl<FreightTemplate, Long> implements FreightTemplateManager {

	@Override
	public void batchUpdateDeleteYn(Long[] ids, String updateUser) {
		for(Long id:ids){
			FreightTemplate bean = this.getEntity(id);
			bean.setDeleteYn(YesNot.YES.getCode());
			bean.setUpdateTime(DateTimeUtil.now());
			bean.setUpdateUser(updateUser);
            this.modifyEntity(bean);
		}
		
	}
    
    
}
