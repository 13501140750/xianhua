/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.List;

import com.jifenbao.model.FreightCompany;
import com.otc.framework.service.BaseManager;

/**
 *
 * @ClassName      FreightCompanyManager
 * @Description
 * FreightCompany
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对FreightCompany对象的CRUD函数.
 *
 * @author      kevin.wang
 * @Date        2015-12-13 23:51:27
 * @version     1.0 
 *
 */

public interface FreightCompanyManager extends BaseManager<FreightCompany, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "freightCompanyManager";

    public List<FreightCompany>  findAllFreightCompany();
    
    public String getFreightNameByName(String freightCode);
}
