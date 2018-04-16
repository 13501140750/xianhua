/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
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
 * @ClassName StockLog
 * @Description StockLog
 *
 * @author liujing
 * @Date 2016-03-10 00:06:40
 * @version 1.0
 *
 */
public class StockLog extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    // columns START
    /**
     * 主键 db_column: id
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 库存主键 db_column: stockLevelId
     */
    private Integer stockLevelId;
    /**
     * 出入库类型：出库，入库 db_column: type
     */
    private Integer type;
    /**
     * 数量 db_column: amount
     */
    private Integer amount;
    /**
     * 出入库原因编码 db_column: reasonCode
     */
    private String reasonCode;
    /**
     * 出入库原因 db_column: reasonContent
     */
    private String reasonContent;
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
     * 库存详情主键 db_column: stockLevelDetailId
     */
    private Integer stockLevelDetailId;

    private String exchangeOrderCode;
    /**
     * string1 db_column: string1
     */
    private String string1;
    /**
     * string2 db_column: string2
     */
    private String string2;
    /**
     * string3 db_column: string3
     */
    private String string3;
    /**
     * string4 db_column: string4
     */
    private String string4;
    /**
     * string5 db_column: string5
     */
    private String string5;
    // columns END

    private Product product;

    private Warehouse warehouse;

    private Supplier supplier;

    public StockLog() {
    }

    public StockLog(Integer id) {
        this.id = id;
    }

    public StockLog(Integer id, Integer stockLevelId, Integer type, Integer amount, String reasonCode, String reasonContent,
            String deleteYn, String disabledYn, String createUser, Date createTime, String updateUser, Date updateTime,
            Integer stockLevelDetailId, String exchangeOrderCode, String string1, String string2, String string3, String string4,
            String string5) {
        this.id = id;
        this.stockLevelId = stockLevelId;
        this.type = type;
        this.amount = amount;
        this.reasonCode = reasonCode;
        this.reasonContent = reasonContent;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.stockLevelDetailId = stockLevelDetailId;
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

    public Integer getStockLevelId() {
        return this.stockLevelId;
    }

    public void setStockLevelId(Integer value) {
        this.stockLevelId = value;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer value) {
        this.type = value;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer value) {
        this.amount = value;
    }

    public String getReasonCode() {
        return this.reasonCode;
    }

    public void setReasonCode(String value) {
        this.reasonCode = value;
    }

    public String getReasonContent() {
        return this.reasonContent;
    }

    public void setReasonContent(String value) {
        this.reasonContent = value;
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

    public Integer getStockLevelDetailId() {
        return this.stockLevelDetailId;
    }

    public void setStockLevelDetailId(Integer value) {
        this.stockLevelDetailId = value;
    }

    public String getExchangeOrderCode() {
        return exchangeOrderCode;
    }

    public void setExchangeOrderCode(String exchangeOrderCode) {
        this.exchangeOrderCode = exchangeOrderCode;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public String getString4() {
        return string4;
    }

    public void setString4(String string4) {
        this.string4 = string4;
    }

    public String getString5() {
        return string5;
    }

    public void setString5(String string5) {
        this.string5 = string5;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}
