/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otc.framework.service.impl.MybatisServiceImpl;

import com.jifenbao.model.StockLogDetail;
import com.jifenbao.model.StockLogDetailId;
import com.jifenbao.service.StockLogDetailManager;

/**
 *
 * @ClassName      StockLogDetailManagerImpl
 * @Description
 * StockLogDetail
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对StockLogDetail对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2015-12-23 17:24:21
 * @version     1.0 
 *
 */

@Service(StockLogDetailManager.BEAN_NAME)
@Transactional
public class StockLogDetailManagerImpl extends MybatisServiceImpl<StockLogDetail, StockLogDetailId> implements StockLogDetailManager {
    
    
}
