/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.List;

import com.jifenbao.model.Role;
import com.jifenbao.model.UserRole;
import com.jifenbao.model.UserRoleId;
import com.otc.framework.service.BaseManager;

/**
 *
 * @ClassName      UserRoleManager
 * @Description
 * UserRole
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对UserRole对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-25 18:11:04
 * @version     1.0 
 *
 */

public interface UserRoleManager extends BaseManager<UserRole, UserRoleId> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "userRoleManager";


    public void modifyUserRoles(String userName, List<Role> list);
}
