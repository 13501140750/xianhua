/**
 * Copyright 2008 - 2018 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      CommissionSetting
 * @Description
 * CommissionSetting
 *
 * @author      wangyawei
 * @Date        2018-01-11 14:04:10
 * @version     1.0 
 *
 */
public class CommissionSetting extends BaseEntity<Integer> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * id       db_column: id 
     */
    private Integer id;
    /** id Exclude */
    private Integer idEx;
    /**
     * 分销层级       db_column: level 
     */
    private Integer level;
    /**
     * 分销内购       db_column: selfBuy 
     */
    private Integer selfBuy;
    /**
     * 成为下线条件       db_column: becomeChild 
     */
    private Integer becomeChild;
    /**
     * 条件       db_column: become 
     */
    private Integer become;
    /**
     * 分销商必须完成资料       db_column: becomeReg 
     */
    private Integer becomeReg;
    /**
     * 是否需要审核       db_column: becomeCheck 
     */
    private Integer becomeCheck;
    /**
     * 不是分销商点击分销中心跳转路径       db_column: noCommissionUrl 
     */
    private String noCommissionUrl;
    /**
     * 提现方式       db_column: cashCredit 
     */
    private String cashCredit;
    /**
     * 提现额度       db_column: withdraw 
     */
    private Double withdraw;
    /**
     * 佣金计算方式       db_column: commissionType 
     */
    private Integer commissionType;
    /**
     * 佣金提现手续费       db_column: withdrawCharge 
     */
    private Double withdrawCharge;
    /**
     * 佣金提免手续费开始金额       db_column: withdrawBegin
     */
    private Double withdrawBegin;
    /**
     * 佣金提免手续费结束金额       db_column: withdrawEnd
     */
    private Double withdrawEnd;
    /**
     * 结算天数       db_column: settleDays 
     */
    private Integer settleDays;
    /**
     * 分销商升级依据       db_column: levelType 
     */
    private Integer levelType;
    /**
     * 是否开启商品详情二维码分享       db_column: qrcodeShare 
     */
    private Integer qrcodeShare;
    /**
     * 分销订单是否显示商品详情       db_column: openOrderDetail 
     */
    private Integer openOrderDetail;
    /**
     * 分销订单是否显示购买者       db_column: openOrderBuyer 
     */
    private Integer openOrderBuyer;
    /**
     * 是否关闭分销中心推广二维码       db_column: closedQrcode 
     */
    private Integer closedQrcode;
    /**
     * 推广二维码用超级海报的关注海报,推广二维码默认使用原来默认,如果选择则使用关注海报       db_column: qrcode 
     */
    private Integer qrcode;
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
    //columns END


    public CommissionSetting() {
    }

    public CommissionSetting(
        Integer id
    ) {
        this.id = id;
    }

    

    public CommissionSetting(
        Integer id,
        Integer level,
        Integer selfBuy,
        Integer becomeChild,
        Integer become,
        Integer becomeReg,
        Integer becomeCheck,
        String noCommissionUrl,
        String cashCredit,
        Double withdraw,
        Integer commissionType,
        Double withdrawCharge,
        Integer settleDays,
        Integer levelType,
        Integer qrcodeShare,
        Integer openOrderDetail,
        Integer openOrderBuyer,
        Integer closedQrcode,
        Integer qrcode,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime
    ) {
        this.id = id;
        this.level = level;
        this.selfBuy = selfBuy;
        this.becomeChild = becomeChild;
        this.become = become;
        this.becomeReg = becomeReg;
        this.becomeCheck = becomeCheck;
        this.noCommissionUrl = noCommissionUrl;
        this.cashCredit = cashCredit;
        this.withdraw = withdraw;
        this.commissionType = commissionType;
        this.withdrawCharge = withdrawCharge;
        this.settleDays = settleDays;
        this.levelType = levelType;
        this.qrcodeShare = qrcodeShare;
        this.openOrderDetail = openOrderDetail;
        this.openOrderBuyer = openOrderBuyer;
        this.closedQrcode = closedQrcode;
        this.qrcode = qrcode;
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
    
    public Integer getLevel() {
        return this.level;
    }
    
    public void setLevel(Integer value) {
        this.level = value;
    }
    
    public Integer getSelfBuy() {
        return this.selfBuy;
    }
    
    public void setSelfBuy(Integer value) {
        this.selfBuy = value;
    }
    
    public Integer getBecomeChild() {
        return this.becomeChild;
    }
    
    public void setBecomeChild(Integer value) {
        this.becomeChild = value;
    }
    
    public Integer getBecome() {
        return this.become;
    }
    
    public void setBecome(Integer value) {
        this.become = value;
    }
    
    public Integer getBecomeReg() {
        return this.becomeReg;
    }
    
    public void setBecomeReg(Integer value) {
        this.becomeReg = value;
    }
    
    public Integer getBecomeCheck() {
        return this.becomeCheck;
    }
    
    public void setBecomeCheck(Integer value) {
        this.becomeCheck = value;
    }
    
    public String getNoCommissionUrl() {
        return this.noCommissionUrl;
    }
    
    public void setNoCommissionUrl(String value) {
        this.noCommissionUrl = value;
    }
    
    public String getCashCredit() {
        return this.cashCredit;
    }
    
    public void setCashCredit(String value) {
        this.cashCredit = value;
    }
    
    public Double getWithdraw() {
        return this.withdraw;
    }
    
    public void setWithdraw(Double value) {
        this.withdraw = value;
    }
    
    public Integer getCommissionType() {
        return this.commissionType;
    }
    
    public void setCommissionType(Integer value) {
        this.commissionType = value;
    }
    
    public Double getWithdrawCharge() {
        return this.withdrawCharge;
    }
    
    public void setWithdrawCharge(Double value) {
        this.withdrawCharge = value;
    }
    
    public Integer getSettleDays() {
        return this.settleDays;
    }
    
    public void setSettleDays(Integer value) {
        this.settleDays = value;
    }
    
    public Integer getLevelType() {
        return this.levelType;
    }
    
    public void setLevelType(Integer value) {
        this.levelType = value;
    }
    
    public Integer getQrcodeShare() {
        return this.qrcodeShare;
    }
    
    public void setQrcodeShare(Integer value) {
        this.qrcodeShare = value;
    }
    
    public Integer getOpenOrderDetail() {
        return this.openOrderDetail;
    }
    
    public void setOpenOrderDetail(Integer value) {
        this.openOrderDetail = value;
    }
    
    public Integer getOpenOrderBuyer() {
        return this.openOrderBuyer;
    }
    
    public void setOpenOrderBuyer(Integer value) {
        this.openOrderBuyer = value;
    }
    
    public Integer getClosedQrcode() {
        return this.closedQrcode;
    }
    
    public void setClosedQrcode(Integer value) {
        this.closedQrcode = value;
    }
    
    public Integer getQrcode() {
        return this.qrcode;
    }
    
    public void setQrcode(Integer value) {
        this.qrcode = value;
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

	public Double getWithdrawBegin() {
		return withdrawBegin;
	}

	public void setWithdrawBegin(Double withdrawBegin) {
		this.withdrawBegin = withdrawBegin;
	}

	public Double getWithdrawEnd() {
		return withdrawEnd;
	}

	public void setWithdrawEnd(Double withdrawEnd) {
		this.withdrawEnd = withdrawEnd;
	}
    
    
}

