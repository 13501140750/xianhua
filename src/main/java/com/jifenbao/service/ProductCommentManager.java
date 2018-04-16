/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import com.otc.framework.service.BaseManager;

import java.util.List;

import com.jifenbao.model.ProductComment;

/**
 *
 * @ClassName      ProductCommentManager
 * @Description
 * ProductComment
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对ProductComment对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-01-06 17:18:38
 * @version     1.0 
 *
 */

public interface ProductCommentManager extends BaseManager<ProductComment, Long> {
    /**
     * Bean名称
     */
    String BEAN_NAME = "productCommentManager";
    
    /**
     * 根据公司编码和产品编码查询唯一描述对象
     * @param productCode
     * @param companyCode
     * @return
     */
    public  ProductComment findUniqueByprdCodeAndComCode(String productCode,String companyCode);
    
    /**
     * 批量保存
     */
    public void saveAll(List<ProductComment> list);


    /**
     * 删除公司下的所有产品备注
     * @param companyCode
     */
    public void deleteCommentByCompanyCode(String companyCode);
}
