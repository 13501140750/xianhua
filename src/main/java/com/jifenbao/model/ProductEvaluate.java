/**
 * Copyright 2008 - 2017 Powered by OpenTide <br/>
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
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName      ProductEvaluate
 * @Description
 * ProductEvaluate
 *
 * @author      wangyawei
 * @Date        2017-12-19 20:30:41
 * @version     1.0 
 *
 */
public class ProductEvaluate extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 订单编号       db_column: orderCode 
     */
    @ApiModelProperty(value = "订单编号")
    private String orderCode;
    /**
     * 子订单编号       db_column: subOrderCode 
     */
    @ApiModelProperty(value = "子订单编号")
    private String subOrderCode;
    /**
     * 商品ID       db_column: productId 
     */
    @ApiModelProperty(value = "商品id")
    private Integer productId;
    /**
     * 商品规格id       db_column: productSpecId 
     */
    private Integer productSpecId;
    /**
     * 商品评分       db_column: productScore 
     */
    @ApiModelProperty(value = "商品评分")
    private Integer productScore;
    /**
     * 服务评分       db_column: serviceScore 
     */
    @ApiModelProperty(value = "服务评分")
    private Integer serviceScore;
    /**
     * 时效评分       db_column: timeScore 
     */
    @ApiModelProperty(value = "时效评分")
    private Integer timeScore;
    /**
     * 客户id       db_column: customerId 
     */
    @ApiModelProperty(value = "客户id")
    private Long customerId;
    /**
     * 昵称       db_column: nickname 
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;
    /**
     * 头像地址       db_column: headimgurl 
     */
    @ApiModelProperty(value = "头像")
    private String headimgurl;
    /**
     * 内容       db_column: content 
     */
    @ApiModelProperty(value = "评价内容")
    private String content;
    /**
     * 图片       db_column: images 
     */
    @ApiModelProperty(value = "图片")
    private String images;
    /**
     * 评价审核 0 通过 ;1 审核中;2 拒绝       db_column: checked 
     */
    private Integer checked;
    /**
     * createTime       db_column: createTime 
     */
    private Date createTime;
    /**
     * createUser       db_column: createUser 
     */
    private String createUser;
    /**
     * updateUser       db_column: updateUser 
     */
    private String updateUser;
    /**
     * updateTime       db_column: updateTime 
     */
    private Date updateTime;
    /**
     * deleteYn       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * disabledYn       db_column: disabledYn 
     */
    private String disabledYn;
    //columns END


    public ProductEvaluate() {
    }

    public ProductEvaluate(
        Integer id
    ) {
        this.id = id;
    }

    

    public ProductEvaluate(
        Integer id,
        String orderCode,
        String subOrderCode,
        Integer productId,
        Integer productSpecId,
        Integer productScore,
        Integer serviceScore,
        Integer timeScore,
        Long customerId,
        String nickname,
        String headimgurl,
        String content,
        String images,
        Integer checked,
        Date createTime,
        String createUser,
        String updateUser,
        Date updateTime,
        String deleteYn,
        String disabledYn
    ) {
        this.id = id;
        this.orderCode = orderCode;
        this.subOrderCode = subOrderCode;
        this.productId = productId;
        this.productSpecId = productSpecId;
        this.productScore = productScore;
        this.serviceScore = serviceScore;
        this.timeScore = timeScore;
        this.customerId = customerId;
        this.nickname = nickname;
        this.headimgurl = headimgurl;
        this.content = content;
        this.images = images;
        this.checked = checked;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
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
    
    public String getOrderCode() {
        return this.orderCode;
    }
    
    public void setOrderCode(String value) {
        this.orderCode = value;
    }
    
    public String getSubOrderCode() {
        return this.subOrderCode;
    }
    
    public void setSubOrderCode(String value) {
        this.subOrderCode = value;
    }
    
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer value) {
        this.productId = value;
    }
    
    public Integer getProductSpecId() {
        return this.productSpecId;
    }
    
    public void setProductSpecId(Integer value) {
        this.productSpecId = value;
    }
    
    public Integer getProductScore() {
        return this.productScore;
    }
    
    public void setProductScore(Integer value) {
        this.productScore = value;
    }
    
    public Integer getServiceScore() {
        return this.serviceScore;
    }
    
    public void setServiceScore(Integer value) {
        this.serviceScore = value;
    }
    
    public Integer getTimeScore() {
        return this.timeScore;
    }
    
    public void setTimeScore(Integer value) {
        this.timeScore = value;
    }
    
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Long value) {
        this.customerId = value;
    }
    
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String value) {
        this.nickname = value;
    }
    
    public String getHeadimgurl() {
        return this.headimgurl;
    }
    
    public void setHeadimgurl(String value) {
        this.headimgurl = value;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String value) {
        this.content = value;
    }
    
    public String getImages() {
        return this.images;
    }
    
    public void setImages(String value) {
        this.images = value;
    }
    
    public Integer getChecked() {
        return this.checked;
    }
    
    public void setChecked(Integer value) {
        this.checked = value;
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
    
    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String value) {
        this.createUser = value;
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
    
    
}

