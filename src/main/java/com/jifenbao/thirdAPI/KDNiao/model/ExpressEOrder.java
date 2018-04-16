package com.jifenbao.thirdAPI.KDNiao.model;

import java.io.Serializable;

public class ExpressEOrder implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4579388444209701029L;

    private String orderCode;
    private String shipperCode;
    private String lsogisticCode;
    private String markDestination;
    private String originCode;
    private String originName;
    private String packageCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getLsogisticCode() {
        return lsogisticCode;
    }

    public void setLsogisticCode(String lsogisticCode) {
        this.lsogisticCode = lsogisticCode;
    }

    public String getMarkDestination() {
        return markDestination;
    }

    public void setMarkDestination(String markDestination) {
        this.markDestination = markDestination;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }
}
