package com.jzweb.httputils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Ryan
 * @version 1.0
 * @date 1/5/2020s
 */
public class Signature {
    public static String md5(String data) throws NoSuchAlgorithmException {
        byte[] strBytes = (data).getBytes();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(strBytes);
        byte[] digest = md.digest();
        return byteArrayToHex(digest);
    }

    private static String byteArrayToHex(byte[] byteArray) {
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] resultCharArray = new char[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        return new String(resultCharArray);
    }
}
