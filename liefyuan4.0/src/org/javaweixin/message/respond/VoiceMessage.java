package org.javaweixin.message.respond;

/**
 * 语音消息
 *
 * Created by yuanlifu on 2017/3/8.
 */
public class VoiceMessage {
    // 语音
    private org.javaweixin.message.respond.Voice Voice;

    public org.javaweixin.message.respond.Voice getVoice() {
        return Voice;
    }

    public void setVoice(org.javaweixin.message.respond.Voice voice) {
        Voice = voice;
    }
}
