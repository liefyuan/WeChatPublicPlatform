package weixin;

import org.javaweixin.Button.*;
import org.javaweixin.pojo.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.util.CommonUtil;
import org.util.MenuUtil;

/**
 * 菜单管理器类
 * Created by yuanlifu on 2017/3/11.
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    /**
     * 定义菜单结构
     *
     * @return
     */
    private static Menu getMenu() {

/**        ClickButton btn11 = new ClickButton();
        btn11.setName("开源中国");
        btn11.setType("click");
        btn11.setKey("oschina");

        ClickButton btn12 = new ClickButton();
        btn12.setName("ITeye");
        btn12.setType("click");
        btn12.setKey("iteye");

        ViewButton btn13 = new ViewButton();
        btn13.setName("CocoaChina");
        btn13.setType("view");
        btn13.setUrl("http://www.iteye.com");

        ViewButton btn21 = new ViewButton();
        btn21.setName("淘宝");
        btn21.setType("view");
        btn21.setUrl("http://m.taobao.com");

        ViewButton btn22 = new ViewButton();
        btn22.setName("京东");
        btn22.setType("view");
        btn22.setUrl("http://m.jd.com");

        ViewButton btn23 = new ViewButton();
        btn23.setName("唯品会");
        btn23.setType("view");
        btn23.setUrl("http://m.vipshop.com");

        ViewButton btn24 = new ViewButton();
        btn24.setName("当当网");
        btn24.setType("view");
        btn24.setUrl("http://m.dangdang.com");

        ViewButton btn25 = new ViewButton();
        btn25.setName("苏宁易购");
        btn25.setType("view");
        btn25.setUrl("http://m.suning.com");

        ViewButton btn31 = new ViewButton();
        btn31.setName("多泡");
        btn31.setType("view");
        btn31.setUrl("http://www.duopao.com");

        ViewButton btn32 = new ViewButton();
        btn32.setName("一窝88");
        btn32.setType("view");
        btn32.setUrl("http://www.yi588.com");

        ViewButton btn21 = new ViewButton();
        btn21.setName("淘宝");
        btn21.setType("view");
        btn21.setUrl("http://m.taobao.com");

        ViewButton btn22 = new ViewButton();
        btn22.setName("京东");
        btn22.setType("view");
        btn22.setUrl("http://m.jd.com");

        ViewButton btn23 = new ViewButton();
        btn23.setName("唯品会");
        btn23.setType("view");
        btn23.setUrl("http://m.vipshop.com");

        ViewButton btn24 = new ViewButton();
        btn24.setName("当当网");
        btn24.setType("view");
        btn24.setUrl("http://m.dangdang.com");

        ViewButton btn25 = new ViewButton();
        btn25.setName("苏宁易购");
        btn25.setType("view");
        btn25.setUrl("http://m.suning.com");**/

        ClickButton btn21 = new ClickButton();
        btn21.setName("净化");
        btn21.setType("click");
        btn21.setKey("clearair");

        ClickButton btn22 = new ClickButton();
        btn22.setName("摇篮");
        btn22.setType("click");
        btn22.setKey("opencradle");

        ClickButton btn23 = new ClickButton();
        btn23.setName("慢慢地摇");
        btn23.setType("click");
        btn23.setKey("slowrock");

        ClickButton btn24 = new ClickButton();
        btn24.setName("快一点摇");
        btn24.setType("click");
        btn24.setKey("morerock");

        ClickButton btn25 = new ClickButton();
        btn25.setName("再快点摇");
        btn25.setType("click");
        btn25.setKey("quickrock");

//        ComplexButton mainBtn1 = new ComplexButton();
//        mainBtn1.setName("宝宝情况");
//        mainBtn1.setSub_button(new BaseButton[] { btn11, btn12, btn13 });

        ClickButton mainBtn1 = new ClickButton();
        mainBtn1.setName("查询现况");
        mainBtn1.setType("click");
        mainBtn1.setKey("checknow");

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("更多");
        mainBtn2.setSub_button(new BaseButton[] { btn21, btn22, btn23, btn24, btn25 });


//        ClickButton mainBtn2 = new ClickButton();
//        mainBtn2.setName("更多");
//        mainBtn2.setType("click");
//        mainBtn2.setKey("more");

//        ComplexButton mainBtn3 = new ComplexButton();
//        mainBtn3.setName("宝宝现况");
//        mainBtn3.setSub_button(new BaseButton[] { btn31, btn32 });

        ClickButton mainBtn3 = new ClickButton();
        mainBtn3.setName("现场情况");
        mainBtn3.setType("click");
        mainBtn3.setKey("checkimage");

        Menu menu = new Menu();
        menu.setButton(new BaseButton[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }

    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "wxb069b8c34faa4360";
        // 第三方用户唯一凭证密钥
        String appSecret = "c7beb862b1c1f04522f100bb46dccb22";

        // 调用接口获取凭证
        Token token = CommonUtil.getToken(appId, appSecret);

        if (null != token) {
            // 创建菜单
            boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());

            // 判断菜单创建结果
            if (result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败！");
        }
    }
}
