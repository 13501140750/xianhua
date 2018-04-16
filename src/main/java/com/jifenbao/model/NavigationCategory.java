/**
 * Copyright 2008 - 2015 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      NavigationCategory
 * @Description
 * NavigationCategory
 *
 * @author      liujing
 * @Date        2015-12-12 21:20:20
 * @version     1.0 
 *
 */
public class NavigationCategory extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
  //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * code       db_column: code 
     */
    private String code;
    /**
     * name       db_column: name 
     */
    private String name;
    /**
     * 1：共享，0不共享       db_column: share 
     */
    private String share;
    /**
     * parent       db_column: parent 
     */
    private String parent;
    /**
     * companyCode       db_column: companyCode 
     */
    private String companyCode;
    /**
     * image       db_column: image 
     */
    private String image;
    /**
     * 排序       db_column: sort 
     */
    private Integer sort;
    /**
     * 是否在前台显示       db_column: showYn 
     */
    private String showYn;
    /**
     * navType       db_column: navType 
     */
    private String navType;
    /**
     * navStyle       db_column: navStyle 
     */
    private String navStyle;
    /**
     * customizineYn       db_column: customizineYn 
     */
    private String customizineYn;
    
    /**
     *     db_column: string1 
     */
    private String string1;
    
    /**
     *     db_column: string2 
     */
    private String string2;
    
    /**
     *        db_column: string3 
     */
    private String string3;
    
    
    /**
     *     db_column: string4 
     */
    private String string4;
    
    /**
     * 栏目导航大图       db_column: bgImage 
     */
    private String bgImage;
    
    /**
     * 栏目小图标       db_column: navIcon 
     */
    private String navIcon;
    
    /**
     * 栏目列表图标       db_column: navIcon 
     */
    private String navListIcon;
    
    public String getMobileBgImages() {
		return mobileBgImages;
	}

	public void setMobileBgImages(String mobileBgImages) {
		this.mobileBgImages = mobileBgImages;
	}

	/**
     * 手机分类导航图       db_column: navIcon 
     */
    private String mobileBgImages;
    
    
    public String getNavListIcon() {
		return navListIcon;
	}

	public void setNavListIcon(String navListIcon) {
		this.navListIcon = navListIcon;
	}
	
	//获取手机导航图数组
	public String[] getMobileBgImagesArray(){
		String images = getMobileBgImages();
		if(images!=null && !"".equals(images)){
			if(images.endsWith(",")){
				return images.substring(0, images.length()).split(",");
			}else{
				return images.split(",");
			}
		}
		return null;
	}

	/**
     * 1：已删除，0未删除       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * 1：不可以，0 可用       db_column: disabledYn 
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
    
    //ex
    private  List<ProductCategory> subCatList;
    
    private List<Product> productList;
    
    
    
    public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	private String searchText;  //查询条件

    public NavigationCategory() {
    }

    public NavigationCategory(
        Integer id
    ) {
        this.id = id;
    }

    

    public NavigationCategory(
            Integer id,
            String code,
            String name,
            String share,
            String parent,
            String companyCode,
            String image,
            Integer sort,
            String showYn,
            String navType,
            String navStyle,
            String customizineYn,
            String string4,
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
            this.share = share;
            this.parent = parent;
            this.companyCode = companyCode;
            this.image = image;
            this.sort = sort;
            this.showYn = showYn;
            this.navType = navType;
            this.navStyle = navStyle;
            this.customizineYn = customizineYn;
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
    
    public String getShare() {
        return this.share;
    }
    
    public void setShare(String value) {
        this.share = value;
    }
    
    public String getParent() {
        return this.parent;
    }
    
    public void setParent(String value) {
        this.parent = value;
    }
    
    public String getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(String value) {
        this.companyCode = value;
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
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShowYn() {
		return showYn;
	}

	public void setShowYn(String showYn) {
		this.showYn = showYn;
	}

	public String getSearchText() {
		return searchText;
	}
	
	

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	

	public String getNavType() {
		return navType;
	}

	public void setNavType(String navType) {
		this.navType = navType;
	}

	public String getNavStyle() {
		return navStyle;
	}

	public void setNavStyle(String navStyle) {
		this.navStyle = navStyle;
	}

	public String getCustomizineYn() {
		return customizineYn;
	}

	public void setCustomizineYn(String customizineYn) {
		this.customizineYn = customizineYn;
	}

	
	
	

	public String getBgImage() {
		return bgImage;
	}

	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	public String getNavIcon() {
		return navIcon;
	}

	public void setNavIcon(String navIcon) {
		this.navIcon = navIcon;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public void setSearchText(String searchText) {
		if(StringUtils.isNotBlank(searchText)){
			this.setName(searchText);
			this.setCode(searchText);
		}
		this.searchText = searchText;
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
    
    
	

	
    
}

