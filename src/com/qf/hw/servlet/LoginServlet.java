package com.qf.hw.servlet;

import com.qf.hw.domain.User;
import com.qf.hw.util.JdbcUtils;


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
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginServlet loginServlet = new LoginServlet();

        //根据username password 从数据库中查找
        User login = loginServlet.login(username, password);
        PrintWriter out = resp.getWriter();
        if (login != null){
            System.out.println("login success");
            resp.sendRedirect("/IndexServlet");
        }else {
            out.println("<script type='text/javascript'>alert('登陆失败')</script>");
 //           resp.sendRedirect("jsp/fail.jsp");
        }

    }



    private User login(String loginName, String password) {
        User user = null;
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            // 1、获得连接对象
            conn = JdbcUtils.getConnection();
            // 2、创建语句集并执行sql语句
            String sql = "select * from users where loginName = ? and password = ?";
            pra = conn.prepareStatement(sql);
            //设置占位符的值
            pra.setString(1, loginName);
            pra.setString(2, password);
            // 执行sql语句返回结果集
            rs = pra.executeQuery();
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setLoginName(rs.getString("loginName"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(conn, pra, rs);
        }
        return user;
    }

}
