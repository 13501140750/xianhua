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
import com.jifenbao.model.UserRole;
import com.jifenbao.model.UserRoleId;
import com.jifenbao.service.UserRoleManager;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName UserRoleManagerImpl
 * @Description UserRole 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对UserRole对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-25 18:11:04
 * @version 1.0
 *
 */

@Service(UserRoleManager.BEAN_NAME)
@Transactional
public class UserRoleManagerImpl extends MybatisServiceImpl<UserRole, UserRoleId> implements UserRoleManager {

    @Override
    public void modifyUserRoles(String userName, List<Role> list) {
        // 删除原来的关系
        UserRoleId uri = new UserRoleId();
        uri.setUserName(userName);
        UserRole removeCondition = new UserRole();
        removeCondition.setId(uri);
        // 创建新的关系
        List<UserRole> urs = new ArrayList<UserRole>();
        for (Role role : list) {
            urs.add(new UserRole(new UserRoleId(userName, role.getCode())));
        }
        this.deleteEntity(removeCondition);
        this.batchInsert(urs, entityClass.getSimpleName() + ".insertBatch");
    }

}
