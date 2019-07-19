package day22;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/test1?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username="root";
    private static final String password="123456";
    @Test
    public void testConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection=DriverManager.getConnection(url,username,password);
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
