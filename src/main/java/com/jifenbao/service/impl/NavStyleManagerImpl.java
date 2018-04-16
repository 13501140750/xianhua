/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.NavStyle;
import com.jifenbao.service.NavStyleManager;
import com.otc.framework.enums.YesNot;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName      NavStyleManagerImpl
 * @Description
 * NavStyle
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对NavStyle对象的CRUD函数.
 *
 * @author      jing68.liu
 * @Date        2016-10-24 14:30:51
 * @version     1.0 
 *
 */

@Service(NavStyleManager.BEAN_NAME)
@Transactional
public class NavStyleManagerImpl extends MybatisServiceImpl<NavStyle, Integer> implements NavStyleManager {
    
	@Override
    public void batUpdateDeleteYn(Integer[] ids, String updateUser) {
        if (ids != null) {
            for (Integer id : ids) {
            	NavStyle bean = this.getEntity(id);
            	bean.setDeleteYn(YesNot.YES.getCode());
            	bean.setUpdateTime(new Date());
            	bean.setUpdateUser(updateUser);
                this.modifyEntity(bean);
            }
        }

    }

    @Override
    public void updateDisabledYn(Integer id, String oper, String updateUser) {
    	NavStyle bean = this.getEntity(id);
        if (oper.equals("enabled")) {
            bean.setDisabledYn(YesNot.NOT.getCode());
        } else {
            bean.setDisabledYn(YesNot.YES.getCode());
        }

        bean.setUpdateTime(new Date());
        bean.setUpdateUser(updateUser);
        this.modifyEntity(bean);
    }

	@Override
	public List<NavStyle> getNavStyleList() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("disabledYn", YesNot.NOT.getCode());
		map.put("deleteYn", YesNot.NOT.getCode());
		return this.findByMap(map);
	}
    
}
