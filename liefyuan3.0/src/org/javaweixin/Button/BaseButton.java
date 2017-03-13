package org.javaweixin.Button;

/**
 * 菜单的基类
 * 这些菜单都是通过分析，微信提供的那个Json格式的菜单文本得到的
 *
 * Created by yuanlifu on 2017/3/11.
 */
public class BaseButton {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
