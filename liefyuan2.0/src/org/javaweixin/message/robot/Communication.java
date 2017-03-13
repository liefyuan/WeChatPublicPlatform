package org.javaweixin.message.robot;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yuanlifu on 2017/3/8.
 */
public class Communication extends HttpServlet {

    protected void sendPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("http://www.liefyuan.top/999");
    }
}
