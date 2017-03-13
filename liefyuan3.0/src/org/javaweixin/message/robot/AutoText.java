package org.javaweixin.message.robot;

import org.javaweixin.message.Data.BabyData;
import org.util.MySQLDriver;

/**
 *  自定义文本自动回复
 *
 * Created by yuanlifu on 2017/3/8.
 */
public class AutoText {

    public static String autoRespond(String content)  {
        String respText = "";
        //BabyData babyData = MySQLDriver.queryIdBabyData(2);
        if ("hello".equals(content.trim())){
            respText = "hello";
        }else if ("你好".equals(content.trim())){
            BabyData babyData = MySQLDriver.queryIdBabyData(2);
            int id = babyData.getId();
            String babyId = babyData.getBabyId();
            String babyTemp = babyData.getBabyTemp();
            respText = id + babyId + babyTemp;
            //respText = "你好";
        }else if ("时间1".equals(content.trim())){
            BabyData babyData = MySQLDriver.queryIdBabyData(1);
            String creatime = babyData.getCreateTime();
            respText = creatime;
        }else if ("时间2".equals(content.trim())){
            BabyData babyData = MySQLDriver.queryIdBabyData(2);
            String creatime = babyData.getCreateTime();
            respText = creatime;
        } else{
            respText = "你发的命令无法识别";
        }
        return respText;
    }
}
