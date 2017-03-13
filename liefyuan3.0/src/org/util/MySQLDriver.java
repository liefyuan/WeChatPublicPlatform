package org.util;

import org.javaweixin.message.Data.BabyData;

import java.sql.*;

/**
 * 这个数据库链接是我自己的在阿里云服务器上的MySQL数据库
 *
 * Created by yuanlifu on 2017/3/12.
 */
public class MySQLDriver {

    /**
     * 获取MySQL连接
     * @return
     */
    public Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://www.liefyuan.top:3306/app_liefyuan";
        String username = "admin";
        String password = "134155";
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
     * 保存数据的功能性函数
     * @param babyId 标号
     * @param babyTemp 体温
     * @param checkBabyTemp 体温标记
     * @param envirTemp 室温
     * @param checkEnirTemp 室温标记
     * @param envirHum 室湿度
     * @param checkEnvirHum 室湿度标记
     * @param babyWeight 体重
     * @param checkBabyWeight 体重标记
     * @param envirAir 空气质量
     * @param checkEnvirAir 空气质量标记
     * @param babyWater 尿床
     * @param checkBabyWater 尿床标记
     */
    public static void saveBabyData(String babyId,String babyTemp,
                                       String checkBabyTemp,String envirTemp,
                                       String checkEnirTemp, String envirHum,
                                       String checkEnvirHum,String babyWeight,
                                       String checkBabyWeight,String envirAir,
                                       String checkEnvirAir, String babyWater,
                                       String checkBabyWater){
        MySQLDriver mysql = new MySQLDriver();
        Connection conn = mysql.getConnection();
        //String sql = "insert into message_text(open_id,content,create_time) values(?,?,now())";
        String sql = "insert into babyData(babyId,babyTemp,checkBabyTemp,\n" +
                "\tenvirTemp,checkEnirTemp,envirHum,checkEnvirHum,babyWeight,checkBabyWeight,\n" +
                "\tenvirAir,checkEnvirAir,babyWater,checkBabyWater,createTime) \n" +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
        PreparedStatement ps = null;
        System.out.println("saveTextMessage()");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,babyId);
            ps.setString(2,babyTemp);
            ps.setString(3,checkBabyTemp);
            ps.setString(4,envirTemp);
            ps.setString(5,checkEnirTemp);
            ps.setString(6,envirHum);
            ps.setString(7,checkEnvirHum);
            ps.setString(8,babyWeight);
            ps.setString(9,checkBabyWeight);
            ps.setString(10,envirAir);
            ps.setString(11,checkEnvirAir);
            ps.setString(12,babyWater);
            ps.setString(13,checkBabyWater);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysql.releaseResource(conn,ps);
        }
    }

 /**   public static List<HashMap<String, Object>> queryBabyData(){
        List<HashMap<String, Object>> babyDataList = new ArrayList<HashMap<String, Object>>();

        MySQLDriver mysql = new MySQLDriver();
        Connection conn = mysql.getConnection();
        String sql = "select * from babyData";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                HashMap<String, Object> babyDataMap = new HashMap<String, Object>();
                babyDataMap.put("id",rs.getInt("id"));
                babyDataMap.put("babyId",rs.getString("babyId"));
                babyDataMap.put("babyTemp",rs.getString("babyTemp"));
                babyDataMap.put("checkBabyTemp",rs.getString("checkBabyTemp"));
                babyDataMap.put("envirTemp",rs.getString("envirTemp"));
                babyDataMap.put("checkEnirTemp",rs.getString("checkEnirTemp"));
                babyDataMap.put("envirHum",rs.getString("envirHum"));
                babyDataMap.put("checkEnvirHum",rs.getString("checkEnvirHum"));
                babyDataMap.put("babyWeight",rs.getString("babyWeight"));
                babyDataMap.put("checkBabyWeight",rs.getString("checkBabyWeight"));
                babyDataMap.put("envirAir",rs.getString("envirAir"));
                babyDataMap.put("checkEnvirAir",rs.getString("checkEnvirAir"));
                babyDataMap.put("babyWater",rs.getString("babyWater"));
                babyDataMap.put("checkBabyWater",rs.getString("checkBabyWater"));
                babyDataMap.put("createTime",rs.getString("createTime"));
                babyDataList.add(babyDataMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysql.releaseResource(conn,ps);
        }
        return babyDataList;
    }

    public static HashMap<String, Object> queryBabyData2(){
        HashMap<String, Object> babyDataMap = new HashMap<String, Object>();

        MySQLDriver mysql = new MySQLDriver();
        Connection conn = mysql.getConnection();
        String sql = "select * from babyData";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                babyDataMap.put("id",rs.getInt("id"));
                babyDataMap.put("babyId",rs.getString("babyId"));
                babyDataMap.put("babyTemp",rs.getString("babyTemp"));
                babyDataMap.put("checkBabyTemp",rs.getString("checkBabyTemp"));
                babyDataMap.put("envirTemp",rs.getString("envirTemp"));
                babyDataMap.put("checkEnirTemp",rs.getString("checkEnirTemp"));
                babyDataMap.put("envirHum",rs.getString("envirHum"));
                babyDataMap.put("checkEnvirHum",rs.getString("checkEnvirHum"));
                babyDataMap.put("babyWeight",rs.getString("babyWeight"));
                babyDataMap.put("checkBabyWeight",rs.getString("checkBabyWeight"));
                babyDataMap.put("envirAir",rs.getString("envirAir"));
                babyDataMap.put("checkEnvirAir",rs.getString("checkEnvirAir"));
                babyDataMap.put("babyWater",rs.getString("babyWater"));
                babyDataMap.put("checkBabyWater",rs.getString("checkBabyWater"));
                babyDataMap.put("createTime",rs.getString("createTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysql.releaseResource(conn,ps);
        }
        return babyDataMap;
    }**/

    /**
     * 根据id读取数据库的指定信息
     * @param id 数据库自加的id号
     * @return
     */
    public static BabyData queryIdBabyData(int id){
        BabyData babyData = null;
        MySQLDriver mysql = new MySQLDriver();
        Connection conn = mysql.getConnection();
        String sql = "select id,babyId,babyTemp,checkBabyTemp,\n" +
                "\tenvirTemp,checkEnirTemp,envirHum,checkEnvirHum,babyWeight,checkBabyWeight,\n" +
                "\tenvirAir,checkEnvirAir,babyWater,checkBabyWater,createTime from babyData where id=? ";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                babyData = new BabyData();
                babyData.setId(rs.getInt("id"));
                babyData.setBabyId(rs.getString("babyId"));
                babyData.setBabyTemp(rs.getString("babyTemp"));
                babyData.setCheckBabyTemp(rs.getString("checkBabyTemp"));
                babyData.setEnvirTemp(rs.getString("envirTemp"));
                babyData.setCheckEnirTemp(rs.getString("checkEnirTemp"));
                babyData.setEnvirHum(rs.getString("envirHum"));
                babyData.setCheckEnvirHum(rs.getString("checkEnvirHum"));
                babyData.setBabyWeight(rs.getString("babyWeight"));
                babyData.setCheckBabyWeight(rs.getString("checkBabyWeight"));
                babyData.setEnvirAir(rs.getString("envirAir"));
                babyData.setCheckEnvirAir(rs.getString("checkEnvirAir"));
                babyData.setBabyWater(rs.getString("babyWater"));
                babyData.setCheckBabyWater(rs.getString("checkBabyWater"));
                babyData.setCreateTime(rs.getString("createTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysql.releaseResource(conn,ps);
        }
        return babyData;
    }

    /**
     * 根据babyId来寻找
     * @param babyId 设置的babyId
     * @return
     */
    public static BabyData querybabyIdBabyData(String babyId){
        BabyData babyData = null;
        MySQLDriver mysql = new MySQLDriver();
        Connection conn = mysql.getConnection();
        String sql = "select id,babyId,babyTemp,checkBabyTemp,\n" +
                "\tenvirTemp,checkEnirTemp,envirHum,checkEnvirHum,babyWeight,checkBabyWeight,\n" +
                "\tenvirAir,checkEnvirAir,babyWater,checkBabyWater,createTime from babyData where babyId=? ";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, babyId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                babyData = new BabyData();
                babyData.setId(rs.getInt("id"));
                babyData.setBabyId(rs.getString("babyId"));
                babyData.setBabyTemp(rs.getString("babyTemp"));
                babyData.setCheckBabyTemp(rs.getString("checkBabyTemp"));
                babyData.setEnvirTemp(rs.getString("envirTemp"));
                babyData.setCheckEnirTemp(rs.getString("checkEnirTemp"));
                babyData.setEnvirHum(rs.getString("envirHum"));
                babyData.setCheckEnvirHum(rs.getString("checkEnvirHum"));
                babyData.setBabyWeight(rs.getString("babyWeight"));
                babyData.setCheckBabyWeight(rs.getString("checkBabyWeight"));
                babyData.setEnvirAir(rs.getString("envirAir"));
                babyData.setCheckEnvirAir(rs.getString("checkEnvirAir"));
                babyData.setBabyWater(rs.getString("babyWater"));
                babyData.setCheckBabyWater(rs.getString("checkBabyWater"));
                babyData.setCreateTime(rs.getString("createTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysql.releaseResource(conn,ps);
        }
        return babyData;
    }
}
