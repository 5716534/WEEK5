package com.qf.items.servlet;

import com.qf.items.domain.User;
import com.qf.items.utils.Jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");



        //根据username password 从数据库中查找
        User login = login(username, password);

        if (login != null) {
            //获得会话才行
            req.getSession().setAttribute("userInfo",login);
//            System.out.println("login success");
            resp.sendRedirect("/indexServlet1");
        } else {
            System.out.println("login fail");
            //resp.sendRedirect("/itemsJsp/login.jsp");
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('登陆失败')</script>");

        }
    }

    private User login(String username, String password) {
        User user = null;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            // 1、获得连接对象
            conn = Jdbc.getConnection();
            // 2、创建语句集并执行sql语句
            String sql = "select * from user where username = ? and password = ?";
            pre = conn.prepareStatement(sql);
            //设置占位符的值
            pre.setString(1, username);
            pre.setString(2, password);
            // 执行sql语句返回结果集
            rs = pre.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.closeAll(conn, pre, rs);
        }
        return user;
    }


}
