package org.javaweixin.Button;

/**
 * view 类型的菜单
 * Created by yuanlifu on 2017/3/11.
 */
public class ViewButton extends BaseButton {
    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
