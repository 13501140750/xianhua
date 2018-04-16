/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.LoggerInfo;
import com.jifenbao.model.helper.TaobaoMessage;

/**
 *
 * @ClassName      LoggerInfoManager
 * @Description
 * LoggerInfo
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对LoggerInfo对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-05-23 10:03:05
 * @version     1.0 
 *
 */

public interface LoggerInfoManager extends BaseManager<LoggerInfo, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "loggerInfoManager";

    public TaobaoMessage sendMsg(TaobaoMessage message);
}
