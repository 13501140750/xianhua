/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;
import com.jifenbao.model.Company;

/**
 *
 * @ClassName      CompanyManager
 * @Description
 * Company
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对Company对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-08 15:59:49
 * @version     1.0 
 *
 */

public interface CompanyManager extends BaseManager<Company, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "companyManager";

    /**
     * 自动生成的code
     * @return
     */
    public String genCode();
    
    /**
     * 根据ID批量删除公司
     * @param ids
     */
    public void batUpdateDeleteYn(Long[] ids,String updateUser);
    
    /**
     * 根据ID批量解除合作公司
     * @param ids
     */
    public void batUpdateDisabledYn(Long[] ids,String disabled,String updateUser);
    
    /**
     * 校验公司名称以及营业执照号是否重复
     * @param bean
     * @return
     */
    public boolean  vaildateCompany(Company bean);
    
    /**
     * 通过卡号查找对应的公司信息
     * @param cardno
     * @return
     */
    public Company getCompanyByCardno(String cardno);
    
    /**
     * 通过会员name查找对应的公司信息
     * @param cardno
     * @return
     */
    public Company getCompanyByCustomName(String customerName);
    
    /**
     * 新增供应商，根据供应商供货类型新增供货关系，以及仓库信息
     * @param bean
     */
    public void addCompantAndRrelationship(Company bean);
    
    /**
     * 修改供应商，根据供应商供货类型新增供货关系，以及仓库信息
     * @param bean
     */
    public void updateCompantAndRrelationship(Company bean);
}
