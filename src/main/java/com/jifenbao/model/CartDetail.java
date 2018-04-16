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
 * @ClassName CartDetail
 * @Description CartDetail
 *
 * @author liujing
 * @Date 2016-01-31 00:54:11
 * @version 1.0
 *
 */
public class CartDetail extends BaseEntity<String> {

	private static final long serialVersionUID = 1L;

	// columns START
	/**
	 * 购物车详情ID<UUID db_column: id
	 */
	private String id;
	/** id Exclude */
	private String idEx;
	/**
	 * 购物车ID db_column: cartId
	 */
	private String cartId;
	/**
	 * 类型 db_column: type
	 */
	private Integer type;
	/**
	 * 商品ID db_column: productId
	 */
	private Long productId;
	/**
	 * 商品编码 db_column: productCode
	 */
	private String productCode;
	/**
	 * 规格ID db_column: optionId
	 */
	private Long optionId;
	/**
	 * 产品对应的展示类目
	 */
	private String navcatCode;
	/**
	 * 卡册ID db_column: giftcardId
	 */
	private Long giftcardId;
	/**
	 * 卡册ID db_column: giftcardId
	 */
	private String giftcardCode;
	/**
	 * 商品数量 db_column: count
	 */
	private Integer count;
	/**
	 * 创建时间 db_column: createTime
	 */
	private Date createTime;
	/**
	 * 修改时间 db_column: updateTime
	 */
	private Date updateTime;
	// columns END

	/**
	 * 产品
	 */
	private Product product;
	
	private DeliveryAddress devAddress;
	
	private NavigationCategory navBean;
	
	private ProductOption productOption;
	
	public ProductOption getProductOption() {
		return productOption;
	}

	public void setProductOption(ProductOption productOption) {
		this.productOption = productOption;
	}

	public CartDetail() {
	}

	public CartDetail(String id) {
		this.id = id;
	}

	public CartDetail(String id, String cartId, Integer type, Long productId, String productCode, Long giftcardId,
			Integer count, Date createTime, Date updateTime) {
		this.id = id;
		this.cartId = cartId;
		this.type = type;
		this.productId = productId;
		this.productCode = productCode;
		this.giftcardId = giftcardId;
		this.count = count;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getId() {
		return this.id;
	}

	public void setIdEx(String value) {
		this.idEx = value;
	}

	public String getIdEx() {
		return this.idEx;
	}

	public String getCartId() {
		return this.cartId;
	}

	public void setCartId(String value) {
		this.cartId = value;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer value) {
		this.type = value;
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

	public Long getGiftcardId() {
		return this.giftcardId;
	}

	public void setGiftcardId(Long value) {
		this.giftcardId = value;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer value) {
		this.count = value;
	}

	public String getCreateTimeString() {
		return DateTimeUtil.format(getCreateTime(),
				DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
	}

	public void setCreateTimeString(String value) {
		setCreateTime(
				DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date value) {
		this.createTime = value;
	}

	public String getUpdateTimeString() {
		return DateTimeUtil.format(getUpdateTime(),
				DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
	}

	public void setUpdateTimeString(String value) {
		setUpdateTime(
				DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getGiftcardCode() {
		return giftcardCode;
	}

	public void setGiftcardCode(String giftcardCode) {
		this.giftcardCode = giftcardCode;
	}

	public String getNavcatCode() {
		return navcatCode;
	}

	public void setNavcatCode(String navcatCode) {
		this.navcatCode = navcatCode;
	}

	public NavigationCategory getNavBean() {
		return navBean;
	}

	public void setNavBean(NavigationCategory navBean) {
		this.navBean = navBean;
	}

	public DeliveryAddress getDevAddress() {
		return devAddress;
	}

	public void setDevAddress(DeliveryAddress devAddress) {
		this.devAddress = devAddress;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	

	
	
	
}
