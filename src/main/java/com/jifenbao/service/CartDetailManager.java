/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.model.CartDetail;

/**
 *
 * @ClassName      CartDetailManager
 * @Description
 * CartDetail
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CartDetail对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-31 00:54:11
 * @version     1.0 
 *
 */

public interface CartDetailManager extends BaseManager<CartDetail, String> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "cartDetailManager";

	List<CartDetail> findByIds(String[] cartDetailIds);

	void deleteByArrPK(String[] split);



}
