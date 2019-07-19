package summary;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Ivy Li
 * @create 2019-07-08
 */
public class TestJdbc {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test1?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "123456";

    @Test
    public void testConnection(){
        Connection connection = null;
        try {
            // 1、加载驱动
            Class.forName(DRIVER_CLASS);

            // 2、获得连接对象
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);//返回内存地址
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // 4、关闭资源
            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}