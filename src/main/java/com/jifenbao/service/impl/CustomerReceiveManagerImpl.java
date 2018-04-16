/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.CustomerReceive;
import com.jifenbao.service.CustomerReceiveManager;

/**
 *
 * @ClassName      CustomerReceiveManagerImpl
 * @Description
 * CustomerReceive
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CustomerReceive对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-02-03 10:57:03
 * @version     1.0 
 *
 */

@Service(CustomerReceiveManager.BEAN_NAME)
@Transactional
public class CustomerReceiveManagerImpl extends MybatisServiceImpl<CustomerReceive, Long> implements CustomerReceiveManager {
    
    
}
