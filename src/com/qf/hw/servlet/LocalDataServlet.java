package com.qf.hw.servlet;

import com.qf.hw.domain.User;
import com.qf.hw.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        LocalDataServlet loginServlet = new LocalDataServlet();
        User user = loginServlet.selectById(Integer.valueOf(id));
        if (user != null){
            System.out.println("localData success");
            req.setAttribute("User",user);
            req.getRequestDispatcher("/jsp/save.jsp").forward(req,resp);
        }else {
            System.out.println("localData fail");
        }
    }

    private User selectById(int id) {
        User user = null;
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            // 1、获得连接对象
            conn = JdbcUtils.getConnection();
            // 2、创建语句集并执行sql语句
            String sql = "select * from users where id = ?";
            pra = conn.prepareStatement(sql);
            //设置占位符的值id
            pra.setInt(1,id );
            rs = pra.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setLoginName(rs.getString("loginName"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            // 执行sql语句返回结果集
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(conn, pra, rs);
        }
        return user;

    }


}
