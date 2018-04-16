package com.jifenbao.thirdAPI.KDNiao.model;

import java.io.Serializable;
import java.util.List;

public class kdniaoOrderLine implements Serializable {

    private static final long serialVersionUID = 3807091975131911823L;

    // 快递公司编码，必填
    private String shipperCode;

    // 订单编号，必填
    private String orderCode;

    // 运单类型：2-纸质运单, 必填
    private Integer orderType = 2;

    // 邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付, 必填
    private int payType;

    // 月结编码, 邮费支付方式为：3-月结时必填
    private String monthCode;

    // 快递类型：1-标准快件, 必填
    private Integer expType = 1;

    // 是否代收货款：1-是，2-否,必填
    private int isNeedPay;

    // 代收货款金额：IsNeedPay的值为1，必填
    private Double payment;

    // 收件人， 必填
    private String toName;

    // 收件省（如广东省，最好不要缺少“省”）， 必填
    private String toProvinceID;

    // 收件市（如深圳市，最好不要缺少“市”）,必填
    private String toCityID;

    // 收件区（如福田区，最好不要缺少“区”或“县”）, 必填
    private String toExpAreaID;

    // 收件人详细地址，必填
    private String toAddressArea;

    // 收件人电话(电话和手机至少要一个)， 必填
    private String toTel;

    // 收件人手机(电话和手机至少要一个)，必填
    private String toMobile;

    // 发货人姓名, 必填
    private String fromName;

    // 发件省（如广东省，最好不要缺少“省”）,必填
    private String fromProvinceID;

    // 发件市（如深圳市，最好不要缺少“市”），必填
    private String fromCityID;

    // 发件区（如福田区，最好不要缺少“区”或“县”），必填
    private String fromExpAreaID;

    // 发件人详细地址
    private String fromAddressArea;

    // 发件人电话(电话和手机至少要一个)，必填
    private String fromTel;

    // 发件人手机(电话和手机至少要一个)，必填
    private String fromMobile;

    // 必填/可选分割线-------------------------//

    // 仓库标识, 可选
    private String warehouseID;

    // 仓库地址，可选
    private String warehouseAddress;

    // 会员标识，可选
    private String memberID;

    // 快递单号，可选
    private String logisticCode;

    // 用户标识(商户自定义)，可选
    private String callBack;

    // 收件人公司， 可选
    private String toCompany;

    // 收件人邮编，可选
    private String toPostCode;

    // 发件公司名, 可选
    private String fromCompany;

    // 发件人邮编, 可选
    private String fromPostCode;

    // 寄件费（运费），可以填0, 可选
    private double cost = 0D;

    // 其他费用（如服务费用等），可以填0, 可选
    private double otherCost = 0D;

    // 物流公司上门取货时间段， “yyyy-MM-dd HH:mm:ss”格式化，本文中所有时间格式相同, 可选
    private String startDate;

    // 物流公司上门取货时间段， “yyyy-MM-dd HH:mm:ss”格式化，本文中所有时间格式相同, 可选
    private String endDate;

    // 物品总重量，可选
    private Double weight;

    // 物品总体积，可选
    private Double volume;

    // 备注,可选
    private String remark;

    private List<Commodity> commoditys;

    public kdniaoOrderLine() {

    }

    /**
     * 必填项初始化
     * 
     * @param shipperCode
     *            快递公司编码
     * @param orderCode
     *            订单编号
     * @param orderType
     *            运单类型：2-纸质运单
     * @param payType
     *            邮费支付方式:1-现付，2-到付
     * @param isNeedPay
     *            是否代收货款：1-是，2-否
     * @param payment
     *            代收货款金额：IsNeedPay的值为1，必填
     * @param toName
     *            收件人
     * @param toProvinceID
     *            收件省（如广东省，最好不要缺少“省”）
     * @param toCityID
     *            收件市（如深圳市，最好不要缺少“市”）
     * @param toExpAreaID
     *            收件区（如福田区，最好不要缺少“区”或“县”）
     * @param toAddressArea
     *            收件人详细地址
     * @param toTel
     *            收件人电话(电话和手机至少要一个)
     * @param toMobile
     *            收件人手机(电话和手机至少要一个)
     * @param fromName
     *            发货人姓名
     * @param fromProvinceID
     *            发件省（如广东省，最好不要缺少“省”）
     * @param fromCityID
     *            发件市（如深圳市，最好不要缺少“市”）
     * @param fromExpAreaID
     *            发件区（如福田区，最好不要缺少“区”或“县”）
     * @param fromAddressArea
     *            发件人详细地址
     * @param fromTel
     *            发件人电话(电话和手机至少要一个)
     * @param FromMobile
     *            发件人手机(电话和手机至少要一个)
     */
    public kdniaoOrderLine(String shipperCode, String orderCode, Integer orderType, int payType, int isNeedPay, Double payment,
            String toName, String toProvinceID, String toCityID, String toExpAreaID, String toAddressArea, String toTel, String toMobile,
            String fromName, String fromProvinceID, String fromCityID, String fromExpAreaID, String fromAddressArea, String fromTel,
            String FromMobile) {
        this.shipperCode = shipperCode;
        this.orderCode = orderCode;
        if (orderType != null)
            this.orderType = orderType;
        this.payType = payType;
        this.isNeedPay = isNeedPay;
        this.payment = payment;
        this.toName = toName;
        this.toProvinceID = toProvinceID;
        this.toCityID = toCityID;
        this.toExpAreaID = toExpAreaID;
        this.toAddressArea = toAddressArea;
        this.toTel = toTel;
        this.toMobile = toMobile;
        this.fromName = fromName;
        this.fromProvinceID = fromProvinceID;
        this.fromCityID = fromCityID;
        this.fromExpAreaID = fromExpAreaID;
        this.fromAddressArea = fromAddressArea;
        this.fromTel = fromTel;
        this.fromMobile = FromMobile;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getIsNeedPay() {
        return isNeedPay;
    }

    public void setIsNeedPay(int isNeedPay) {
        this.isNeedPay = isNeedPay;
    }

    public Double getPayment() {
        return payment;
    }

    public String getPaymentString() {
        return payment == null ? "" : payment.toString();
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToProvinceID() {
        return toProvinceID;
    }

    public void setToProvinceID(String toProvinceID) {
        this.toProvinceID = toProvinceID;
    }

    public String getToCityID() {
        return toCityID;
    }

    public void setToCityID(String toCityID) {
        this.toCityID = toCityID;
    }

    public String getToExpAreaID() {
        return toExpAreaID;
    }

    public void setToExpAreaID(String toExpAreaID) {
        this.toExpAreaID = toExpAreaID;
    }

    public String getToAddressArea() {
        return toAddressArea;
    }

    public void setToAddressArea(String toAddressArea) {
        this.toAddressArea = toAddressArea;
    }

    public String getToTel() {
        return toTel;
    }

    public void setToTel(String toTel) {
        this.toTel = toTel;
    }

    public String getToMobile() {
        return toMobile;
    }

    public void setToMobile(String toMobile) {
        this.toMobile = toMobile;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromProvinceID() {
        return fromProvinceID;
    }

    public void setFromProvinceID(String fromProvinceID) {
        this.fromProvinceID = fromProvinceID;
    }

    public String getFromCityID() {
        return fromCityID;
    }

    public void setFromCityID(String fromCityID) {
        this.fromCityID = fromCityID;
    }

    public String getFromExpAreaID() {
        return fromExpAreaID;
    }

    public void setFromExpAreaID(String fromExpAreaID) {
        this.fromExpAreaID = fromExpAreaID;
    }

    public String getFromAddressArea() {
        return fromAddressArea;
    }

    public void setFromAddressArea(String fromAddressArea) {
        this.fromAddressArea = fromAddressArea;
    }

    public String getFromTel() {
        return fromTel;
    }

    public void setFromTel(String fromTel) {
        this.fromTel = fromTel;
    }

    public String getFromMobile() {
        return fromMobile;
    }

    public void setFromMobile(String fromMobile) {
        this.fromMobile = fromMobile;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public String getCallBack() {
        return callBack;
    }

    public void setCallBack(String callBack) {
        this.callBack = callBack;
    }

    public String getToCompany() {
        return toCompany;
    }

    public String getToCompanyString() {
        return toCompany == null ? "" : toCompany;
    }

    public void setToCompany(String toCompany) {
        this.toCompany = toCompany;
    }

    public String getToPostCode() {
        return toPostCode;
    }

    public void setToPostCode(String toPostCode) {
        this.toPostCode = toPostCode;
    }

    public String getFromCompany() {
        return fromCompany;
    }

    public String getFromCompanyString() {
        return fromCompany == null ? "" : fromCompany;
    }

    public void setFromCompany(String fromCompany) {
        this.fromCompany = fromCompany;
    }

    public String getFromPostCode() {
        return fromPostCode;
    }

    public static void main(String[] args) {
        String s = "abcd,";
        System.out.println(s.substring(0, s.length() - 1));
    }

    public void setFromPostCode(String fromPostCode) {
        this.fromPostCode = fromPostCode;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(double otherCost) {
        this.otherCost = otherCost;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getWeight() {
        return weight;
    }

    public String getWeightString() {
        if (weight == null) {
            weight = 0.0D;
        }
        return this.weight.toString();
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public String getVolumeString() {
        if (volume == null) {
            volume = 0.0D;
        }
        return this.volume.toString();
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getRemark() {
        return remark;
    }

    public String getRemarkString() {
        return remark == null ? "" : remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getExpType() {
        return expType;
    }

    public void setExpType(Integer expType) {
        this.expType = expType;
    }

    public String getMonthCode() {
        return monthCode;
    }

    public String getMonthCodeString() {
        return monthCode == null ? "" : monthCode;
    }

    public void setMonthCode(String monthCode) {
        this.monthCode = monthCode;
    }

    public List<Commodity> getCommoditys() {
        return commoditys;
    }

    public void setCommoditys(List<Commodity> commoditys) {
        this.commoditys = commoditys;
    }

}
