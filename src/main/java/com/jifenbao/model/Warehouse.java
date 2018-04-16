/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName Warehouse
 * @Description Warehouse
 *
 * @author liujing
 * @Date 2015-12-28 11:48:49
 * @version 1.0
 *
 */
public class Warehouse extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    // columns START
    /**
     * 主键 db_column: id
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 仓库名称 db_column: name
     */
    private String name;
    /**
     * 联系人 db_column: contact
     */
    private String contact;
    /**
     * 联系电话 db_column: phone
     */
    private String phone;
    /**
     * 行政区划代码 db_column: province
     */
    private Integer province;
    /**
     * 行政区划代码 db_column: city
     */
    private Integer city;
    /**
     * 行政区划代码 db_column: county
     */
    private Integer county;
    /**
     * 地址 db_column: address
     */
    private String address;
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
     * 类型 db_column: type
     * 0:自由仓库（平台仓库）
     * 1：供应商仓库（一件代发仓库）
     */
    private Integer type;
    /**
     * 供应商主键 db_column: supplierId
     */
    private Integer supplierId;
    // columns END

    private Supplier supplier;

    private String provinceName;

    private String cityName;

    private String countyName;

    public Warehouse() {
    }

    public Warehouse(Integer id) {
        this.id = id;
    }

    public Warehouse(Integer id, String name, String contact, String phone, Integer province, Integer city, Integer county, String address,
            String deleteYn, String disabledYn, String createUser, Date createTime, String updateUser, Date updateTime, Integer type,
            Integer supplierId) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.county = county;
        this.address = address;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.type = type;
        this.supplierId = supplierId;
    }

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

    public String getContact() {
        return this.contact;
    }

    public void setContact(String value) {
        this.contact = value;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public Integer getProvince() {
        return this.province;
    }

    public void setProvince(Integer value) {
        this.province = value;
    }

    public Integer getCity() {
        return this.city;
    }

    public void setCity(Integer value) {
        this.city = value;
    }

    public Integer getCounty() {
        return this.county;
    }

    public void setCounty(Integer value) {
        this.county = value;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String value) {
        this.address = value;
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

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer value) {
        this.type = value;
    }

    public Integer getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Integer value) {
        this.supplierId = value;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

}
