/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service;

import java.util.List;

import com.jifenbao.model.Menu;
import com.jifenbao.model.wrapper.MenuWrapper;
import com.otc.framework.service.BaseManager;

/**
 *
 * @ClassName MenuManager
 * @Description Menu 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对Menu对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-15 23:51:47
 * @version 1.0
 *
 */

public interface MenuManager extends BaseManager<Menu, Integer> {
	/**
	 * Bean名称
	 */
	String BEAN_NAME = "menuManager";

	/**
	 * 取树形结构的list
	 * 
	 * @param code
	 * @return
	 */
	public List<Menu> getTree(int code);

	/**
	 * 取树形结构的list
	 * 
	 * @param code
	 * @param username
	 * @return
	 */
	public List<Menu> getTree(int code, String username);

	/**
	 * 将树形结构list加上树形属性
	 * 
	 * @param list
	 * @return
	 */
	public List<MenuWrapper> addTreeProperties(List<Menu> list);

	/**
	 * wrappers 中是否存在menus中的元素
	 * 
	 * @param wrappers
	 * @param menus
	 * @return
	 */
	public List<MenuWrapper> checkSelected(List<MenuWrapper> wrappers, List<Menu> menus);
}
