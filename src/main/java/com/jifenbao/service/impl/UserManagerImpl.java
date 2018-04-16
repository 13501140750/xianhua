/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.User;
import com.jifenbao.service.UserManager;

/**
 *
 * @ClassName      UserManagerImpl
 * @Description
 * User
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对User对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-14 22:56:37
 * @version     1.0 
 *
 */

@Service(UserManager.BEAN_NAME)
@Transactional
public class UserManagerImpl extends MybatisServiceImpl<User, String> implements UserManager {

    @Override
    public String encodePassword(String password) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        encoder.setEncodeHashAsBase64(true);
        return encoder.encodePassword(password, null);
    }
    
    
}
