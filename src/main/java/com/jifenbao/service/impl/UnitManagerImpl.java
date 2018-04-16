/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.Unit;
import com.jifenbao.service.UnitManager;

/**
 *
 * @ClassName      UnitManagerImpl
 * @Description
 * Unit
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Unit对象的CRUD函数.
 *
 * @author      kevin.wang
 * @Date        2015-12-15 08:20:27
 * @version     1.0 
 *
 */

@Service(UnitManager.BEAN_NAME)
@Transactional
public class UnitManagerImpl extends MybatisServiceImpl<Unit, Integer> implements UnitManager {
    
    
}
