package org.javaweixin.message.request;

/**
 * 图片消息
 *
 * Created by yuanlifu on 2017/3/7.
 */
public class ImageMessage extends BaseMessage {
    //图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
