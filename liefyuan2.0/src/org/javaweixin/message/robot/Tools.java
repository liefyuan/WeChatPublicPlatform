package org.javaweixin.message.robot;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * 这里是有一些小工具函数
 *
 * Created by yuanlifu on 2017/3/9.
 */
public class Tools {

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public static String getRemoteAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) ip = request.getHeader("Proxy-Client-IP");
        if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) ip = request.getHeader("WL-Proxy-Client-IP");
        if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) ip = request.getRemoteAddr();
        String p[] = ip.split(",");
        String address = p[0];
        return address;
    }

    /**
     * 获取MAC地址
     * @param ip
     * @return
     */
    public static String getMACAddress(String ip){
        String str = "";
        String macAddress = "";
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
    }
}
