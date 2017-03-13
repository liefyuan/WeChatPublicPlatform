package org.javaweixin.pojo;

/**
 * 凭证
 *
 * Created by yuanlifu on 2017/3/11.
 */
public class Token {
    // 接口访问凭证
    private String accessToken = "QyhjLePPKNq5qkJVcqjBaMr07V_WaI0xRE1cYPfw_T1qAhI0AjNWcylqd0Ji1xZ-re5q5Ux7gEhfioTI4D7EnT4KbAeu1DLvpDUmPdm7qYI3xHqXQNMFGV0kN4ItuHa9WVOhABAEDW";
    // 凭证有效期，单位：秒
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
