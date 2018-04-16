/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.Item;

/**
 *
 * @ClassName      ItemManager
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

public interface ItemManager extends BaseManager<Item, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "itemManager";


}
