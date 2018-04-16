/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.List;

import com.jifenbao.model.Role;
import com.jifenbao.model.wrapper.RoleWrapper;
import com.otc.framework.service.BaseManager;

/**
 *
 * @ClassName RoleManager
 * @Description Role 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对Role对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-21 17:16:22
 * @version 1.0
 *
 */

public interface RoleManager extends BaseManager<Role, String> {
	/**
	 * Bean名称
	 */
	String BEAN_NAME = "roleManager";

	public List<RoleWrapper> checkEnabledRoles(List<Role> allRoles, List<Role> userRoles);

	/**
	 * 通过用户名取角色
	 * 
	 * @param username
	 * @return
	 */
	public List<Role> getByUsername(String username);

}
