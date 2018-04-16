/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.model.SystemSetting;

/**
 *
 * @ClassName      SystemSettingManager
 * @Description
 * SystemSetting
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对SystemSetting对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-07 13:27:35
 * @version     1.0 
 *
 */

public interface SystemSettingManager extends BaseManager<SystemSetting, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "systemSettingManager";

    
    public void batchSave(List<SystemSetting> list);
    
    /**
     * 获取系统默认价格与积分的兑换比例
     * @return
     */
    public Double getJifenRate();

}
