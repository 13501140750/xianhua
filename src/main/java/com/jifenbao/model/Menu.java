/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;
import java.util.List;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName Menu
 * @Description Menu
 *
 * @author liujing
 * @Date 2015-12-15 23:51:47
 * @version 1.0
 *
 */
public class Menu extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    public static final String FUNCTIONS_STRING = "[{\"code\":\"add\",\"name\":\"新增\",\"operation\":\"(add|save)\"},{\"code\":\"update\",\"name\":\"修改\",\"operation\":\"(//d*/update|//d*/edit)\"},{\"code\":\"del\",\"name\":\"删除\",\"operation\":\"(//d*/del|delBatch)\"},{\"code\":\"view\",\"name\":\"详情\",\"operation\":\"(//d*/view)\"}]";

    // columns START
    /**
     * 主键 db_column: id
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 模块名称 db_column: name
     */
    private String name;
    /**
     * 模块类型 db_column: type
     */
    private String type;
    /**
     * 模块 db_column: model
     */
    private String model;
    /**
     * 操作 db_column: action
     */
    private String action;
    /**
     * 排序 db_column: sort
     */
    private Integer sort;
    /**
     * 父节点 db_column: parent
     */
    private Integer parent;

    /*
     * 功能 db_column: functions
     */
    private String functions;

    /**
     * 删除标识 db_column: deleteYn
     */
    private String deleteYn;
    /**
     * 是否启用 db_column: disabledYn
     */
    private String disabledYn;
    /**
     * 创建用户 db_column: createUser
     */
    private String createUser;
    /**
     * 创建时间 db_column: createTime
     */
    private Date createTime;
    /**
     * 修改用户 db_column: updateUser
     */
    private String updateUser;
    /**
     * 修改时间 db_column: updateTime
     */
    private Date updateTime;

    /**
     * 子目录
     */
    private List<Menu> children;
    /**
     * 权限
     */
    private List<Functionality> functionalities;
    /**
     * 删除的权限id
     */
    private Integer[] removedFunctionalityIds;
    /**
     * 是否可见 db_column: visibility
     */
    private Integer visibility;
    // columns END

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    public Menu(Integer id, String name, String type, String model, String action, Integer sort, Integer visibility, Integer parent,
            String deleteYn, String disabledYn, String createUser, Date createTime, String updateUser, Date updateTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.model = model;
        this.action = action;
        this.sort = sort;
        this.visibility = visibility;
        this.parent = parent;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    /*
     * public void setFunctionalities(List<Functionality> list) {
     * setFunctions(ResultHelper.jasonString(list)); }
     * 
     * public List<Functionality> getFunctionalities() throws Exception { if
     * (getFunctions() == null) return null; ObjectMapper mapper = new
     * ObjectMapper(); try { Functionality[] listArray =
     * mapper.readValue(getFunctions(), Functionality[].class); return
     * Arrays.asList(listArray); } catch (Exception e) { throw e; } }
     */

    public void setId(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return this.id;
    }

    public void setIdEx(Integer value) {
        this.idEx = value;
    }

    public Integer getIdEx() {
        return this.idEx;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String value) {
        this.action = value;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer value) {
        this.sort = value;
    }

    public Integer getParent() {
        return this.parent;
    }

    public void setParent(Integer value) {
        this.parent = value;
    }

    /**
     * @return the functions
     */
    public String getFunctions() {
        return functions;
    }

    /**
     * @param functions
     *            the functions to set
     */
    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getDeleteYn() {
        return this.deleteYn;
    }

    public void setDeleteYn(String value) {
        this.deleteYn = value;
    }

    public String getDisabledYn() {
        return this.disabledYn;
    }

    public void setDisabledYn(String value) {
        this.disabledYn = value;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String value) {
        this.createUser = value;
    }

    public String getCreateTimeString() {
        return DateTimeUtil.format(getCreateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }

    public void setCreateTimeString(String value) {
        setCreateTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date value) {
        this.createTime = value;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String value) {
        this.updateUser = value;
    }

    public String getUpdateTimeString() {
        return DateTimeUtil.format(getUpdateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }

    public void setUpdateTimeString(String value) {
        setUpdateTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date value) {
        this.updateTime = value;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public List<Functionality> getFunctionalities() {
        return functionalities;
    }

    public void setFunctionalities(List<Functionality> functionalities) {
        this.functionalities = functionalities;
    }

    public Integer[] getRemovedFunctionalityIds() {
        return removedFunctionalityIds;
    }

    public void setRemovedFunctionalityIds(Integer[] removedFunctionalityIds) {
        this.removedFunctionalityIds = removedFunctionalityIds;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public static void main(String[] args) {

        Menu m = new Menu();
        m.setFunctions("[{\"code\":\"save\",\"name\":\"新增\",\"operation\":\"save\"}]");
        try {
            System.out.println(m.getFunctionalities());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
