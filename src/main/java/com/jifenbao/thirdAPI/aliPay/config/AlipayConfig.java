package com.jifenbao.thirdAPI.aliPay.config;

import com.jifenbao.common.PropertyConfig;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String partner = "2088221671864292";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = partner;

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEZnNY4JLGEteo3ayDnTGrnjqZx3c1twQUGy55OwQBdI94DMNnaDBKkvHALqgZGi8PzCzKt+RDe7NuqGT3Hfpm3J1FhyAD+Tb7dGQHHdPMORblxILvxFBiDzcon4O5+s2R3BW9mlIYe9P7ltFhU2vyH6J98DhbZzF6/PKRJW2mYdAyq4CxSLx0cFPLiQ/o++YFeICTMdWVMlY53HvJ7vco7skvr6nym5e4lBcfLETEe4mOdqimxHzmfbztXeEXGkiNNBElg9y4mcIFocRI6/2q3I+TAm4nCAc3j43hzTmL45DyXRYe3crg71pCc/Rktl0RPqXDg0KurBQ5XxLk2O8VAgMBAAECggEAep9MKz9qkEo5NCuCMC8xJooYKf6D2NrUyy5Vf2/6CMMEcSIZA7eKKjcn8V8EzqLifVYTEfj4TsvNZipNwFUiaYvfmNpJ+4QfuQmV7sVgOF+TZl/3CMsfy4HeCyCZZnDzXSihdgXsDML6lKOc7e/OJOPJoawO9hB/0jFdErLAd/v/tCWX/im46kFmVsV9P6c3AWBDow8ih1/VC4FfvrBHi3NGwWQ2/gCtBNN/VtPM8Foz5SZZ/3GFFvFlmJsTf7cy7gyYoL8nS9k1bK6Uwx5ds0dY97LaONaPCn+M5lMQmvK0pdwtZHD77tKzu2Yzg0m57jifnEsKDu1uvZ3EE/b2zQKBgQDDPdYSrHByOY5wiQaMY4KGfC9ogYoPUGRdjOSzLRcZ+FgtYJ0aCbUJScpRlaj6iYJlrQ01xcZgZM1T6q9whzdPHg5GcL/chfA9mhTiFUCgrQcmLU6Z67IzbGZKLXw6Sq0HBSIxSqTMg8drhQx1+Cyka2bMTsyu48m9EEUB/YTgywKBgQCtmkdv4lh0y3rNFjdwaivR8TzB3NR6tQBlZs4f6OZ/lGigb+NiyLM5Fxz+eFrSiD6bvsimPyvJVzGqudszjvw9XOmT1kR7x6Y3yAGBKslTi6LBpcuB4yP1RN43v28v/nz4rAI7i8HZ63heol6JL3cPtqPKmxhxU2qht1P3rt7TnwKBgGSJK/nTp9d5wdo7BQ83kpfTzMnAoqn+GKB/k6icGGA8HJPJQzyMMRfGUpMuQKQ6ONZIhRviaqNqZLzIhWyphBaOgIVPO8y/f5UJCaXdkbjrQFotTGNAFjQappWd1HFj0LNjtlaxfCj/1qmMCn2YvMwxre6YyRdpnpFnllFPDaR/AoGAc1WQKFDkG5Qj3aTo6BJhUnVGvDUOJQejX7rRLnn4yMG8UPqEwtg72a31YUpsbHp/vdEeVPSbDoSTRq17Z+GSyuGzfLhZfzLAx0ZlWX8nig2275hKf9x7wzMhvz+7itM0C7GbOhw7iZ/atGSDEfkqzJG2d6BauM+GhDHb4y2WdFkCgYAl0argPIrCNf08ou2mVg0Kpgawgvj58ZZSIWdI0Nuneg9boixGqODTq9fWaQMCtJ+DcZ+/8ZYWtrgyB8xnDNmmufcuQOJpgu2Q5iJ7fOptFeAOAQQk5iRu+tRyZCDEroGfswzckzN7HMcmSKaif1dQQQ2Aj1dh5OkinY2hieBDng==";
	
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = PropertyConfig.getPropertyValue("webHttpUrl")+"/payOrder/ailpay/notice";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = PropertyConfig.getPropertyValue("webHttpUrl")+"/cashPaymentOrder/payoff";

	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		
	// 支付类型 ，无需修改
	public static String payment_type = "1";
		
	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
//↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";
	
	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";
		
//↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
}

