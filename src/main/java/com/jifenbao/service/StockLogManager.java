/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.StockLog;

/**
 *
 * @ClassName StockLogManager
 * @Description StockLog 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对StockLog对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-23 17:09:20
 * @version 1.0
 *
 */

public interface StockLogManager extends BaseManager<StockLog, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "stockLogManager";

    /**
     * 更新库存<br />
     * type:<br />
     * 0 入库<br />
     * 1 出库
     * 
     * @param stockLog
     */
    public void modifySotckLog(StockLog stockLog);
}
