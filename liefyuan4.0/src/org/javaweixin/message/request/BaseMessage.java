package org.javaweixin.message.request;

/**
 * 消息基类（普通用户 -> 公众账号）
 * 把消息推送中定义的所有消息都有的字段提取出来，封装成一个基类
 * ，这些公有的字段包括：
 * request消息基类：ToUserName（开发者微信号）、FromUserName（发送方帐号，OPEN_ID）、CreateTime （消息的创建时间）、MsgType（消息类型）、MsgId（消息 ID）
 * respond消息基类：ToUserName（接收方帐号，用户的 OPEN_ID）、FromUserName（开发者的微 信号）、CreateTime（消息的创建时间）、MsgType（消息类型）、FuncFlag（消息的星 标标识）

 *  Created by yuanlifu on 2017/3/7.
 */
public class BaseMessage {
    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个 OpenID）
    private String FromUserName;
    //消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/image/location/link）
    private String MsgType;
    // 消息 id，64 位整型
    private long MsgId;

    //文本消息的内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    private String Content;

    public long getCreateTime() {
        return CreateTime;
    }

    public long getMsgId() {
        return MsgId;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public String getMsgType() {
        return MsgType;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
