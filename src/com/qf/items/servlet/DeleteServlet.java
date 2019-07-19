package com.qf.items.servlet;

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

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        DeleteServlet servlet = new DeleteServlet();
        int delete = servlet.delete(Integer.parseInt(id));
        /*
        if(rows>0){
    out.println("<script type='text/javascript'>alert('修改成功！');location.href = 'goodsQueryServlet';</script>");
}else{
    out.println("<script type='text/javascript'>alert('修改错误："+errMsg+"');history.back();</script>");
}
         */
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("utf-8");
        if (delete>0){
            out.println("<script type='text/javascript'>alert('修改成功！');location.href = 'indexServlet1';</script>");
        }else{
           // resp.sendRedirect("/indexServlet1");
            out.println("<script type='text/javascript'>alert('修改错误');history.back();</script>");
        }

    }

    private int delete(int id) {
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            conn = Jdbc.getConnection();
            String sql = "delete from goodsinfo where id=?";
            pra = conn.prepareStatement(sql);
            pra.setInt(1, id);
            int rows = pra.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.closeAll(conn, pra, rs);
        }
        return 0;

    }
}
