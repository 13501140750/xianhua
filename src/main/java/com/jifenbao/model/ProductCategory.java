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
 * @ClassName      ProductCategory
 * @Description
 * ProductCategory
 *
 * @author      wangyawei
 * @Date        2018-02-28 17:52:41
 * @version     1.0 
 *
 */
public class ProductCategory extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * code       db_column: code 
     */
    private String code;
    /**
     * name       db_column: name 
     */
    private String name;
    /**
     * 分类图片       db_column: thumb 
     */
    private String thumb;
    /**
     * 分类图标       db_column: bgImage 
     */
    private String bgImage;
    /**
     * 分类介绍       db_column: description 
     */
    private String description;
    /**
     * 首页是否显示       db_column: showYn 
     */
    private String showYn;
    /**
     * 是否推荐       db_column: recommandYn 
     */
    private String recommandYn;
    /**
     * 是否首页显示       db_column: homeYn 
     */
    private String homeYn;
    /**
     * 广告图片       db_column: advImage 
     */
    private String advImage;
    /**
     * 广告链接       db_column: advUrl 
     */
    private String advUrl;
    /**
     * sort       db_column: sort 
     */
    private Integer sort;
    /**
     * parent       db_column: parent 
     */
    private String parent;
    /**
     * parentYn       db_column: parentYn 
     */
    private String parentYn;
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
	
	private  List<ProductCategory> subCatList;
    
    private List<Product> productList;
    
    public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


    public ProductCategory() {
    }

    public ProductCategory(
        Long id
    ) {
        this.id = id;
    }

    

    public ProductCategory(
        Long id,
        String code,
        String name,
        String thumb,
        String bgImage,
        String description,
        String showYn,
        String recommandYn,
        String homeYn,
        String advImage,
        String advUrl,
        Integer sort,
        String parent,
        String parentYn,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.thumb = thumb;
        this.bgImage = bgImage;
        this.description = description;
        this.showYn = showYn;
        this.recommandYn = recommandYn;
        this.homeYn = homeYn;
        this.advImage = advImage;
        this.advUrl = advUrl;
        this.sort = sort;
        this.parent = parent;
        this.parentYn = parentYn;
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
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String value) {
        this.code = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public String getThumb() {
        return this.thumb;
    }
    
    public void setThumb(String value) {
        this.thumb = value;
    }
    
    public String getBgImage() {
        return this.bgImage;
    }
    
    public void setBgImage(String value) {
        this.bgImage = value;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String value) {
        this.description = value;
    }
    
    public String getShowYn() {
        return this.showYn;
    }
    
    public void setShowYn(String value) {
        this.showYn = value;
    }
    
    public String getRecommandYn() {
        return this.recommandYn;
    }
    
    public void setRecommandYn(String value) {
        this.recommandYn = value;
    }
    
    public String getHomeYn() {
        return this.homeYn;
    }
    
    public void setHomeYn(String value) {
        this.homeYn = value;
    }
    
    public String getAdvImage() {
        return this.advImage;
    }
    
    public void setAdvImage(String value) {
        this.advImage = value;
    }
    
    public String getAdvUrl() {
        return this.advUrl;
    }
    
    public void setAdvUrl(String value) {
        this.advUrl = value;
    }
    
    public Integer getSort() {
        return this.sort;
    }
    
    public void setSort(Integer value) {
        this.sort = value;
    }
    
    public String getParent() {
        return this.parent;
    }
    
    public void setParent(String value) {
        this.parent = value;
    }
    
    public String getParentYn() {
        return this.parentYn;
    }
    
    public void setParentYn(String value) {
        this.parentYn = value;
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
    
	public List<ProductCategory> getSubCatList() {
		return subCatList;
	}

	public void setSubCatList(List<ProductCategory> subCatList) {
		this.subCatList = subCatList;
	}

	@Override
    public String toString(){
      StringBuffer bf = new StringBuffer();

      bf.append("id").append("=").append(this.getId())
	    .append(";")
	    .append("code").append("=").append(this.getCode())
	    .append(";")
	    .append("name").append("=").append(this.getName())
	    .append(";")
	    .append("parent").append("=").append(this.getParent())
	    .append(";")
	    .append("parentYn").append("=").append(this.getParentYn())
	    .append("**********");
      
      if(this.getSubCatList()!=null){
    	  for(ProductCategory subCat:this.getSubCatList()){
    		  
    		  bf.append("subid").append("=").append(subCat.getId())
    		    .append(";")
    		    .append("subCode").append("=").append(subCat.getCode())
    		    .append(";")
    		    .append("subname").append("=").append(subCat.getName())
    		    .append(";")
    		    .append("subparent").append("=").append(subCat.getParent())
    		    .append(";")
    		    .append("subparentYn").append("=").append(subCat.getParentYn())
    		    .append("**");
    	  }
      }
      return bf.toString();
    		  
    }
    
}

