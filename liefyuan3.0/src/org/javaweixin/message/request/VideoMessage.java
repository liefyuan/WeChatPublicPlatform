package org.javaweixin.message.request;

/**
 * 视频消息
 *
 * Created by yuanlifu on 2017/3/8.
 */
public class VideoMessage {
    // 视频消息媒体id
    private String MediaId;
    // 视频消息缩略图的媒体id
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
