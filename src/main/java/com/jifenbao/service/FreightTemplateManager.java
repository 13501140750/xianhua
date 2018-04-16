/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.FreightTemplate;

/**
 *
 * @ClassName      FreightTemplateManager
 * @Description
 * FreightTemplate
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对FreightTemplate对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-05 12:01:59
 * @version     1.0 
 *
 */

public interface FreightTemplateManager extends BaseManager<FreightTemplate, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "freightTemplateManager";
    
    public void batchUpdateDeleteYn(Long[] ids,String updateUser);


}
