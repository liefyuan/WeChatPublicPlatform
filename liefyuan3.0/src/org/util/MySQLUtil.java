package org.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 可以认为是本应用的数据库操作函数
 * 搭配mysql-connector-java-5.1.7-bin.jar是使用
 * 这个数据库是新浪云SAE上的，死贵
 *
 * Created by yuanlifu on 2017/3/11.
 */
public class MySQLUtil {

    /**
     * 获取MySQL连接
     * @return
     */
    public Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_liefyuan";
        String username = "3x242ww1mz";
        String password = "h3j0j52k15l1x34y1jk4kkk24z5304wh2kmz03l2";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("getConnection()");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放MySQL资源
     *
     * @param conn
     */
    public void releaseResource(Connection conn,PreparedStatement ps){
        try {
            if(null != ps)
                ps.close();
            System.out.println("ps.close()");
            if (null!= conn)
                conn.close();
            System.out.println("conn.close()");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存文本的功能性函数
     *
     * @param openId
     * @param content
     */
    public static void saveTextMessage(String openId,String content){
        MySQLUtil mysql = new MySQLUtil();
        Connection conn = mysql.getConnection();
        String sql = "insert into message_text(open_id,content,create_time) values(?,?,now())";
        PreparedStatement ps = null;
        System.out.println("saveTextMessage()");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,openId);
            ps.setString(2,content);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysql.releaseResource(conn,ps);
        }
    }
}
