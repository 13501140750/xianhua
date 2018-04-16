/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.User;

/**
 *
 * @ClassName UserManager
 * @Description User 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对User对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-14 22:56:37
 * @version 1.0
 *
 */

public interface UserManager extends BaseManager<User, String> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "userManager";

    /**
     * 加密
     * 
     * @param password
     * @return
     */
    String encodePassword(String password);

}
