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
 * @ClassName StockLevel
 * @Description StockLevel
 *
 * @author liujing
 * @Date 2015-12-23 17:26:16
 * @version 1.0
 *
 */
public class StockLevel extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

    // columns START
    /**
     * 主键 db_column: id
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 仓库主键 db_column: warehouseId
     */
    private Integer warehouseId;
    /**
     * 产品主键 db_column: productId
     */
    private Long productId;
    /**
     * 产品编码 db_column: productCode
     */
    private String productCode;
    /**
     * skuId db_column: productOptionId
     */
    private Long productOptionId;
    /**
     * 库存类型 db_column: type
     */
    private String type;
    /**
     * 数量 db_column: amount
     */
    private Integer amount;
    /**
     * 警戒数量 db_column: alertAmount
     */
    private Integer alertAmount;
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
     * 产品出厂编码 db_column: factoryCode
     */
    private String factoryCode;
    // columns END
   
    private Integer warehouseType;

    private Warehouse warehouse;

    private Product product;

    private int level = 0;

    /**
     * 总入库数
     */
    private Long totalIn;

    /**
     * 总出库数
     */
    private Long totalOut;
    
    /**
     * 查询产品关键字
     */
    private String searchPrdText;

    public StockLevel() {
    }

    public StockLevel(Integer id) {
        this.id = id;
    }

    public StockLevel(Integer id, Integer warehouseId, Long productId, String productCode, String type, Integer amount, Integer alertAmount,
            Integer defectiveAmount, String deleteYn, String disabledYn, String createUser, Date createTime, String updateUser,
            Date updateTime, String factoryCode) {
        this.id = id;
        this.warehouseId = warehouseId;
        this.productId = productId;
        this.productCode = productCode;
        this.type = type;
        this.amount = amount;
        this.alertAmount = alertAmount;
        this.defectiveAmount = defectiveAmount;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.factoryCode = factoryCode;
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

    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(Integer value) {
        this.warehouseId = value;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long value) {
        this.productId = value;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String value) {
        this.productCode = value;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer value) {
        this.amount = value;
    }

    public Integer getAlertAmount() {
        return this.alertAmount;
    }

    public void setAlertAmount(Integer value) {
        this.alertAmount = value;
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

    public String getFactoryCode() {
        return this.factoryCode;
    }

    public void setFactoryCode(String value) {
        this.factoryCode = value;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Long getTotalIn() {
        return totalIn;
    }

    public void setTotalIn(Long totalIn) {
        this.totalIn = totalIn;
    }

    public Long getTotalOut() {
        return totalOut;
    }

    public void setTotalOut(Long totalOut) {
        this.totalOut = totalOut;
    }

	public Integer getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(Integer warehouseType) {
		this.warehouseType = warehouseType;
	}

	public String getSearchPrdText() {
		return searchPrdText;
	}

	public void setSearchPrdText(String searchPrdText) {
		this.searchPrdText = searchPrdText;
	}

	public Long getProductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(Long productOptionId) {
		this.productOptionId = productOptionId;
	}
	
	
    
}
