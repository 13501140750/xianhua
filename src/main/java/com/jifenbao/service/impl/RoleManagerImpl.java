/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.Role;
import com.jifenbao.model.wrapper.RoleWrapper;
import com.jifenbao.service.RoleManager;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName RoleManagerImpl
 * @Description Role 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对Role对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-21 17:16:22
 * @version 1.0
 *
 */

@Service(RoleManager.BEAN_NAME)
@Transactional
public class RoleManagerImpl extends MybatisServiceImpl<Role, String> implements RoleManager {

	public List<RoleWrapper> checkEnabledRoles(List<Role> allRoles, List<Role> userRoles) {
		List<RoleWrapper> results = new ArrayList<RoleWrapper>();
		for (Role role : allRoles) {
			RoleWrapper rw = new RoleWrapper(role);
			if (userRoles != null && userRoles.size() > 0 && userRoles.contains(role)) {
				rw.setEnabled(true);
			}
			results.add(rw);
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getByUsername(String username) {
		return super.findAll(entityClass.getSimpleName() + ".selectByUser", username);
	}

}
