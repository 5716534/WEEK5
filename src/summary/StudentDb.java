package summary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDb {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "123456";
    /**
     * 获得连接对象
     * @return
     */
    public Connection getConnection(){
        try {
            // 1、加载驱动
            Class.forName(DRIVER_CLASS);
            // 2、获得连接对象
//            Connection connection = DriverManager.getConnection(url, username, password);
//            return connection;
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    public Student findByStuNo(String age){
    public List<Student> findByStuNo(String age){
        Student stu = null;
        //声明3个类型
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        List<Student> stus = new ArrayList<>();
        try {
            // 1、获得连接对象
            conn = this.getConnection();
            // 2、创建语句集并执行sql语句
            String sql = "select * from Student where age = ?";
            pra = conn.prepareStatement(sql);
            //设置占位符的值
            pra.setString(1, age);
            // 执行sql语句返回结果集
            rs = pra.executeQuery();


            while(rs.next()){
                stu = new Student();
                stu.setStuNo(rs.getString("stuNo"));
                stu.setStuName(rs.getString("stuName"));
                stu.setAge(rs.getInt("age"));
//                return stu;//如何打印输出stu
                stus.add(stu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pra, rs);
        }
        return stus;
//        return stu;
    }

    private void closeAll(Connection conn, PreparedStatement pra, ResultSet rs) {

    }

    public static void main(String[] args) {
        StudentDb studentDb = new StudentDb();
//        Student byStuNo = studentDb.findByStuNo("99");

        Scanner scanner = new Scanner(System.in);
        System.out.println("system in age :");
        String next = scanner.next();
        List<Student> byStuNo = studentDb.findByStuNo(next);
        System.out.println(byStuNo);
    }
}

