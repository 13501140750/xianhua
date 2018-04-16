/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      CommissionLevel
 * @Description
 * CommissionLevel
 *
 * @author      wangyawei
 * @Date        2018-01-11 16:10:14
 * @version     1.0 
 *
 */
public class CommissionLevel extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 会员等级名       db_column: levelName 
     */
    private String levelName;
    /**
     * 级别1分佣 比例       db_column: commission1 
     */
    private Double commission1;
    /**
     * 级别2分佣 比例        db_column: commission2 
     */
    private Double commission2;
    /**
     * 级别3分佣 比例       db_column: commission3 
     */
    private Double commission3;
    /**
     * type 0 分销订单数量满 ordermoney 元; type 1 一级分销订单金额满 ordermoney 元 ; type 4 自购订单金额满 ordermoney 元       db_column: orderMoney 
     */
    private Double orderMoney;
    /**
     * type 2 分销订单数量满 ordercount 个; type 3 一级分销订单数量满 ordercount 个 ;type 5 自购订单数量满 ordercount 个        db_column: orderCount 
     */
    private Integer orderCount;
    /**
     * type 6 下级总人数满 downcount 个 ; type 7 一级下级人数满 downcount 个 ; type 8 团队总人数满 downcount 个 ;type 9 一级团队人数满 downcount 个       db_column: downCount 
     */
    private Integer downCount;
    /**
     * 升级条件 提现满金额 元       db_column: commissionMoney 
     */
    private Double commissionMoney;
    /**
     * type 0 分销订单数量满 ordermoney 元; type 1 一级分销订单金额满 ordermoney 元 ; type 4 自购订单金额满 ordermoney 元       db_column: defaultYn 
     */
    private String defaultYn;
    /**
     * deleteYn       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * disabledYn       db_column: disabledYn 
     */
    private String disabledYn;
    /**
     * createUser       db_column: createUser 
     */
    private String createUser;
    /**
     * createTime       db_column: createTime 
     */
    private Date createTime;
    /**
     * updateUser       db_column: updateUser 
     */
    private String updateUser;
    /**
     * updateTime       db_column: updateTime 
     */
    private Date updateTime;
    //columns END


    public CommissionLevel() {
    }

    public CommissionLevel(
        Integer id
    ) {
        this.id = id;
    }

    

    public CommissionLevel(
        Integer id,
        String levelName,
        Double commission1,
        Double commission2,
        Double commission3,
        Double orderMoney,
        Integer orderCount,
        Integer downCount,
        Double commissionMoney,
        String defaultYn,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.levelName = levelName;
        this.commission1 = commission1;
        this.commission2 = commission2;
        this.commission3 = commission3;
        this.orderMoney = orderMoney;
        this.orderCount = orderCount;
        this.downCount = downCount;
        this.commissionMoney = commissionMoney;
        this.defaultYn = defaultYn;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
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
    
    public String getLevelName() {
        return this.levelName;
    }
    
    public void setLevelName(String value) {
        this.levelName = value;
    }
    
    public Double getCommission1() {
        return this.commission1;
    }
    
    public void setCommission1(Double value) {
        this.commission1 = value;
    }
    
    public Double getCommission2() {
        return this.commission2;
    }
    
    public void setCommission2(Double value) {
        this.commission2 = value;
    }
    
    public Double getCommission3() {
        return this.commission3;
    }
    
    public void setCommission3(Double value) {
        this.commission3 = value;
    }
    
    public Double getOrderMoney() {
        return this.orderMoney;
    }
    
    public void setOrderMoney(Double value) {
        this.orderMoney = value;
    }
    
    public Integer getOrderCount() {
        return this.orderCount;
    }
    
    public void setOrderCount(Integer value) {
        this.orderCount = value;
    }
    
    public Integer getDownCount() {
        return this.downCount;
    }
    
    public void setDownCount(Integer value) {
        this.downCount = value;
    }
    
    public Double getCommissionMoney() {
        return this.commissionMoney;
    }
    
    public void setCommissionMoney(Double value) {
        this.commissionMoney = value;
    }
    
    public String getDefaultYn() {
        return this.defaultYn;
    }
    
    public void setDefaultYn(String value) {
        this.defaultYn = value;
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
    
    
}

