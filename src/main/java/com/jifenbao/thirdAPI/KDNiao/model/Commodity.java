package com.jifenbao.thirdAPI.KDNiao.model;

import java.io.Serializable;

public class Commodity implements Serializable {

    private static final long serialVersionUID = -411826455443663034L;

    // 商品名称
    private String goodsName;

    // 商品编码
    private String goodsCode;

    // 商品数量
    private int goodsquantity;

    // 商品价格
    private double goodsPrice;

    // 商品重量
    private double goodsWeight;

    // 商品描述
    private String goodsDesc;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getGoodsquantity() {
        return goodsquantity;
    }

    public void setGoodsquantity(int goodsquantity) {
        this.goodsquantity = goodsquantity;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}
