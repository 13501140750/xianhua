/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.LoginInfo;
import com.jifenbao.model.helper.TaobaoMessage;

/**
 *
 * @ClassName      LoginInfoManager
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

public interface LoginInfoManager extends BaseManager<LoginInfo, String> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "loginInfoManager";

    /**
     * 通过连个主键查询登录账户信息
     * @param loginName
     * @param companyCode
     * @return
     */
    public LoginInfo getLoginInfo(String loginName,String companyCode);
}
