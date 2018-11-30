package com.zgtong.web.utils;

import java.security.MessageDigest;

/**
 *
 */
public class EncryptUtil {

    public static final String ALGORITHM_MD5 = "MD5";
    public static final String ENCODING_UTF8 = "UTF-8";

    /**
     * 用户密码密文保存指定加密方法
     *
     * @param content
     * @return
     */
    public static String encrypt(String content) {
        if (content == null) return null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_MD5);
            messageDigest.update(content.getBytes(ENCODING_UTF8));
            byte[] digest = messageDigest.digest();
            return hex(digest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 返回十六进制字符串
    private static String hex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            String v = Integer.toHexString((bytes[i] & 0xFF));
            if (v.length() == 1) {
                result.append("0");
            }
            result.append(v);
        }
        return result.toString();
    }

}
