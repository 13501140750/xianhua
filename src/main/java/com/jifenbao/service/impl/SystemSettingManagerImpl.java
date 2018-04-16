/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;
import com.otc.framework.utils.DateTimeUtil;
import com.jifenbao.common.Constant;
import com.jifenbao.model.SystemSetting;
import com.jifenbao.service.SystemSettingManager;

/**
 *
 * @ClassName      SystemSettingManagerImpl
 * @Description
 * SystemSetting
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对SystemSetting对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-07 13:27:35
 * @version     1.0 
 *
 */

@Service(SystemSettingManager.BEAN_NAME)
@Transactional
public class SystemSettingManagerImpl extends MybatisServiceImpl<SystemSetting, Long> implements SystemSettingManager {

	@Override
	public void batchSave(List<SystemSetting> list) {
	    Date now = new Date();
	    for(SystemSetting setting:list){
	    	setting.setUpdateTime(now);
	    	setting.setUpdateUser("adminUser");
	    	if(StringUtils.isNotBlank(setting.getSystemKey()) && StringUtils.isNotBlank(setting.getSystemValue())){
	    		 if(setting.getId()!=null){
	  	    	   SystemSetting oldSetting = this.getEntity(setting.getId()) ;
	  	    	   if(oldSetting==null){
	  	    		   logger.info("系统设置中该条记录不存在"+oldSetting.getId());
	  	    	   }else{
	  	    		   this.modifyEntity(setting); 
	  	    	   }
	  	       }else{
	  	    	   
	  	    	   setting.setDeleteYn(Constant.YESNOT_N);
	  	    	   setting.setDisabledYn(Constant.YESNOT_N);
	  	    	   setting.setCreateTime(now);
	  	    	   setting.setCreateUser("adminUser");
	  	    	   this.addEntity(setting);
	  	       }
	    	}
	    	
	      
	    }
		
		
	}

	@Override
	public Double getJifenRate() {
		try{
			SystemSetting setting = this.findUniqueByProperty("systemKey", "EXCHANGE_RATE");
			if(setting!=null && StringUtils.isNotBlank(setting.getSystemValue())){
				return Double.parseDouble(setting.getSystemValue());
			}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return null;
	}
    
    
}
