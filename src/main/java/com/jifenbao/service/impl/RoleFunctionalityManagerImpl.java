/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.RoleFunctionality;
import com.jifenbao.model.RoleFunctionalityId;
import com.jifenbao.service.RoleFunctionalityManager;

/**
 *
 * @ClassName      RoleFunctionalityManagerImpl
 * @Description
 * RoleFunctionality
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对RoleFunctionality对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-23 20:04:04
 * @version     1.0 
 *
 */

@Service(RoleFunctionalityManager.BEAN_NAME)
@Transactional
public class RoleFunctionalityManagerImpl extends MybatisServiceImpl<RoleFunctionality, RoleFunctionalityId> implements RoleFunctionalityManager {
    
    
}
