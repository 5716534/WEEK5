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

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        IndexServlet indexServlet = new IndexServlet();
        List<User> users = indexServlet.list();
        req.setAttribute("list",users);
        req.getRequestDispatcher("/jsp/indexxiangqing.jsp").forward(req,resp);
    }




    private List<User> list() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            // 1、获得连接对象
            conn = JdbcUtils.getConnection();
            // 2、创建语句集并执行sql语句lis
            String sql = "select * from users";
            pra = conn.prepareStatement(sql);
            //设置占位符的值
            // 执行sql语句返回结果集
            rs = pra.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLoginName(rs.getString("loginName"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeAll(conn, pra, rs);
        }
        return users;

    }
}
