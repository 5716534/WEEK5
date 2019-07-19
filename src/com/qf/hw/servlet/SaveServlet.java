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
import java.util.ArrayList;
import java.util.List;

public class SaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        User user = new User();
        if (id != null && ! "".equals(id )){
            user.setId(Integer.valueOf(id));
        }
        user.setLoginName(loginName);
        user.setPassword(password);
        SaveServlet servlet = new SaveServlet();
        int add = servlet.add(user);
        if (add >0){
            System.out.println("add success");
            resp.sendRedirect("/IndexServlet");
        }else {
            System.out.println("add fail");
            resp.sendRedirect("/jsp/save.jsp");
        }
    }




    private int add(User user) {
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            // 1、获得连接对象
            conn = JdbcUtils.getConnection();
            // 2、创建语句集并执行sql语句

            if (user.getId() != null && user.getId() > 0){
                String sql = "update  users set loginName = ?,password = ? where id = ?";
                pra = conn.prepareStatement(sql);
                //设置占位符的值id
                pra.setString(1,user.getLoginName());
                pra.setString(2,user.getPassword());
                pra.setInt(3,user.getId());
            }else {
                String sql = "insert into users (loginName,password) values (?,?)";
                pra = conn.prepareStatement(sql);
                //设置占位符的值id
                pra.setString(1,user.getLoginName());
                pra.setString(2,user.getPassword());
            }
            // 执行sql语句返回结果集
            return pra.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(conn, pra, rs);
        }
        return 0;

    }
}
