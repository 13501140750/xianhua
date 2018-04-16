/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.CustomerInfo;
import com.jifenbao.service.CustomerInfoManager;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName      CustomerInfoManagerImpl
 * @Description
 * CustomerInfo
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CustomerInfo对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-10 22:46:25
 * @version     1.0 
 *
 */

@Service(CustomerInfoManager.BEAN_NAME)
@Transactional
public class CustomerInfoManagerImpl extends MybatisServiceImpl<CustomerInfo, Long> implements CustomerInfoManager {
	
	
	
    
}
