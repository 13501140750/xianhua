package com.jifenbao.thirdAPI.KDNiao.model;

import java.io.Serializable;

public class EExpressResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 636263550572201021L;

    private String EBusinessID;

    private boolean success;

    private String resultCode;

    private String reason;

    private String PrintTemplate;

    private ExpressEOrder order;

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String eBusinessID) {
        this.EBusinessID = eBusinessID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPrintTemplate() {
        return PrintTemplate;
    }

    public void setPrintTemplate(String printTemplate) {
        PrintTemplate = printTemplate;
    }

    public ExpressEOrder getOrder() {
        return order;
    }

    public void setOrder(ExpressEOrder order) {
        this.order = order;
    }

}
