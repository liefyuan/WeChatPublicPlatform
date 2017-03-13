package org.javaweixin.message.respond;

/**
 * 消息基类（公众账号 -> 普通用户）
 * 把消息推送中定义的所有消息都有的字段提取出来，封装成一个基类
 * ，这些公有的字段包括：
 * request消息基类：ToUserName（开发者微信号）、FromUserName（发送方帐号，OPEN_ID）、CreateTime （消息的创建时间）、MsgType（消息类型）、MsgId（消息 ID）
 * respond消息基类：ToUserName（接收方帐号，用户的 OPEN_ID）、FromUserName（开发者的微 信号）、CreateTime（消息的创建时间）、MsgType（消息类型）、FuncFlag（消息的星 标标识）
 *  Created by yuanlifu on 2017/3/7.
 */
public class BaseMessage {
    // 接收方帐号（收到的 OpenID）
     private String ToUserName;
    // 开发者微信号
     private String FromUserName;
    // 消息创建时间 （整型）
     private long CreateTime;
    // 消息类型（text/music/news）
     private String MsgType;
    // 位 0x0001 被标志时，星标刚收到的消息
     private int FuncFlag;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public int getFuncFlag() {
        return FuncFlag;
    }

    public void setFuncFlag(int funcFlag) {
        FuncFlag = funcFlag;
    }
}
