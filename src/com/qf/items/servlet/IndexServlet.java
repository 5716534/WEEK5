package com.qf.items.servlet;

import com.qf.items.domain.Goodsinfo;
import com.qf.items.utils.Jdbc;

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
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IndexServlet indexServlet = new IndexServlet();
        List<Goodsinfo> _list = indexServlet.list();
        req.setAttribute("list",_list);
        req.getRequestDispatcher("/itemsJsp/index.jsp").forward(req,resp);

    }

    private List<Goodsinfo> list() {

        List<Goodsinfo> goods = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;


        try {
            conn = Jdbc.getConnection();
            String sql = "select id,goodsinfo_name,goodsinfo_price from Goodsinfo";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Goodsinfo good = new Goodsinfo();
                good.setId(rs.getInt("id"));
                good.setGoodsinfoName(rs.getString("goodsinfo_name"));
                good.setGoodsinfoPrice(rs.getString("goodsinfo_price"));
                goods.add(good);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.closeAll(conn, pre, rs);
        }
        return goods;

    }
}
