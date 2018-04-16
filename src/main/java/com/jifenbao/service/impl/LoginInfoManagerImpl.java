/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.LoginInfo;
import com.jifenbao.service.LoginInfoManager;

/**
 *
 * @ClassName      LoginInfoManagerImpl
 * @Description
 * LoginInfo
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对LoginInfo对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-10 22:09:28
 * @version     1.0 
 *
 */

@Service(LoginInfoManager.BEAN_NAME)
@Transactional
public class LoginInfoManagerImpl extends MybatisServiceImpl<LoginInfo, String> implements LoginInfoManager {

	@Override
	public LoginInfo getLoginInfo(String loginName, String companyCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("loginName", loginName);
		map.put("companyCode", companyCode);
		return (LoginInfo)this.findUniqueBy(entityClass.getSimpleName()+".getLoginInfo", map);
	}
    
    
}
