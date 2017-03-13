package org.javaweixin.message.respond;

/**
 * 音乐消息
 * 配合music模块使用
 * Created by yuanlifu on 2017/3/7.
 */
public class MusicMessage extends BaseMessage {
    //音乐
    private Music Music;

    public org.javaweixin.message.respond.Music getMusic() {
        return Music;
    }

    public void setMusic(org.javaweixin.message.respond.Music music) {
        Music = music;
    }
}

