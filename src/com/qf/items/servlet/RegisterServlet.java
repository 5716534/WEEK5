package com.qf.items.servlet;


import com.qf.hw.util.JdbcUtils;
import com.qf.items.DAO.UsersDao;
import com.qf.items.domain.User;
import com.qf.items.utils.Jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String hobby = req.getParameter("hobby");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String addrs = req.getParameter("addrs");
        User user = new User(null,username,password,sex,
                hobby,addrs,email,phone);
        if (username != null && !"".equals(username)
                && password != null && !"".equals(password)) {
            user.setUsername(username);
            user.setPassword(password);
            user.setSex(sex);
            user.setHobby(hobby);
            user.setAddrs(addrs);
            user.setEmail(email);
            UsersDao usersDao = new UsersDao();
            int row = usersDao.add(user);
            resp.setContentType("text/html;charset=utf-8");
            //int row = goodsDao.addGoodsInfo(goods);
            PrintWriter out = resp.getWriter();
            if (row > 0) {
                out.println("<script type='text/javascript'>alert('注册成功');location.href='itemsJsp/login.jsp';</script>");
            } else {
                out.println("<script type='text/javascript'>alert('注册失败');history.back();</script>");
            }
        }
    }
}