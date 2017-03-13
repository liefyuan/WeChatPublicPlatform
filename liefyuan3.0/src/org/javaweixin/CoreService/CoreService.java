package org.javaweixin.CoreService;

import org.javaweixin.message.respond.TextMessage;
import org.javaweixin.message.robot.AutoText;
import org.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * 核心服务类
 *
 * Created by yuanlifu on 2017/3/8.
 */
public class CoreService {
    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return xml
     */
    public static String processRequest(HttpServletRequest request, HttpServletResponse response) {
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            //消息的内容
            String msgContent = requestMap.get("Content");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                //System.out.println("文本消息");
               // respContent = "你发的信息是："+msgContent;
                //MySQLDriver.saveBabyData("efg54321","37.5","0","22","0","55","0","10","0","12","0","23","0");
                respContent = AutoText.autoRespond(msgContent);//自动回复文本
//                respContent = "您发送的是文本消息！";
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                System.out.println("图片消息");
                respContent = "您发送的是图片消息！";
            }
            // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                System.out.println("地理位置消息");
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 关注
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！";
                }
                // 取消关注
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    //取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                }
                // 扫描带参数二维码
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // 处理扫描带参数二维码事件
                }
                // 上报地理位置
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    //处理上报地理位置事件
                }
                // 自定义菜单
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // 处理菜单点击事件
                    //事件KEY值，与创建菜单时的key值对应
                    String eventKey = requestMap.get("EventKey");
                    //根据key值判断用户点击的按钮
                    if (eventKey.equals("checknow")){
                       respContent = "你点击了查询现况";
                    } else if (eventKey.equals("checkimage")) {
                        respContent = "你点击了现场情况";
                    }else if (eventKey.equals("clearair")) {
                        respContent = "你点击了净化";
                    }else if (eventKey.equals("opencradle")) {
                        respContent = "你点击了摇篮";
                    }else if (eventKey.equals("slowrock")) {
                        respContent = "你点击了慢慢地摇";
                    }else if (eventKey.equals("morerock")) {
                        respContent = "你点击了快一点摇";
                    }else if (eventKey.equals("quickrock")) {
                        respContent = "你点击了再快点摇";
                    }
                }
            }
            // 设置文本消息的内容
            textMessage.setContent(respContent);
            // 将文本消息对象转换成xml
            respXml = MessageUtil.messageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }
}
