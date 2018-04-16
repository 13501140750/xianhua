/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.SmsCode;
import com.jifenbao.service.SmsCodeManager;

/**
 *
 * @ClassName      SmsCodeManagerImpl
 * @Description
 * SmsCode
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对SmsCode对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-04-15 10:13:23
 * @version     1.0 
 *
 */

@Service(SmsCodeManager.BEAN_NAME)
@Transactional
public class SmsCodeManagerImpl extends MybatisServiceImpl<SmsCode, Integer> implements SmsCodeManager {
    
    public void  addEntity (SmsCode smsCode){
    	SmsCode delCode = new SmsCode();
    	delCode.setSmsNum(smsCode.getSmsNum());
    	this.deleteEntity(delCode);
    	super.addEntity(smsCode);
    }
}
