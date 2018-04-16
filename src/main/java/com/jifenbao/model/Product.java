/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jifenbao.common.JfbUtil;
import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      Product
 * @Description
 * Product
 *
 * @author      liujing
 * @Date        2016-01-06 16:08:32
 * @version     1.0 
 *
 */
public class Product extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 产品类型，0是普通产品，1是套装产品       db_column: type 
     */
    private String type;
    /**
     * 商品编码       db_column: code 
     */
    private String code;
    /**
     * 产品型号,相当于showCode       db_column: showCode 
     */
    private String showCode;
    /**
     * 工业分类       db_column: prdCatCode 
     */
    private String prdCatCode;
    /**
     * 对应的一级类目编码       db_column: topPrdCatCode 
     */
    private String topPrdCatCode;
    /**
     * 品牌       db_column: brandCode 
     */
    private String brandCode;
    /**
     * companyCode       db_column: companyCode 
     */
    private String companyCode;
    /**
     * 检索关键字       db_column: searchKey 
     */
    private String searchKey;
    /**
     * title       db_column: title 
     */
    private String title;
    /**
     * 功效       db_column: features 
     */
    private String features;
    /**
     * 条形码       db_column: barcode 
     */
    private String barcode;
    /**
     * 规格       db_column: standard 
     */
    private String standard;
    /**
     * 重量       db_column: weight 
     */
    private Double weight;
    /**
     * 物流重量       db_column: logisticsWeight 
     */
    private Double logisticsWeight;
    /**
     * 显示库存       db_column: count 
     */
    private Integer count;
    /**
     * 产地       db_column: prdPlace 
     */
    private String prdPlace;
    /**
     * 价格区间       db_column: priceRange 
     */
    private String priceRange;
    /**
     * 市场价       db_column: marketPrice 
     */
    private Double marketPrice;
    /**
     * 销售价       db_column: salesPrice 
     */
    private Double salesPrice;
    
    
    /**
     * 是否包含运费       db_column: withShipmentFee 
     */
    private String withShipmentFee;
    /**
     * 快递费       db_column: shipmentFee 
     */
    private Double shipmentFee;
    /**
     * 是否含税       db_column: withTax 
     */
    private String withTax;
    /**
     * 计量单位       db_column: soldUnit 
     */
    private String soldUnit;
    /**
     * 是否提供样品       db_column: sampling 
     */
    private String sampling;
    /**
     * image0       db_column: image0 
     */
    private String image0;
    /**
     * image1       db_column: image1 
     */
    private String image1;
    /**
     * image2       db_column: image2 
     */
    private String image2;
    /**
     * image3       db_column: image3 
     */
    private String image3;
    /**
     * image4       db_column: image4 
     */
    private String image4;
    /**
     * image5       db_column: image5 
     */
    private String image5;
    /**
     * 是否为优质产品,Y是优质，N为不是       db_column: highQualityYn 
     */
    private String highQualityYn;
    /**
     * 准许状态       db_column: approvalStatus 
     */
    private String approvalStatus;
    /**
     * 审核意见       db_column: approvalOpinion 
     */
    private String approvalOpinion;
    /**
     * 是否可定制       db_column: customizeYn 
     */
    private String customizeYn;
    /**
     * 定制数量       db_column: customizeCount 
     */
    private Integer customizeCount;
    /**
     * 定制价格       db_column: customizePrice 
     */
    private Double customizePrice;
    /**
     * 快递方式       db_column: deliveryType 
     */
    private String deliveryType;
    /**
     * 产品描述       db_column: description 
     */
    private String description;
    /**
     * 是否可以展示给客户       db_column: showYn 
     */
    private String showYn;
    /**
     * 是否启用规格       db_column: hasoption 
     */
    private String hasoption;
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
    /**
     * 销售状态，Y 已上架，N：未上架       db_column: salesStatus 
     */
    private String salesStatus;
    /**
     * hotYn       db_column: hotYn 
     */
    private String hotYn;
    /**
     * defalutLogistics       db_column: defalutLogistics 
     */
    private String defalutLogistics;
    /**
     * dateOfDelivery       db_column: dateOfDelivery 
     */
    private String dateOfDelivery;
    /**
     * navCategory       db_column: navCategory 
     */
    private String navCategory;
    /**
     * volume       db_column: volume 
     */
    private String volume;
    /**
     * deliveryCity       db_column: deliveryCity 
     */
    private String deliveryCity;
    /**
     * priPrdCode       db_column: priPrdCode 
     */
    private String priPrdCode;
    /**
     * 外部产品编号，对应供应商产品编号       db_column: outPrdCode 
     */
    private String outPrdCode;
    /**
     * 供货价       db_column: supplyPrice 
     */
    private Double supplyPrice;
    /**
     * giftCardCode       db_column: giftCardCode 
     */
    private String giftCardCode;
    /**
     * withShipmentFeeSingle       db_column: withShipmentFeeSingle 
     */
    private String withShipmentFeeSingle;
    /**
     * 是否为虚拟产品，默认N(实物)       db_column: string3 
     */
    private String string3;
    /**
     * string4       db_column: string4 
     */
    private String string4;
    /**
     * string5       db_column: string5 
     */
    private String string5;
    /**
     * string6       db_column: string6 
     */
    private String string6;
    /**
     * string7       db_column: string7 
     */
    private String string7;
    /**
     * string8       db_column: string8 
     */
    private String string8;
    /**
     * string9       db_column: string9 
     */
    private String string9;
    /**
     * string10       db_column: string10 
     */
    private String string10;
    
    /**
     * 默认仓库 db_column: defalutWarehouse 
     */
    private String defalutWarehouse;
    
    /**
     * 供应商ID
     */
    private Integer supplierId;
    
    /**
     * 供应商公司
     */
    private String supplyCompany;
    //columns END
   
    /*ex*/
    /**
     * 品牌名称
     */
    private String  brandName;
    
    /**
     * 工业分类名称
     */
    private String  prdCatName;
    
    /**
     * 产品状态
     */
    private  String  approvalStatusString;
    
    /**
     * 主图图片路径
     */
    private String priImageUrl;
    
    /**
     * 组合产品对应的单品
     */
    private List<Product> prdouctList;
    
   
    
    /*
     * 模糊查询条件
     */
    private String seachText;

    private Integer productGroupId;
    
    /**
     * 定制产品信息
     */
    private ProductComment  comment;
     
    /**
     * 大客户定制信息
     */
    private CompanyCustomizine customizine;
    /**
     * 当前公司
     */
    private String commentCompanyCode;
    
    private Double lowestSalePrice;///销售价最低
    
    private Double highestSalePrice;//销售价最高
    
    private List<String> prdDateOfDelivery;//供货周期
    
    private List<String> navigationCatString;//产品对应的显示类目列表
    
    /**
     * 显示价格(显示类型为积分则显示积分价格，显示类型为销售价格则显示金额)
     */
    private Double jifenPrice; 
    
    /**
     * 显示方式，默认是1积分，2是价格
     */
    private String showType;
    
    /**
     * 产品价格
     */
    private Double productPrice;
    
    private Long notid;
    
    private Integer stockLevelCount;
    /*
     * 商品剩余库存
     */
    private Integer  inventory ;
    /*
     * 商品评论数
     */
    private Integer commentCount;
    
    /**
     * 规格列表
     */
    private List<ProductSpec> productSpecList;
    
    /**
     *  所有商品规格项SKU
     */
    
    private List<ProductOption> productOptionList;
    public List<ProductOption> getProductOptionList() {
		return productOptionList;
	}

	public void setProductOptionList(List<ProductOption> productOptionList) {
		this.productOptionList = productOptionList;
	}

	/**
     * 产品类目。1:实物 2：虚拟  3：送货上门 
     */
    private Integer prdType;
    
    private Company suppCompany;

    public Product() {
    }

    public List<ProductSpec> getProductSpecList() {
		return productSpecList;
	}

	public void setProductSpecList(List<ProductSpec> productSpecList) {
		this.productSpecList = productSpecList;
	}


	public Product(
        Long id
    ) {
        this.id = id;
    }

    

    public Product(
            Long id,
            String type,
            String code,
            String showCode,
            String prdCatCode,
            String topPrdCatCode,
            String brandCode,
            String companyCode,
            String searchKey,
            String title,
            String features,
            String barcode,
            String standard,
            Double weight,
            Double logisticsWeight,
            Integer count,
            String prdPlace,
            String priceRange,
            Double marketPrice,
            Double salesPrice,
            String withShipmentFee,
            Double shipmentFee,
            String withTax,
            String soldUnit,
            String sampling,
            String image0,
            String image1,
            String image2,
            String image3,
            String image4,
            String image5,
            String highQualityYn,
            String approvalStatus,
            String approvalOpinion,
            String customizeYn,
            Integer customizeCount,
            Double customizePrice,
            String deliveryType,
            String description,
            String showYn,
            String deleteYn,
            String disabledYn,
            String createUser,
            Date createTime,
            String updateUser,
            Date updateTime,
            String salesStatus,
            String hotYn,
            String defalutLogistics,
            String dateOfDelivery,
            String navCategory,
            String volume,
            String deliveryCity,
            String priPrdCode,
            String outPrdCode,
            Double supplyPrice,
            String giftCardCode,
            String withShipmentFeeSingle,
            String string3,
            String string4,
            String string5,
            String string6,
            String string7,
            String string8,
            String string9,
            String string10
        ) {
            this.id = id;
            this.type = type;
            this.code = code;
            this.showCode = showCode;
            this.prdCatCode = prdCatCode;
            this.topPrdCatCode = topPrdCatCode;
            this.brandCode = brandCode;
            this.companyCode = companyCode;
            this.searchKey = searchKey;
            this.title = title;
            this.features = features;
            this.barcode = barcode;
            this.standard = standard;
            this.weight = weight;
            this.logisticsWeight = logisticsWeight;
            this.count = count;
            this.prdPlace = prdPlace;
            this.priceRange = priceRange;
            this.marketPrice = marketPrice;
            this.salesPrice = salesPrice;
            this.withShipmentFee = withShipmentFee;
            this.shipmentFee = shipmentFee;
            this.withTax = withTax;
            this.soldUnit = soldUnit;
            this.sampling = sampling;
            this.image0 = image0;
            this.image1 = image1;
            this.image2 = image2;
            this.image3 = image3;
            this.image4 = image4;
            this.image5 = image5;
            this.highQualityYn = highQualityYn;
            this.approvalStatus = approvalStatus;
            this.approvalOpinion = approvalOpinion;
            this.customizeYn = customizeYn;
            this.customizeCount = customizeCount;
            this.customizePrice = customizePrice;
            this.deliveryType = deliveryType;
            this.description = description;
            this.showYn = showYn;
            this.deleteYn = deleteYn;
            this.disabledYn = disabledYn;
            this.createUser = createUser;
            this.createTime = createTime;
            this.updateUser = updateUser;
            this.updateTime = updateTime;
            this.salesStatus = salesStatus;
            this.hotYn = hotYn;
            this.defalutLogistics = defalutLogistics;
            this.dateOfDelivery = dateOfDelivery;
            this.navCategory = navCategory;
            this.volume = volume;
            this.deliveryCity = deliveryCity;
            this.priPrdCode = priPrdCode;
            this.outPrdCode = outPrdCode;
            this.supplyPrice = supplyPrice;
            this.giftCardCode = giftCardCode;
            this.withShipmentFeeSingle = withShipmentFeeSingle;
            this.string3 = string3;
            this.string4 = string4;
            this.string5 = string5;
            this.string6 = string6;
            this.string7 = string7;
            this.string8 = string8;
            this.string9 = string9;
            this.string10 = string10;
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
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String value) {
        this.type = value;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String value) {
        this.code = value;
    }
    
    
    
    public String getShowCode() {
    	if(comment!=null && StringUtils.isNotBlank(comment.getShowCode())){
    		return comment.getShowCode();
    	}else{
    		return showCode;
    	}
		
	}

	public void setShowCode(String showCode) {
		this.showCode = showCode;
	}

	public String getPrdCatCode() {
        return this.prdCatCode;
    }
    
    public void setPrdCatCode(String value) {
        this.prdCatCode = value;
    }
    
    public String getTopPrdCatCode() {
        return this.topPrdCatCode;
    }
    
    public void setTopPrdCatCode(String value) {
        this.topPrdCatCode = value;
    }
    
    public String getBrandCode() {
        return this.brandCode;
    }
    
    public void setBrandCode(String value) {
        this.brandCode = value;
    }
    
    public String getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(String value) {
        this.companyCode = value;
    }
    
    public String getSearchKey() {
        return this.searchKey;
    }
    
    public void setSearchKey(String value) {
        this.searchKey = value;
    }
    
    public String getTitle() {
    	if(comment!=null && StringUtils.isNotBlank(comment.getTitle())){
    		return comment.getTitle();
    	}else{
    		return title;
    	}
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
    
    public String getFeatures() {
        return this.features;
    }
    
    public void setFeatures(String value) {
        this.features = value;
    }
    
    public String getBarcode() {
        return this.barcode;
    }
    
    public void setBarcode(String value) {
        this.barcode = value;
    }
    
    public String getStandard() {
        return this.standard;
    }
    
    public void setStandard(String value) {
        this.standard = value;
    }
    
    public Double getWeight() {
        return this.weight;
    }
    
    public void setWeight(Double value) {
        this.weight = value;
    }
    
    public Double getLogisticsWeight() {
        return this.logisticsWeight;
    }
    
    public void setLogisticsWeight(Double value) {
        this.logisticsWeight = value;
    }
    
    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(Integer value) {
        this.count = value;
    }
    
    public String getPrdPlace() {
        return this.prdPlace;
    }
    
    public void setPrdPlace(String value) {
        this.prdPlace = value;
    }
    
    public String getPriceRange() {
        return this.priceRange;
    }
    
    public void setPriceRange(String value) {
        this.priceRange = value;
    }
    
    public Double getMarketPrice() {
    	if(comment!=null && comment.getMarketPrice()!=null){
    		return comment.getMarketPrice();
    	}else{
    		return marketPrice;
    	}
      
    }
    
    public void setMarketPrice(Double value) {
        this.marketPrice = value;
    }
    
    public Double getSalesPrice() {
    	if(comment!=null && comment.getSalesPrice()!=null){
    		return comment.getSalesPrice();
    	}else{
    		return salesPrice;
    	}
    }
    
    public void setSalesPrice(Double value) {
        this.salesPrice = value;
    }
    
    public String getWithShipmentFee() {
    	return (StringUtils.isBlank(this.withShipmentFee))?"N":this.withShipmentFee;
    }
    
    public void setWithShipmentFee(String value) {
        this.withShipmentFee = value;
    }
    
    public Double getShipmentFee() {
        return this.shipmentFee;
    }
    
    public void setShipmentFee(Double value) {
        this.shipmentFee = value;
    }
    
    public String getWithTax() {
    	return (StringUtils.isBlank(this.withTax))?"N":this.withTax;
    }
    
    public void setWithTax(String value) {
        this.withTax = value;
    }
    
    public String getSoldUnit() {
        return this.soldUnit;
    }
    
    public void setSoldUnit(String value) {
        this.soldUnit = value;
    }
    
    public String getSampling() {
        return  (StringUtils.isBlank(this.sampling))?"N":this.sampling;
    }
    
    public void setSampling(String value) {
        this.sampling = value;
    }
    
    public String getImage0() {
        return this.image0;
    }
    
    public void setImage0(String value) {
        this.image0 = value;
    }
    
    public String getImage1() {
        return this.image1;
    }
    
    public void setImage1(String value) {
        this.image1 = value;
    }
    
    public String getImage2() {
        return this.image2;
    }
    
    public void setImage2(String value) {
        this.image2 = value;
    }
    
    public String getImage3() {
        return this.image3;
    }
    
    public void setImage3(String value) {
        this.image3 = value;
    }
    
    public String getImage4() {
        return this.image4;
    }
    
    public void setImage4(String value) {
        this.image4 = value;
    }
    
    public String getImage5() {
        return this.image5;
    }
    
    public void setImage5(String value) {
        this.image5 = value;
    }
    
    public String getHighQualityYn() {
        return (StringUtils.isBlank(this.highQualityYn))?"N":this.highQualityYn;
    }
    
    public void setHighQualityYn(String value) {
        this.highQualityYn = value;
    }
    
    public String getApprovalStatus() {
        return this.approvalStatus;
    }
    
    public void setApprovalStatus(String value) {
        this.approvalStatus = value;
    }
    
    public String getApprovalOpinion() {
        return  (StringUtils.isBlank(this.approvalOpinion))?"0":this.approvalOpinion;
    }
    
    public void setApprovalOpinion(String value) {
        this.approvalOpinion = value;
    }
    
    public String getCustomizeYn() {
        return (StringUtils.isBlank(this.customizeYn))?"N":this.customizeYn;
    }
    
    public void setCustomizeYn(String value) {
        this.customizeYn = value;
    }
    
    public Integer getCustomizeCount() {
        return this.customizeCount;
    }
    
    public void setCustomizeCount(Integer value) {
        this.customizeCount = value;
    }
    
    public Double getCustomizePrice() {
        return this.customizePrice;
    }
    
    public void setCustomizePrice(Double value) {
        this.customizePrice = value;
    }
    
    public String getDeliveryType() {
        return this.deliveryType;
    }
    
    public void setDeliveryType(String value) {
        this.deliveryType = value;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String value) {
        this.description = value;
    }
    
    public String getShowYn() {
        return  (StringUtils.isBlank(this.showYn))?"N":this.showYn;
    }
    
    public void setShowYn(String value) {
        this.showYn = value;
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
    public String getCreateTimeString1() {
        return DateTimeUtil.format(getCreateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HYPHEN.getPattern());
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
    
   
    
    public String getSalesStatus() {
		return  (StringUtils.isBlank(this.salesStatus))?"N":this.salesStatus;// salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}

	
    
    public String getHotYn() {
		return  (StringUtils.isBlank(this.hotYn))?"N":this.hotYn;
	}

	public void setHotYn(String hotYn) {
		this.hotYn = hotYn;
	}

	
    
    public String getDefalutLogistics() {
		return defalutLogistics;
	}

	public void setDefalutLogistics(String defalutLogistics) {
		this.defalutLogistics = defalutLogistics;
	}

	
    
    public String getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(String dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	
	public String getDateOfDeliveryString(){
		String dateOfDeliveryString = this.getDateOfDelivery();
		    if(StringUtils.isNotBlank(dateOfDeliveryString)){
		    
		    	dateOfDeliveryString = dateOfDeliveryString.replace(";1;", "一月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";2;", "二月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";3;", "三月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";4;", "四月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";5;", "五月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";6;", "六月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";7;", "七月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";8;", "八月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";9;", "九月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";10;", "十月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";11;", "十一月");
			    dateOfDeliveryString = dateOfDeliveryString.replace(";12;", "十二月");
		        if(dateOfDeliveryString.endsWith(";")){
		        	dateOfDeliveryString = dateOfDeliveryString.substring(0, dateOfDeliveryString.length()-1);
		        }
		        return dateOfDeliveryString;
		    }else{
		    	dateOfDeliveryString="全年配送";
		    }
		    
	        return dateOfDeliveryString;
	}

	public String getString5() {
        return this.string5;
    }
    
    public void setString5(String value) {
        this.string5 = value;
    }

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getPrdCatName() {
		return prdCatName;
	}

	public void setPrdCatName(String prdCatName) {
		this.prdCatName = prdCatName;
	}

	public String getApprovalStatusString() {
		return approvalStatusString;
	}

	public void setApprovalStatusString(String approvalStatusString) {
		this.approvalStatusString = approvalStatusString;
	}

	public String getPriImageUrl() {
		return priImageUrl;
	}

	public void setPriImageUrl(String priImageUrl) {
		this.priImageUrl = priImageUrl;
	}

	public String getSeachText() {
		return seachText;
	}

	public void setSeachText(String seachText) {
		this.seachText = seachText;
	}

	public Integer getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Integer productGroupId) {
		this.productGroupId = productGroupId;
	}

	public ProductComment getComment() {
		return comment;
	}

	public void setComment(ProductComment comment) {
		this.comment = comment;
	}

	

	public String getCommentCompanyCode() {
		return commentCompanyCode;
	}

	public void setCommentCompanyCode(String commentCompanyCode) {
		this.commentCompanyCode = commentCompanyCode;
	}

	public Double getLowestSalePrice() {
		return lowestSalePrice;
	}

	public void setLowestSalePrice(Double lowestSalePrice) {
		this.lowestSalePrice = lowestSalePrice;
	}

	public Double getHighestSalePrice() {
		return highestSalePrice;
	}

	public void setHighestSalePrice(Double highestSalePrice) {
		this.highestSalePrice = highestSalePrice;
	}

	public List<String> getPrdDateOfDelivery() {
		return prdDateOfDelivery;
	}

	public void setPrdDateOfDelivery(List<String> prdDateOfDelivery) {
		this.prdDateOfDelivery = prdDateOfDelivery;
	}

	public String getNavCategory() {
		return navCategory;
	}

	public void setNavCategory(String navCategory) {
		this.navCategory = navCategory;
	}

	

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	

	public String getDeliveryCity() {
		return (StringUtils.isBlank(this.deliveryCity))?"全国":this.deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	

	public String getPriPrdCode() {
		return priPrdCode;
	}

	public void setPriPrdCode(String priPrdCode) {
		this.priPrdCode = priPrdCode;
	}

	public String getString4() {
		return string4;
	}

	public void setString4(String string4) {
		this.string4 = string4;
	}

	public String getString6() {
		return string6;
	}

	public void setString6(String string6) {
		this.string6 = string6;
	}

	public String getString7() {
		return string7;
	}

	public void setString7(String string7) {
		this.string7 = string7;
	}

	public String getString8() {
		return string8;
	}

	public void setString8(String string8) {
		this.string8 = string8;
	}

	public String getString9() {
		return string9;
	}

	public void setString9(String string9) {
		this.string9 = string9;
	}

	public String getString10() {
		return string10;
	}

	public void setString10(String string10) {
		this.string10 = string10;
	}

	public String getOutPrdCode() {
		return outPrdCode;
	}

	public void setOutPrdCode(String outPrdCode) {
		this.outPrdCode = outPrdCode;
	}

	

	public String getGiftCardCode() {
		return giftCardCode;
	}

	public void setGiftCardCode(String giftCardCode) {
		this.giftCardCode = giftCardCode;
	}

	

	public String getWithShipmentFeeSingle() {
		return withShipmentFeeSingle;
	}

	public void setWithShipmentFeeSingle(String withShipmentFeeSingle) {
		this.withShipmentFeeSingle = withShipmentFeeSingle;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}

	public Double getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(Double supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public List<String> getNavigationCatString() {
		return navigationCatString;
	}

	public void setNavigationCatString(List<String> navigationCatString) {
		this.navigationCatString = navigationCatString;
	}

	public String getDefalutWarehouse() {
		return defalutWarehouse;
	}

	public void setDefalutWarehouse(String defalutWarehouse) {
		this.defalutWarehouse = defalutWarehouse;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Double getJifenPrice() {
		return jifenPrice;
	}

	public void setJifenPrice(Double jifenPrice) {
		this.jifenPrice = jifenPrice;
	}

	public String getShowType() {
		return StringUtils.isBlank(showType)?"1":showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}
	
	public CompanyCustomizine getCustomizine() {
		return customizine;
	}

	public void setCustomizine(CompanyCustomizine customizine) {
		this.customizine = customizine;
	}

	public Long getNotid() {
		return notid;
	}

	public void setNotid(Long notid) {
		this.notid = notid;
	}

	public List<Product> getPrdouctList() {
		return prdouctList;
	}

	public void setPrdouctList(List<Product> prdouctList) {
		this.prdouctList = prdouctList;
	}

    public Integer getStockLevelCount() {
        return stockLevelCount;
    }

    public void setStockLevelCount(Integer stockLevelCount) {
        this.stockLevelCount = stockLevelCount;
    }

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Integer getPrdType() {
		return prdType;
	}

	public void setPrdType(Integer prdType) {
		this.prdType = prdType;
	}
	
	

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	

	public Double getProductPrice() {
		return productPrice;
	}

	public String getSupplyCompany() {
		return supplyCompany;
	}

	public void setSupplyCompany(String supplyCompany) {
		this.supplyCompany = supplyCompany;
	}

	public Company getSuppCompany() {
		return suppCompany;
	}

	public void setSuppCompany(Company suppCompany) {
		this.suppCompany = suppCompany;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getHasoption() {
		return hasoption;
	}

	public void setHasoption(String hasoption) {
		this.hasoption = hasoption;
	}
	
	public double getShowPrice(){
		if("1".equals(getHasoption())){
			//如果开启多规格
			if(getLowestSalePrice()==null){
				return getSalesPrice();
			}else{
				return getLowestSalePrice();
			}
		}else{
			return getSalesPrice();
		}
	}
	
	
	
    
}

