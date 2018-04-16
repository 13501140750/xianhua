package com.jifenbao.model.helper;

import java.io.Serializable;
import java.util.Date;

/** 
* @author 作者 wangyawei: 
* @version 创建时间：2018年1月10日 下午5:44:41 
* 类说明 
*/
@SuppressWarnings("all")
public class CommissionSet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5060604220530838989L;
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 分销层级
	 */
	private Integer level;
	
	/**
	 * 分销内购
	 */
	private Integer selfbuy;
	
	/**
	 * 成为下线条件
	 */
	private Integer becomeChild;
	
	/**
	 * 成为分销商条件
	 */
	private String become;
	
	/**
	 * 分销商必须完善资料
	 */
	private Integer become_reg;
	
	/**
	 * 是否需要审核
	 */
	private Integer becomeCheck;
	
	/**
	 * 不是分销商点击分销中心跳转路径
	 */
	private String noCommissionUrl;
	
	/**
	 * 提现方式
	 */
	private String cashcredit;
	
	/**
	 * 提现额度
	 */
	private Double withdraw;
	
	/**
	 * 佣金计算方式
	 */
	private Integer commissiontype;
	
	/**
	 * 佣金提现手续费
	 */
	private Double withdrawcharge;
	
	/**
	 * 结算天数
	 */
	private Integer settledays;
	
	/**
	 * 分销商升级依据
	 */
	private Integer leveltype;
	
	/**
	 * 是否开启商品详情二维码分享
	 */
	private Integer qrcodeshare;
	
	/**
	 * 分销订单是否显示商品详情
	 */
	private Integer openorderdetail;
	
	/**
	 * 分销订单是否显示购买者
	 */
	private Integer openorderbuyer;
	
	/**
	 * 是否关闭分销中心推广二维码
	 */
	private Integer closed_qrcode;
	
	/**
	 * 推广二维码用超级海报的关注海报,推广二维码默认使用原来默认,如果选择则使用关注海报
	 */
	private Integer qrcode;
	
	

	
}
 