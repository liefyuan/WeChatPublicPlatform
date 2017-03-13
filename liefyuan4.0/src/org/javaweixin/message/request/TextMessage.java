package org.javaweixin.message.request;

/**
 * 文本消息
 *
 * Created by yuanlifu on 2017/3/7.
 */
public class TextMessage extends BaseMessage {
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
