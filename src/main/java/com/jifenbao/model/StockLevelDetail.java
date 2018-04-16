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
 * @ClassName StockLevelDetail
 * @Description StockLevelDetail
 *
 * @author liujing
 * @Date 2015-12-23 17:09:18
 * @version 1.0
 *
 */
public class StockLevelDetail extends BaseEntity<Integer> {

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
     * 供应商主键 db_column: supplierId
     */
    private Integer supplierId;
    
    /**
     * 对应的供应商产品编码
     */
    private String supplierPrdCode;
    /**
     * 进货价格 db_column: price
     */
    private Double price;
    /**
     * 批次号 db_column: batchNo
     */
    private String batchNo;
    /**
     * 数量 db_column: amount
     */
    private Integer amount;
    /**
     * 残次数量 db_column: defectiveAmount
     */
    private Integer defectiveAmount;
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
     * 订货日期       db_column: orderDate 
     */
    private Date orderDate;
    /**
     * 采购人       db_column: orderPerson 
     */
    private String orderPerson;
    /**
     * 到货日期       db_column: arrivalDate 
     */
    private Date arrivalDate;
    /**
     * 采购数量       db_column: orderAmount 
     */
    private Integer orderAmount;
    // columns END

    private StockLevel stockLevel;

    private Supplier supplier;

    public StockLevelDetail() {
    }

    public StockLevelDetail(Integer id) {
        this.id = id;
    }

    public StockLevelDetail(
            Integer id,
            Integer stockLevelId,
            Integer supplierId,
            String supplierPrdCode,
            Double price,
            String batchNo,
            Integer amount,
            Integer defectiveAmount,
            String deleteYn,
            String disabledYn,
            String createUser,
            Date createTime,
            String updateUser,
            Date updateTime,
            Date orderDate,
            String orderPerson,
            Date arrivalDate,
            Integer orderAmount
        ) {
            this.id = id;
            this.stockLevelId = stockLevelId;
            this.supplierId = supplierId;
            this.supplierPrdCode = supplierPrdCode;
            this.price = price;
            this.batchNo = batchNo;
            this.amount = amount;
            this.defectiveAmount = defectiveAmount;
            this.deleteYn = deleteYn;
            this.disabledYn = disabledYn;
            this.createUser = createUser;
            this.createTime = createTime;
            this.updateUser = updateUser;
            this.updateTime = updateTime;
            this.orderDate = orderDate;
            this.orderPerson = orderPerson;
            this.arrivalDate = arrivalDate;
            this.orderAmount = orderAmount;
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

    public Integer getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Integer value) {
        this.supplierId = value;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double value) {
        this.price = value;
    }

    public String getBatchNo() {
        return this.batchNo;
    }

    public void setBatchNo(String value) {
        this.batchNo = value;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer value) {
        this.amount = value;
    }

    public Integer getDefectiveAmount() {
        return this.defectiveAmount;
    }

    public void setDefectiveAmount(Integer value) {
        this.defectiveAmount = value;
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

    public StockLevel getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(StockLevel stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

	public String getSupplierPrdCode() {
		return supplierPrdCode;
	}

	public void setSupplierPrdCode(String supplierPrdCode) {
		this.supplierPrdCode = supplierPrdCode;
	}

	public String getOrderDateString() {
        return DateTimeUtil.format(getOrderDate(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HYPHEN.getPattern());
    }
    public void setOrderDateString(String value) {
        setOrderDate(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HYPHEN.getPattern()));
    }
    
    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date value) {
        this.orderDate = value;
    }
    
    public String getOrderPerson() {
        return this.orderPerson;
    }
    
    public void setOrderPerson(String value) {
        this.orderPerson = value;
    }
    
    public String getArrivalDateString() {
        return DateTimeUtil.format(getArrivalDate(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HYPHEN.getPattern());
    }
    public void setArrivalDateString(String value) {
        setArrivalDate(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HYPHEN.getPattern()));
    }
    
    public Date getArrivalDate() {
        return this.arrivalDate;
    }
    
    public void setArrivalDate(Date value) {
        this.arrivalDate = value;
    }
    
    public Integer getOrderAmount() {
        return this.orderAmount;
    }
    
    public void setOrderAmount(Integer value) {
        this.orderAmount = value;
    }
    
}
