package com.suis.jallen.smarthomedemo.utils;

import org.java_websocket.util.Base64;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Utils {
    public static String mAppid = "";
    public static String mSecret = "";

    /**
     * 数字与小写字母混编字符串
     * @param size
     * @return
     */
    public static String getNumSmallLetter(int size){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<size;i++){
            if(random.nextInt(2) % 2 == 0){//字母
                buffer.append((char) (random.nextInt(27) + 'a'));
            }else{//数字
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }

    public static String getNonce() {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 8; ++i) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }

    public static String calSign(String data) throws Exception {
        String sign = encodeHmacSHA256(data.getBytes("utf-8"), mSecret.getBytes());
        return sign;
    }

    public static String encodeHmacSHA256(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "HmacSHA256");
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] digest = mac.doFinal(data);
        return Base64.encodeBytes(digest);
    }

    public static byte[] initHmacSHA256Key() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("HmacSHA256");
        SecretKey secretKey = generator.generateKey();
        byte[] key = secretKey.getEncoded();
        return key;
    }
}
