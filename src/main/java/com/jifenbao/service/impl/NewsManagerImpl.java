/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.News;
import com.jifenbao.service.NewsManager;
import com.otc.framework.common.DataTransferKey;
import com.otc.framework.enums.YesNot;
import com.otc.framework.model.Order;
import com.otc.framework.page.Page;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName      NewsManagerImpl
 * @Description
 * News
 * 业务管理类.
 * <p/>
 * 继承于BaseManager,不需任何代码即拥有默认的对News对象的CRUD函数.
 *
 * @author      liujing
 * @Date        2016-03-16 15:41:27
 * @version     1.0 
 *
 */

@Service(NewsManager.BEAN_NAME)
@Transactional
public class NewsManagerImpl extends MybatisServiceImpl<News, Long> implements NewsManager {

	@Override
	public void batUpdateDeleteYn(Long[] ids, String updateUser) {
		for(Long id:ids){
			News bean= this.getEntity(id);
			bean.setDeleteYn(YesNot.YES.getCode());
			bean.setUpdateTime(new Date());
			bean.setUpdateUser(updateUser);
            this.modifyEntity(bean);
		}
		
	}

	@Override
	public void updateDisabledYn(Long id, String oper, String updateUser) {
		News bean= this.getEntity(id);
		if(oper.equals("enabled")){
			bean.setDisabledYn(YesNot.NOT.getCode());
		}else{
			bean.setDisabledYn(YesNot.YES.getCode());
		}
		
		bean.setUpdateTime(new Date());
		bean.setUpdateUser(updateUser);
        this.modifyEntity(bean);
		
	}

	/*
	 * 获取首页显示新闻
	 * (non-Javadoc)
	 * @see com.jifenbao.service.NewsManager#getFrontNews()
	 */
	@Override
	public List<News> getFrontNews() {
		Map<String,Object> map  =  new HashMap<String,Object> ();
		map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
		map.put("type", "1");
		List<Order> orderby = new ArrayList<Order>();
        orderby.add(Order.asc("sort"));
        orderby.add(Order.desc("id"));
        Page<News> page = this.findPage(map, 1, 7);//只显示前7条
		return page.getPageData();//
	}

	/*
	 * 获取首页显示公告
	 * (non-Javadoc)
	 * @see com.jifenbao.service.NewsManager#getFrontNotice()
	 */
	@Override
	public List<News> getFrontNotice() {
		Map<String,Object> map  =  new HashMap<String,Object> ();
		map.put(DataTransferKey.DELETE_YN, YesNot.NOT.getCode());
		map.put(DataTransferKey.DISABLED_YN, YesNot.NOT.getCode());
		map.put("type", "2");
		List<Order> orderby = new ArrayList<Order>();
        orderby.add(Order.asc("sort"));
        orderby.add(Order.desc("id"));
        map.put(DataTransferKey.ORDERBY_NAME, orderby);
        Page<News> page = this.findPage(map, 1, 7);//只显示前7条
		return page.getPageData();
	}

	@Override
	public List<String> getDateByType(Map<String, Object> map) {
		return this.findAll(entityClass.getSimpleName()+".selectDateByType", map);
	}
    
    
}
