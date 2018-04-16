/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.RoleMenu;
import com.jifenbao.model.RoleMenuId;
import com.jifenbao.service.RoleMenuManager;

/**
 *
 * @ClassName      RoleMenuManagerImpl
 * @Description
 * RoleMenu
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对RoleMenu对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-27 22:04:02
 * @version     1.0 
 *
 */

@Service(RoleMenuManager.BEAN_NAME)
@Transactional
public class RoleMenuManagerImpl extends MybatisServiceImpl<RoleMenu, RoleMenuId> implements RoleMenuManager {
    
    
}
