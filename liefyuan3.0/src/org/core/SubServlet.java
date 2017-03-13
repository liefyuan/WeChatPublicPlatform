package org.core;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 辅助请求类
 *
 * Created by yuanlifu on 2017/3/7.
 */
@WebServlet(name = "SubServlet")
public class SubServlet extends HttpServlet {

    int num = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String getValue = req.getAttribute("testValue").toString();
        // 要重定向的新位置
//        String forward = "http://www.liefyuan.top/weixin/2222";
//        resp.sendRedirect(forward);
//        req.getRequestDispatcher("/MainServlet").forward(req,resp);
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }
//
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
//        //req.getRequestDispatcher("/MainServlet").forward(req,res);
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String getValue = request.getAttribute("testValue").toString();
////        // 要重定向的新位置
////        String forward = "http://www.liefyuan.top/weixin/2222";
////        response.sendRedirect(forward);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String getValue = request.getAttribute("testValue").toString();
////        // 要重定向的新位置
////        String forward = "http://www.liefyuan.top/weixin/3333";
////        response.sendRedirect(forward);
//    }
}

