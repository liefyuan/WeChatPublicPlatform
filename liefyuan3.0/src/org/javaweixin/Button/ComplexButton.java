package org.javaweixin.Button;

/**
 * 复合类型的菜单，就是该菜单里有子菜单的菜单
 *
 * Created by yuanlifu on 2017/3/11.
 */
public class ComplexButton extends BaseButton {
    private BaseButton[] sub_button;

    public BaseButton[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(BaseButton[] sub_button) {
        this.sub_button = sub_button;
    }
}
