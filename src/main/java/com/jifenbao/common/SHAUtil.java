package com.jifenbao.common;

import java.security.MessageDigest;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class SHAUtil {
    /*** 
     * SHA加密 生成40位SHA码
     * @param 待加密字符串
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA-256");
            
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("GBK");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) { 
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    
    public static String sha_256(String noenCodePwd) {       
        ShaPasswordEncoder sha = new ShaPasswordEncoder(256); 
        sha.setEncodeHashAsBase64(true);       
        String pwd = sha.encodePassword(noenCodePwd, null);        
        return pwd;
    }       
       

    /**
     * 测试主函数
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("1q2w3e4r");
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + shaEncode(str));
        System.out.println("spring sha256 "+SHAUtil.sha_256("1q2w3e4r"));
        //cquZT6LrQmwFHvWcrWF3UL/gbXz2MRKF/3nBnDKv0jY=
    }
}