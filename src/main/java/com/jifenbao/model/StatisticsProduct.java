package com.jifenbao.model;

import java.util.Date;

import com.otc.framework.model.BaseEntity;

public class StatisticsProduct extends BaseEntity<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 11212121L;
	
	private Integer id;
	
	private String type;
	/**
	 * 产品编码
	 */
	private String productCode;
	
	/**
	 * 商品货号
	 */
	private String showCode;
	/**
	 * 出厂型号
	 */
	private String supplierPrdCode;
	/**
	 * 品牌code
	 */
	private String brandCode;
	/**
	 * 品牌名称
	 */
	private String brandName;
	
	/**
	 * 一级分类
	 */
	private String topPrdCatCode;
	
	/**
	 * 工业分类 code
	 */
	private String prdCatCode;
	/**
	 * 产品分类
	 */
	private String productNavcatName;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 规格
	 */
	private String standard;
	/**
	 * 市场价
	 */
	private Double marketPrice;
	/**
	 * 上架状态
	 */
	private String salesStatus;
	/**
	 * 采购价
	 */
	private Double supplyPrice;
	/**
	 * 销售价
	 */
	private Double salesPrice;
	/**
	 * 入库数量
	 */
	private int inAmount;
	/**
	 * 入库日期
	 */
	private String inDate;
	/**
	 * 出库数量
	 */
	private int outAmount;
	/**
	 * 出库日期
	 */
	private String outDate;
	/**
	 * 剩余库存
	 */
	private int amount;
	/**
	 * 供应商公司编码
	 */
	private String companyCode;
	/**
	 * 供应商名称
	 */
	private String provideName;
	/**
	 * 仓库ID
	 */
	private Long warehouseId;
	/**
	 * 仓库名称 
	 */
	private String warehouseName;
	
	/**
	 * 出入库数据
	 */
	private String inandoutAmount;
	/**
	 * 查询条件
	 */
	private String searchText;
	
	public StatisticsProduct(){
		
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getShowCode() {
		return showCode;
	}
	public void setShowCode(String showCode) {
		this.showCode = showCode;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getProductNavcatName() {
		return productNavcatName;
	}
	public void setProductNavcatName(String productNavcatName) {
		this.productNavcatName = productNavcatName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Double getSupplyPrice() {
		return supplyPrice;
	}
	public void setSupplyPrice(Double supplyPrice) {
		this.supplyPrice = supplyPrice;
	}
	public Double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public int getInAmount() {
		return inAmount;
	}
	public void setInAmount(int inAmount) {
		this.inAmount = inAmount;
	}
	public int getOutAmount() {
		return outAmount;
	}
	public void setOutAmount(int outAmount) {
		this.outAmount = outAmount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getProvideName() {
		return provideName;
	}
	public void setProvideName(String provideName) {
		this.provideName = provideName;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getSupplierPrdCode() {
		return supplierPrdCode;
	}
	public void setSupplierPrdCode(String supplierPrdCode) {
		this.supplierPrdCode = supplierPrdCode;
	}
	public String getSalesStatus() {
		return salesStatus;
	}
	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getInandoutAmount() {
		return inandoutAmount;
	}

	public void setInandoutAmount(String inandoutAmount) {
		this.inandoutAmount = inandoutAmount;
	}

	public String getPrdCatCode() {
		return prdCatCode;
	}

	public void setPrdCatCode(String prdCatCode) {
		this.prdCatCode = prdCatCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTopPrdCatCode() {
		return topPrdCatCode;
	}

	public void setTopPrdCatCode(String topPrdCatCode) {
		this.topPrdCatCode = topPrdCatCode;
	}
	
	
	
	
}
