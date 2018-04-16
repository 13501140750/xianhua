/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.model.Order;
import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.Banner;
import com.jifenbao.model.Brand;
import com.jifenbao.model.CompanyBanner;
import com.jifenbao.service.BannerManager;
import com.jifenbao.service.CompanyBannerManager;

/**
 *
 * @ClassName      BannerManagerImpl
 * @Description
 * Banner
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Banner对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-16 13:01:59
 * @version     1.0 
 *
 */

@Service(CompanyBannerManager.BEAN_NAME)
@Transactional
public class CompanyBannerManagerImpl extends MybatisServiceImpl<CompanyBanner, Integer> implements CompanyBannerManager {

	@Override
	public void batUpdateDeleteYn(Integer[] ids, String updateUser) {
		for(Integer id:ids){
			CompanyBanner bean= this.getEntity(id);
			bean.setDeleteYn(YesNot.YES.getCode());
			bean.setUpdateTime(new Date());
			bean.setUpdateUser(updateUser);
            this.modifyEntity(bean);
		}
	}

	/*
	 * 
	 * (non-Javadoc)
	 * @see com.jifenbao.service.BannerManager#updateDisabledYn(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateDisabledYn(Integer id, String oper, String updateUser) {
		CompanyBanner bean= this.getEntity(id);
		if(oper.equals("enabled")){
			bean.setDisabledYn(YesNot.NOT.getCode());
		}else{
			bean.setDisabledYn(YesNot.YES.getCode());
		}
		bean.setUpdateTime(new Date());
		bean.setUpdateUser(updateUser);
        this.modifyEntity(bean);
		
	}

	
    
    
}
