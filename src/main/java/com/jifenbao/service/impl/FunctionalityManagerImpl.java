/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.Functionality;
import com.jifenbao.service.FunctionalityManager;

/**
 *
 * @ClassName      FunctionalityManagerImpl
 * @Description
 * Functionality
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Functionality对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-18 18:11:27
 * @version     1.0 
 *
 */

@Service(FunctionalityManager.BEAN_NAME)
@Transactional
public class FunctionalityManagerImpl extends MybatisServiceImpl<Functionality, Integer> implements FunctionalityManager {
    
    
}
