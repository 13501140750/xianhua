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
 * @ClassName      News
 * @Description
 * News
 *
 * @author      liujing
 * @Date        2016-03-16 15:17:32
 * @version     1.0 
 *
 */
public class News extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * title       db_column: title 
     */
    private String title;
    /**
     * image       db_column: image 
     */
    private String image;
    /**
     * subTitlt       db_column: subTitlt 
     */
    private String subTitlt;
    /**
     * 内容       db_column: content 
     */
    private String content;
    /**
     * 1:公告2;资讯       db_column: type 
     */
    private String type;
    /**
     * 排序       db_column: sort 
     */
    private Integer sort;
    /**
     * linkUrl       db_column: linkUrl 
     */
    private String linkUrl;
    /**
     * string1       db_column: string1 
     */
    private String string1;
    /**
     * string2       db_column: string2 
     */
    private String string2;
    /**
     * string3       db_column: string3 
     */
    private String string3;
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


    public News() {
    }

    public News(
        Long id
    ) {
        this.id = id;
    }

    

    public News(
        Long id,
        String title,
        String image,
        String subTitlt,
        String content,
        String type,
        Integer sort,
        String linkUrl,
        String string1,
        String string2,
        String string3,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.subTitlt = subTitlt;
        this.content = content;
        this.type = type;
        this.sort = sort;
        this.linkUrl = linkUrl;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }


    public void setId(Long value) {
        this.id = value;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setIdEx(Long value) {
        this.idEx = value;
    }
    
    public Long getIdEx() {
        return this.idEx;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
    
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String value) {
        this.image = value;
    }
    
    public String getSubTitlt() {
        return this.subTitlt;
    }
    
    public void setSubTitlt(String value) {
        this.subTitlt = value;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String value) {
        this.content = value;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String value) {
        this.type = value;
    }
    
    public Integer getSort() {
        return this.sort;
    }
    
    public void setSort(Integer value) {
        this.sort = value;
    }
    
    public String getLinkUrl() {
        return this.linkUrl;
    }
    
    public void setLinkUrl(String value) {
        this.linkUrl = value;
    }
    
    public String getString1() {
        return this.string1;
    }
    
    public void setString1(String value) {
        this.string1 = value;
    }
    
    public String getString2() {
        return this.string2;
    }
    
    public void setString2(String value) {
        this.string2 = value;
    }
    
    public String getString3() {
        return this.string3;
    }
    
    public void setString3(String value) {
        this.string3 = value;
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
    
    
    public String getCreateTimeShortString() {
        return DateTimeUtil.format(getUpdateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD.getPattern());
    }
    
}

