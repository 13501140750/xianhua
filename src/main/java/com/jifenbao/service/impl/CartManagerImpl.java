/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.Cart;
import com.jifenbao.service.CartManager;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName      CartManagerImpl
 * @Description
 * Cart
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Cart对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-31 00:15:05
 * @version     1.0 
 *
 */

@Service(CartManager.BEAN_NAME)
@Transactional
public class CartManagerImpl extends MybatisServiceImpl<Cart, String> implements CartManager {
    
    
}
