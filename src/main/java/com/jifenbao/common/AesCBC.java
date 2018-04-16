package com.jifenbao.common; 
/** 
* @author 作者 wangyawei: 
* @version 创建时间：2018年1月18日 下午6:52:57 
* 类说明 
*/

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**AES 是一种可逆加密算法，对用户的敏感信息加密处理
* 对原始数据进行AES加密后，在进行Base64编码转化；
*/
public class AesCBC {
/*
* 加密用的Key 可以用26个字母和数字组成
* 此处使用AES-128-CBC加密模式，key需要为16位。
*/
	private static String sKey="sklhdflsjfsdgdeg";
	private static String ivParameter="cfbsdfgsdfxccvd1";
	private static AesCBC instance=null;
	private AesCBC(){

	}
	public static AesCBC getInstance(){
		if (instance==null)
			instance= new AesCBC();
		return instance;
	}
	// 加密
	public static String encrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
		return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码。
}

	// 解密
	public static String decrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
		System.out.println(ivParameter);
		System.out.println(sKey);
		System.out.println(ivParameter);
		try {
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original,encodingFormat);
			return originalString;
		} catch (Exception ex) {
			return null;
		}
}

	public static void main(String[] args) throws Exception {
		String data = "HBoZN8dozdz+NnZUppgZ55ueI0WxsytYHXs1OOHu5SPpuuXx+R/TqdYF2joN53qCKHcuOqn0+k98e8BXb0+Ko4HQEOsoD1KgJP05STAuKKGMEH5jUqlannDpnYFbPhjoTXqqhO9XUXirHIfUHTxkXywH4kL+n7upcEhsgjfc0wy7DEWhM/Fci5wugn0vUovIu9n2eXIvBddtSpOz8X/D7Q==";
		String iv = "+IkqBRmldp/CuKceSdK+Kw==";
		String key = "pJDApsEcJUsvBzOiQkOc3w==";
		// 需要加密的字串
		/*String cSrc = "我来自中国";
		System.out.println(cSrc);
		// 加密
		long lStart = System.currentTimeMillis();
		String enString = AesCBC.getInstance().encrypt(cSrc,"utf-8",sKey,ivParameter);
		System.out.println("加密后的字串是："+ enString);

		long lUseTime = System.currentTimeMillis() - lStart;
		System.out.println("加密耗时：" + lUseTime + "毫秒");*/
		// 解密
//		lStart = System.currentTimeMillis();
		String DeString = AesCBC.getInstance().decrypt(data,"utf-8",key,iv);
		System.out.println("解密后的字串是：" + DeString);
		/*lUseTime = System.currentTimeMillis() - lStart;
		System.out.println("解密耗时：" + lUseTime + "毫秒");*/
	}
}


 