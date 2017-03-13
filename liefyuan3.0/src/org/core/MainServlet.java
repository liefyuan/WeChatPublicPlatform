package org.core;

import org.javaweixin.CoreService.CoreService;
import org.util.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yuanlifu on 2017/3/11.
 */
@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 444333222111000L;

    private static HttpServletRequest request;
    private static HttpServletResponse response;
    /**
     * doGet这个方法是为了确认请求来自微信服务器
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doSignUtil(request,response);
    }

    /**
     * 为了让doGet函数完成更多的任务
     * 这里是完成验证
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private static void doSignUtil(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        //微信加密签名
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        //通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature,timestamp,nonce)){
            out.print(echostr);
        }
    }
    /**
     * 处理微信服务器发来的消息
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 将请求、响应的编码均设置为 UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doWeiXin(request,response);//处理微信的发来的消息
    }

    /**
     * 为了让doPost处理更多的事情
     * 这里是专门处理微信服务器传来的消息的函数
     *
     * @param request
     * @param response
     */
    private static void doWeiXin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        // 调用核心业务类接收消息、处理消息
        String respMessage = CoreService.processRequest(request,response);
        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
    }
}
