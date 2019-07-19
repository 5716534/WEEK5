package summary;

import org.junit.Test;

import java.sql.*;

public class JDBC1 {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "123456";

    @Test
    public void testConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(url, username, password);
            //为什么要输出connection
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSelect1() {
        Connection connection = null;
        Statement sta = null;
        ResultSet rs = null;

        try {
            Class.forName(DRIVER_CLASS);
            connection=DriverManager.getConnection(url,username,password);
            System.out.println(connection);
            sta=connection.createStatement();
////            String sql = "select stuNo,stuName,age from student";
//            String sql="insert into student values (4,'沈浪',12)";
//             sql="insert into student values (5,'姜离',55)";
//             sql="delete from student where stuNO =99";
//             sql="update student set stuName='花木兰' where stuNo=1";
////            rs=sta.executeQuery(sql);
////            while(rs.next()){
//            int rows = sta.executeUpdate(sql);
////                int stuNo=rs.getInt("stuNo");
////                String stuName=rs.getString("stuName");
////                int age = rs.getInt("age");
////                System.out.println("stuNo:"+stuNo+",stuName:"+stuName+",age:"+age);
//            System.out.println(rows);
            String loginName = "afdsaf";
            String password = "' or 1=1 or '";
            String sql = "select id,password,loginName ln from users where loginName='"
                    +loginName+"' AND PASSWORD='"+password+"'";

            rs = sta.executeQuery(sql);
            // 3.3、遍历结果集
            // rs.next()：用于判断是否有下一条记录，如果有就返回true，否则为false
            // 帐号和密码如果正确时只会返回1条或0条记录
            if(rs.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs!=null){
                    rs.close();
                }
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