/*package com.qf.homework.servlet;

import com.qf.homework.domain.User;
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

public class LogonServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        LogonServlet1 logonServlet1 = new LogonServlet1();
        logonServlet1.
    }




    private User login(String loginName,String password){
        User User =null;
        Connection conn=null;
        PreparedStatement pra =null;
        ResultSet rs=null;


        try {
            conn=JdbcUtils.getConnection();
            String sql ="select*from users where loginName=? and password=?";
            pra = conn.prepareStatement(sql);
            pra.setString(1,loginName);
            pra.setString(2,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }


    }
}*/
