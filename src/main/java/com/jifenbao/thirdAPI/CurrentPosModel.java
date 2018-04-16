package com.jifenbao.thirdAPI;

import org.apache.commons.lang3.StringUtils;

public class CurrentPosModel {

	/**
	 * 详细地址 
	 */
	String address;
	/**
	 * 简要地址
	 */
	String subAddress;
	/**
	 * 城市
	 */
	String city;
	
	/**
	 * 百度城市代码
	 */
	String cityCode;
	/**
	 * 区县
	 */
	String district;
	/**
	 * 省份
	 */
	String province;
	/**
	 * 街道
	 */
	String street;
	/**
	 * 门址
	 */
	String streetNumber;
	/**
	 *百度纬度 
	 */
	String pointX;
	/**
	 *百度经度 
	 */
	String pointY;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSubAddress() {
		return subAddress;
	}
	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	
	
	
	public void setProvince(String province) {
		this.province = province;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNnumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	/**
	 * 维度
	 * @return
	 */
	public String getPointX() {
		return pointX;
	}
	public void setPointX(String pointX) {
		this.pointX = pointX;
	}
	/**
	 * 经度
	 * @return
	 */
	public String getPointY() {
		return pointY;
	}
	public void setPointY(String pointY) {
		this.pointY = pointY;
	}
	
	
	public String getProvinceShortName() {
		String shortName = "";
		if(StringUtils.isNotBlank(this.province)){
			if(this.province.endsWith("市") || this.province.endsWith("省")){
				shortName = this.province.substring(0, this.province.length()-1);
			}		
		}
		return shortName;
	}
	
	public String getCityShortName() {
		String shortName = "";
		if(StringUtils.isNotBlank(this.city)){
			if(this.city.endsWith("市")){
				shortName = this.city.substring(0, this.city.length()-1);
			}		
		}
		return shortName;
	}
	
}
