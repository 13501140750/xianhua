package com.jifenbao.common;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class EncryptionUtil {

    /**
     * sha-256 加密
     * 
     * @param password
     * @return
     */
    public static String encodePassword(String password) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        encoder.setEncodeHashAsBase64(true);
        return encoder.encodePassword(password, null);
    }
}
