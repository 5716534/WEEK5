package com.qf.hw.servlet;

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

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        DeleteServlet loginServlet = new DeleteServlet();
        int delete = loginServlet.delete(Integer.valueOf(id));
        if (delete > 0){
            System.out.println("delete success");
        }else {
            System.out.println("delete fail");
        }
        resp.sendRedirect("/IndexServlet");
    }

    private int delete(int id) {
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            // 1、获得连接对象
            conn = JdbcUtils.getConnection();
            // 2、创建语句集并执行sql语句
            String sql = "delete  from users where id = ?";
            pra = conn.prepareStatement(sql);
            //设置占位符的值id
            pra.setInt(1,id );
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
