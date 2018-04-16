/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;
import java.util.Map;

import com.jifenbao.model.CompanyCustomizine;

/**
 *
 * @ClassName      CompanyCustomizineManager
 * @Description
 * CompanyCustomizine
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对CompanyCustomizine对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-04-20 16:44:53
 * @version     1.0 
 *
 */

public interface CompanyCustomizineManager extends BaseManager<CompanyCustomizine, Integer> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "companyCustomizineManager";
    
    /**
     * 校验公司是否存在
     * @param bean
     * @return
     */
    public boolean validateCompanyCode(CompanyCustomizine bean);

    /**
     * 保存公司定制，并根据定制调整产品价格
     * @param custom
     */
    public void addCompanyCustomizine(CompanyCustomizine bean);
    /**
     * 修改公司定制，并根据定制调整产品价格
     * @param custom
     */
    public void modifyCustomizine(CompanyCustomizine bean);
    
    /**
     * 删除公司定制
     * @param bean
     */
    public void deleteCustomizine(CompanyCustomizine bean);
    
    /**
     * 查找公司的定制信息
     * @param companyCode
     * @return
     */
    public CompanyCustomizine getByCompanyCode(String companyCode);
    
    /**
     * 获取积分公司定制的积分兑换比例
     * @param companyCode
     * @return
     */
    public Double getCompayJiFeRate(String companyCode);
    
   

}
