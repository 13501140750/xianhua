package com.jifenbao.thirdAPI.KDNiao.model;

public enum KDNiaoDirective {

    /**
     * 在线下单
     */
    D_1001 {
        public String getCode() {
            return "1001";
        }
    },

    /**
     * 物流轨迹查询
     */
    D_1002 {
        public String getCode() {
            return "1002";
        }
    },

    /**
     * 绑定订单
     */
    D_1003 {
        public String getCode() {
            return "1003";
        }
    },

    /**
     * 取消订单
     */
    D_1004 {
        public String getCode() {
            return "1004";
        }
    },

    /**
     * 运单订阅
     */
    D_1005 {
        public String getCode() {
            return "1005";
        }
    },

    /**
     * 订单分发
     */
    D_1006 {
        public String getCode() {
            return "1006";
        }
    },

    /**
     * 电子面单
     */
    D_1007 {
        public String getCode() {
            return "1007";
        }
    };

    public abstract String getCode();
}
