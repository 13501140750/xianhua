package com.jifenbao.model.wrapper;

import java.io.Serializable;

import com.jifenbao.model.Menu;

public class MenuWrapper implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2519380443738655309L;

    /**
     * 当前对象id
     */
    private String ttId;

    /**
     * 父对象id
     */
    private String ttParentId;
    
    /**
     * 选中标识
     */
    private boolean selected;
    
    private Menu menu;

    public String getTtId() {
        return ttId;
    }

    public void setTtId(String ttId) {
        this.ttId = ttId;
    }

    public String getTtParentId() {
        return ttParentId;
    }

    public void setTtParentId(String ttParentId) {
        this.ttParentId = ttParentId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
