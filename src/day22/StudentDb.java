package day22;

import java.sql.*;

public class StudentDb {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "123456";

    public Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void closeAll(Connection conn, Statement sta, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (sta != null)
                sta.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public Student findByStuNo(int stuNo) {
        Student stu = null;
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            // 1、获得连接对象
            conn = this.getConnection();
            // 2、创建语句集并执行sql语句
            String sql = "select * from student where stuNo = ?";
            pra = conn.prepareStatement(sql);
            //设置占位符的值
            pra.setInt(1, stuNo);
            // 执行sql语句返回结果集
            rs = pra.executeQuery();
            while(rs.next()){
                stu = new Student();
                stu.setStuNo(rs.getInt("stuNo"));
                stu.setStuName(rs.getString("stuName"));
                stu.setAge(rs.getInt("age"));
                return stu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pra, rs);
        }
        return stu;

    }
}
