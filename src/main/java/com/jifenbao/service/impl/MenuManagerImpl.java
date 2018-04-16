/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jifenbao.model.Functionality;
import com.jifenbao.model.Menu;
import com.jifenbao.model.wrapper.MenuWrapper;
import com.jifenbao.service.MenuManager;
import com.otc.framework.service.impl.MybatisServiceImpl;

/**
 *
 * @ClassName MenuManagerImpl
 * @Description Menu 业务管理类.
 *              <p/>
 *              继承于BaseManager,不需任何代码即拥有默认的对Menu对象的CRUD函数.
 *
 * @author liujing
 * @Date 2015-12-15 23:51:47
 * @version 1.0
 *
 */

@Service(MenuManager.BEAN_NAME)
@Transactional
public class MenuManagerImpl extends MybatisServiceImpl<Menu, Integer> implements MenuManager {

	public static final Logger LOG = Logger.getLogger(MenuManagerImpl.class);

	@SuppressWarnings("unchecked")
    @Override
	public List<Menu> getTree(int code) {
	    return this.findAll(entityClass.getSimpleName() + ".getTree", code);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getTree(int code, String username) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", code);
		params.put("username", username);
		return this.findAll(entityClass.getSimpleName() + ".getTree4User", params);
	}

	@Override
	public List<MenuWrapper> addTreeProperties(List<Menu> list) {
		List<MenuWrapper> results = new ArrayList<MenuWrapper>();
		addProperties(results, list, "");
		return results;
	}

	@Override
	public List<MenuWrapper> checkSelected(List<MenuWrapper> wrappers, List<Menu> menus) {
		if (wrappers == null || menus == null)
			return null;
		for (MenuWrapper w : wrappers) {
			for (Menu m : menus) {
				if (m.getId().equals(w.getMenu().getId())) {
					w.setSelected(true);
					// 检查functionality
					try {
						List<Functionality> fList = w.getMenu().getFunctionalities();
						for (Functionality fw : fList) {
							for (Functionality f : m.getFunctionalities()) {
								if (fw.getId().equals(f.getId())) {
									fw.setSelected(true);
								}
							}
						}
						w.getMenu().setFunctionalities(fList);
					} catch (Exception e) {
						LOG.warn(e.getMessage(), e);
					}
				}

			}
		}
		return wrappers;

	}

	private void addProperties(List<MenuWrapper> list, List<Menu> menus, String parentId) {
		for (Menu menu : menus) {
			MenuWrapper mw = new MenuWrapper();
			mw.setTtParentId(parentId);
			mw.setTtId(parentId + "-" + menu.getId());
			mw.setMenu(menu);
			list.add(mw);
			if (menu.getChildren() != null && menu.getChildren().size() > 0) {
				addProperties(list, menu.getChildren(), mw.getTtId());
			}
		}
	}

}
