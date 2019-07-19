package com.qf.items.DAO;


import com.qf.items.domain.Goodsinfo;
import com.qf.items.domain.User;
import com.qf.items.utils.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {

    public int add(User user){

        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try {
            // 1、获得连接对象
            conn = Jdbc.getConnection();
            String sql = "insert into user (username,password, " +
                    "sex,hobby,phone,email,addrs) values (?,?,?,?,?,?,?)";
            pra = conn.prepareStatement(sql);
            //设置占位符的值id
            pra.setString(1,user.getUsername());
            pra.setString(2,user.getPassword());
            pra.setString(3,user.getSex());
            pra.setString(4,user.getHobby());
            pra.setString(5,user.getPhone());
            pra.setString(6,user.getEmail());
            pra.setString(7,user.getAddrs());

//            }
            // 执行sql语句返回结果集
            return pra.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.closeAll(conn, pra, rs);
        }
        return 0;
    }
}
