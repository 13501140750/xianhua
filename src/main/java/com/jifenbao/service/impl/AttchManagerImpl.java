/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.Attch;
import com.jifenbao.service.AttchManager;

/**
 *
 * @ClassName      AttchManagerImpl
 * @Description
 * Attch
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Attch对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-06-14 19:37:56
 * @version     1.0 
 *
 */

@Service(AttchManager.BEAN_NAME)
@Transactional
public class AttchManagerImpl extends MybatisServiceImpl<Attch, Integer> implements AttchManager {
    
    
}
