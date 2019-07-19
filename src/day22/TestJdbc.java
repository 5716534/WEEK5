package day22;
import org.junit.Test;

import java.sql.*;

public class TestJdbc {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "123456";

    @Test
    public void testConnection(){
        Connection connection=null;
        try {
            // 1、加载驱动
            Class.forName(DRIVER_CLASS);

            // 2、获得连接对象

            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testSelect1(){
        Connection connection=null;
        Statement sta=null;
        ResultSet rs = null;
        try {
            // 1、加载驱动
            Class.forName(DRIVER_CLASS);

            // 2、获得连接对象

            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);

            // 3、获得语句集并执行操作
            // 3.1 创建语句集

            sta = connection.createStatement();
            // 3.2、执行sql语句
            // 只看查询
            String sql = "select id,password,loginName ln from users";

            rs = sta.executeQuery(sql);
            // 3.3、遍历结果集
            // rs.next()：用于判断是否有下一条记录，如果有就返回true，否则为false
            while(rs.next()){
                // id int==>java int
                // loginName varchar==>java String
                // 第一种：rs.getXxx(int index)：index从1开始取值
//                int id = rs.getInt(1);
//                String loginName = rs.getString(2);
                // 第二种：rs.getXxx(String columnLable)：根据列名或别名取值
                // 推荐用第二种
                int id = rs.getInt("id");
////                String loginName = rs.getString("loginName");
//                // sql中的列名加了别名，获取时要用别名
                String loginName = rs.getString("ln");
                String password = rs.getString("password");

                System.out.println("id:"+id+",loginName:"+loginName+",password:"+password);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭资源
            // 关闭规则：从里向外关
            try {
                // 查询有结果集
                if(rs!=null){
                    rs.close();
                }
                // 查询和更新都要关闭
                if(sta!=null){
                    sta.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
