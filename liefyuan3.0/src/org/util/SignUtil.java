package org.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 这是请求校验的工具类，别个调用的类
 * Created by yuanlifu on 2017/3/7.
 */
public class SignUtil {
    //与接口配置信息中的Token要一样
    private static String token = "javaweixinToken";

    /**
     * 验证微信签名的方法
     * @param signature 加密签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @return
     */
    public static boolean checkSignature(String signature,String timestamp,String nonce){
        String[] arr = new String[]{token,timestamp,nonce};
        //将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);

        StringBuilder content = new StringBuilder();
        for (int i = 0;i < arr.length;i++){
            content.append(arr[i]);//将三个字符合成一个字符串
        }
        MessageDigest md = null;
        String tmpStr = null;
        try{
            md = MessageDigest.getInstance("SHA-1");
            //将那个合成的字符串进行SHA1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return tmpStr != null?tmpStr.equals(signature.toUpperCase()):false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray){
        String strDigest = "";
        for (int i = 0;i < byteArray.length;i++){
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte){
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}

