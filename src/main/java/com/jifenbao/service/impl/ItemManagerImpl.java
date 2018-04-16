/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.Item;
import com.jifenbao.service.ItemManager;

/**
 *
 * @ClassName      ItemManagerImpl
 * @Description
 * Item
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Item对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-11-27 16:21:44
 * @version     1.0 
 *
 */

@Service(ItemManager.BEAN_NAME)
@Transactional
public class ItemManagerImpl extends MybatisServiceImpl<Item, Integer> implements ItemManager {
    
    
}
