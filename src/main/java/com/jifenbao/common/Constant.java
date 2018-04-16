package com.jifenbao.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Constant {
	
  public static String  YESNOT_Y="Y";
  public static String  YESNOT_N="N";
  
  public static String  SCHEDULE_OPERUSER="systemAuto";
  /**
   * 默认文件类型为图片的图片存放路径
   */
  public static String  FILETYPE_IMG="image";
  /**
   * 默认文件类型为文件的文件存放路径
   */
  public static String  FILETYPE_FILE="file";
  /**
   * 默认文件类型上传路径
   */
  public static String  UPLOAD_DIR="";
  
  
  public final static Map<String,String> AUIT_STATUS = new HashMap<String,String>();
	static{
		
		AUIT_STATUS.put("0", "待审核");
		AUIT_STATUS.put("1", "审核通过");
		AUIT_STATUS.put("2", "审核未通过");
		
	};
	
	/**
	 * 价格区间
	 */
	public final static Map<String,String> PRICE_RANGE = new LinkedHashMap<String,String>();
	static{
		PRICE_RANGE.put("0-199", "0-199");
		PRICE_RANGE.put("200-399", "200-399");
		PRICE_RANGE.put("400-499", "400-499");
		PRICE_RANGE.put("500-699", "500-699");
		PRICE_RANGE.put("700-899", "700-899");
		PRICE_RANGE.put("899-999", "899-999");
		PRICE_RANGE.put("1000以上", "1000");
	};
	
	/**
	 * 默认方圆礼业平台公司编码
	 */
	public static String XNS_COMPANY_CODE="100001";
	
	/**
	 * 默认方圆礼业平台公司编码
	 */
	public static String JIYUN_COMPANY_CODE="100011";
	
	/**
	 * 默认中影汇公司编码
	 */
	public static String ZYH_COMPANY_CODE="200067";
	
	
	/**
	 * 公司类型
	 */
	 public final static Map<String,String> COMPANT_TYPE = new HashMap<String,String>();
		static{
			COMPANT_TYPE.put("common", "个人客户");
			COMPANT_TYPE.put("company", "直客客户");
			COMPANT_TYPE.put("distributor", "渠道分销客户");
			
			/*COMPANT_TYPE.put("supplier", "供应商");*/
		};
		
		
		
		/**
		 *  校验卡号错误信息提示
		 */
		 public final static Map<String,String> CARD_ERRORMSG = new HashMap<String,String>();
			static{
				CARD_ERRORMSG.put("1001", "卡号不存在");
				CARD_ERRORMSG.put("1002", "卡号未启用");
				CARD_ERRORMSG.put("1003", "卡号已使用");
				CARD_ERRORMSG.put("1004", "卡号或密码不正确");
				CARD_ERRORMSG.put("1005", "卡号已过期");
				CARD_ERRORMSG.put("1006", "系统异常");
				CARD_ERRORMSG.put("1007", "此卡未使用,请兑换产品或转积分使用");
				CARD_ERRORMSG.put("1008", "卡内余额不足");
		};
		
		
		
		public final static Map<String,String> ORDER_QUERY_STATUS = new HashMap<String,String>();
		static{
			ORDER_QUERY_STATUS.put("NO_PAY", "NO_PAY");
			ORDER_QUERY_STATUS.put("WAIT_ADUIT", "WAIT_ADUIT");
			ORDER_QUERY_STATUS.put("WAIT_SELLER_SEND_GOODS", "WAIT_SELLER_SEND_GOODS");
			ORDER_QUERY_STATUS.put("WAIT_BUYER_CONFIRM_GOODS", "WAIT_BUYER_CONFIRM_GOODS");
			ORDER_QUERY_STATUS.put("TRADE_FINISHE", "TRADE_FINISHE");
			ORDER_QUERY_STATUS.put("TRADE_CLOSED", "TRADE_CLOSED");
	};  
		
		/**
		 *  订单状态
		 */
		 public final static Map<String,String> ORDER_STATUS = new HashMap<String,String>();
			static{
				ORDER_STATUS.put("NO_PAY", "已生成订单待付款");
				ORDER_STATUS.put("WAIT_ADUIT", "订单提交成功");
				ORDER_STATUS.put("WAIT_SELLER_SEND_GOODS", "等待商家发货");
				ORDER_STATUS.put("WAIT_BUYER_CONFIRM_GOODS", "商家已发货");
				ORDER_STATUS.put("BUYER_CONFIRM_GOODS", "买家已确认收获");
				ORDER_STATUS.put("TRADE_FINISHE", "交易完成");
				ORDER_STATUS.put("TRADE_CLOSED", "订单关闭");
		};
		
		public final static Map<String,String> REFUND_ORDER_STATUS = new HashMap<String,String>();
		static{
			
			REFUND_ORDER_STATUS.put("APPLYED_RETURN", "已申请退货");
			REFUND_ORDER_STATUS.put("APPLYED_EXCHANGE", "已申请换货");
			REFUND_ORDER_STATUS.put("APPLYED_REFUND", "已申请退款");
			REFUND_ORDER_STATUS.put("APPLYED_ADDED", "已申请补发货");
			REFUND_ORDER_STATUS.put("APPLYED_REFUND_SUCCESS", "退款成功");
			REFUND_ORDER_STATUS.put("APPLYED_ADDED_SUCCESS", "补发货成功");
			REFUND_ORDER_STATUS.put("APPLYED_EXCHANGE_AGREE", "已同意换货");
			REFUND_ORDER_STATUS.put("APPLYED_RETURN_AGREE", "已同意退货");
			REFUND_ORDER_STATUS.put("SUCCESS", "售后成功");
			REFUND_ORDER_STATUS.put("FAILED", "售后失败");
	};
		
		
		
		/**
		 *  退款状态
		 */
		 public final static Map<String,String> REFUND_STATUS = new HashMap<String,String>();
			static{
				REFUND_STATUS.put("WAIT_SELLER_AGREE", "已经申请售后，等待商家同意");
				REFUND_STATUS.put("ADDED_SUCCESS", "商家已同意补发货,等待商家发货");
				REFUND_STATUS.put("WAIT_BUYER_RETURN_GOODS", "商家已经同意售后申请，等待客户退货");
				REFUND_STATUS.put("WAIT_SELLER_CONFIRM_GOODS", "客户已经退退货，等待商家确认收货");
				
				REFUND_STATUS.put("SELLER_REFUSE_BUYER", "商家拒绝申请");
				REFUND_STATUS.put("CLOSED", "售后关闭");
				REFUND_STATUS.put("SUCCESS", "售后成功");
		};
		
		 public final static Map<String,String> STOCK_IN_REASONCODE = new HashMap<String,String>();
			static{
				STOCK_IN_REASONCODE.put("1", "采购入库");
				STOCK_IN_REASONCODE.put("2", "商品出库时自动入库");
		};
		
		/**
		 *  退款状态
		 */
		 public final static Map<String,String> REFUND_REASON = new LinkedHashMap<String,String>();
			static{
				REFUND_REASON.put("1001", "商品漏发");
				REFUND_REASON.put("1002", "商品已破损");
				REFUND_REASON.put("2008", "其他原因");
		};
		
		
		 public final static Map<String,String> FILMORDER_STATUS = new LinkedHashMap<String,String>();
			static{
				FILMORDER_STATUS.put("1", "未付款");
				FILMORDER_STATUS.put("2", "已取消");
				FILMORDER_STATUS.put("3", "已付款");
				FILMORDER_STATUS.put("4", "出票成功");
				FILMORDER_STATUS.put("5", "出票失败");
				FILMORDER_STATUS.put("6", "已退票");
		};
		
		/**
		 * 佣金提现方式
		 */
		public final static Map<String,String> CASH_TYPE = new LinkedHashMap<String,String>();
		static{
			CASH_TYPE.put("1001", "账户余额");
			CASH_TYPE.put("1002", "微信红包");
			CASH_TYPE.put("1003", "支付宝");
		};
		
		/**
		 * 佣金提现方式
		 */
		public final static Map<String,String> account = new LinkedHashMap<String,String>();
		static{
			CASH_TYPE.put("account_balance", "账户余额");
			CASH_TYPE.put("account_integral", "账户积分");
		};
		
		
		
  
}
