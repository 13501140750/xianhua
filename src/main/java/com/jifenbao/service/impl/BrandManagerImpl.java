/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.Brand;
import com.jifenbao.service.BrandManager;
import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.exception.BusinessException;
import com.otc.framework.model.Order;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName BrandManagerImpl
 * @Description Brand 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对Brand对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-09 10:44:48
 * @version 1.0
 *
 */

@Service(BrandManager.BEAN_NAME)
@Transactional
public class BrandManagerImpl extends MybatisServiceImpl<Brand, Long> implements BrandManager {

    /**
     * 在未删除的品牌记录中不能有重复的名称出现
     * 
     * @param entity
     */
    private void checkDuplicate(Brand entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", entity.getName());
        params.put("deleteYn", "0");
        List<Brand> list = this.findByMap(params);
        if (list != null && list.size() > 0) {
            for (Brand b : list) {
                if (!b.getId().equals(entity.getId())) {
                    throw new BusinessException("name already exists");
                }
            }
        }
    }

    @Override
    public void addEntity(Brand entity) {
        checkDuplicate(entity);
        super.addEntity(entity);
    }

    @Override
    public void modifyEntity(Brand entity) {
        checkDuplicate(entity);
        super.modifyEntity(entity);
    }

    @Override
    public String genCode() {
        String code = (String) this.findUniqueBy(entityClass.getSimpleName() + ".getMaxCatCode");
        if (StringUtils.isBlank(code))
            code = "0";
        int num = Integer.parseInt(code);
        num++;
        DecimalFormat df = new DecimalFormat("000000");
        String str2 = df.format(num);
        return str2;
    }

    @Override
    public void batUpdateDeleteYn(Long[] ids, String updateUser) {
        if (ids != null) {
            for (long id : ids) {
                Brand brand = this.getEntity(id);
                brand.setDeleteYn(YesNot.YES.getCode());
                brand.setUpdateTime(new Date());
                brand.setUpdateUser(updateUser);
                this.modifyEntity(brand);
            }
        }

    }

    @Override
    public void updateDisabledYn(Long id, String oper, String updateUser) {
        Brand bean = this.getEntity(id);
        if (oper.equals("enabled")) {
            bean.setDisabledYn(YesNot.NOT.getCode());
        } else {
            bean.setDisabledYn(YesNot.YES.getCode());
        }

        bean.setUpdateTime(new Date());
        bean.setUpdateUser(updateUser);
        this.modifyEntity(bean);
    }

    /*
     * 获取首页显示热门品牌 (non-Javadoc)
     * 
     * @see com.jifenbao.service.BrandManager#getFrontHotBrand()
     */
    @Override
    public List<Brand> getFrontHotBrand() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
        map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
        // map.put("showYn", "Y");
        map.put("hotYn", "Y");
        List<Order> orderby = new ArrayList<Order>();
        orderby.add(Order.asc("sort"));
        orderby.add(Order.desc("id"));
        map.put(DataTransferKey.ORDERBY_NAME, orderby);
        return this.findByMap(map);
    }

    @Override
    public List<Brand> getFrontBrand() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
        map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
        map.put("showYn", "Y");
        List<Order> orderby = new ArrayList<Order>();
        orderby.add(Order.asc("sort"));
        orderby.add(Order.desc("id"));
        map.put(DataTransferKey.ORDERBY_NAME, orderby);
        return this.findByMap(map);
    }
    public List<Brand> queyryByLimt(Map map){
    	return this.findAll(entityClass.getSimpleName() + ".pageQuery", 1, 8, map);
    }
}
