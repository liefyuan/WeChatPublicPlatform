package org.javaweixin.Button;

/**
 * click类型的菜单
 * Created by yuanlifu on 2017/3/11.
 */
public class ClickButton extends BaseButton {
    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
