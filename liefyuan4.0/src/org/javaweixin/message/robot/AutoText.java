package org.javaweixin.message.robot;

/**
 *  自定义文本自动回复
 *
 * Created by yuanlifu on 2017/3/8.
 */
public class AutoText {

    public static String autoRespond(String content)  {
        String respText = "";
        if ("hello".equals(content.trim())){
            respText = "hello";
        }else if ("你好".equals(content.trim())){
            respText = "你好";
        }else{
            respText = "你发的命令无法识别";
        }
        return respText;
    }
}
