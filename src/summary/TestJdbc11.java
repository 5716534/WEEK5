package summary;

import org.junit.Test;

import java.sql.*;

public class TestJdbc11 {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "123456";

    @Test
    public void testConnection() {

        Connection conn = null;
        try {
            Class.forName("DRIVER_CLASS");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSelect1() {
        Connection conn = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(url, username, password);
//            String loginName = "jifooa";
//            String password="'or 1=1 or'";
//            String  sql = "select id,password,loginName from users where loginName=? AND password=?";
//            sta=conn.prepareStatement(sql);
//            sta.setString(1,loginName);
//            sta.setString(2,password);
//            rs=sta.executeQuery();
//            if (rs.next()) {
//                System.out.println("成功");
//
//            }else{
//                System.out.println("失败");
//            }
//        String sql = "insert into users (loginName,password)values(?,?)";
//        sta=conn.prepareStatement(sql);
//        sta.setString(1,"张飞");
//        sta.setInt(2,2222);
//          String sql = "delete from users where id =?";
//            String sql = "delete from users where id = ?";
//            sta  = conn.prepareStatement(sql);
//            sta.setInt(1, 5);
//          sta=conn.prepareStatement(sql);
//          sta.setInt(1,2);
            String sql = "update users set id=? where id =?";
            sta = conn.prepareStatement(sql);

//            String sql = "update users set password = ? where id = ? ";
           /* String sql = "insert into users(loginName,password) values(?,?)";
            sta = conn.prepareStatement(sql);
            sta.setString(1, "test1");
            sta.setString(2, "123");*/
//            sta.setString(1, "8888");
            sta.setString(1, "4");//为什么改不成功
            sta.setInt(2, 1);
            int rows = sta.executeUpdate();

            System.out.println(rows);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (sta != null) {
                    sta.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
