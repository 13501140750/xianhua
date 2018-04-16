
/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @ClassName      StockLogDetail
 * @Description
 * StockLogDetail
 *
 * @author      liujing
 * @Date        2015-12-23 17:24:21
 * @version     1.0 
 *
 */

public class StockLogDetailId implements Serializable{
    private static final long serialVersionUID = 5454155825314635342L;
    
    /**
     * 出入库记录主键       db_column: stockLogId 
     */
    private Integer stockLogId;
    /**
     * 库存详情主键       db_column: stockLevelDetailId 
     */
    private Integer stockLevelDetailId;

    public StockLogDetailId() {
    }

    public StockLogDetailId(
        Integer stockLogId,
        Integer stockLevelDetailId
    ) {
        this.stockLogId = stockLogId;
        this.stockLevelDetailId = stockLevelDetailId;
    }

    
    
    public void setStockLogId(Integer value) {
        this.stockLogId = value;
    }
    
    public Integer getStockLogId() {
        return this.stockLogId;
    }
    
    public void setStockLevelDetailId(Integer value) {
        this.stockLevelDetailId = value;
    }
    
    public Integer getStockLevelDetailId() {
        return this.stockLevelDetailId;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }
}