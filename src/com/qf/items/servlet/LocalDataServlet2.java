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

public class LocalDataServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        LocalDataServlet2 servlet = new LocalDataServlet2();
       Goodsinfo good =servlet.selectById(Integer.valueOf(id));
       if (good!=null){
           req.setAttribute("good",good);
           req.getRequestDispatcher("/itemsJsp/updateGoods.jsp").forward(req,resp);
       }else{
           System.out.println("失败");
       }
    }

    private Goodsinfo selectById(int id){
        Goodsinfo good = null;
        Connection conn =null;
        PreparedStatement pra = null;
        ResultSet rs=null;

        try {
            conn=Jdbc.getConnection();
            String sql = "select * from goodsinfo where id = ?";
            pra=conn.prepareStatement(sql);
            pra.setInt(1,id );
            rs=pra.executeQuery();
            while (rs.next()) {
                good = new Goodsinfo();
                good.setId(rs.getInt("id"));
                good.setGoodsinfoName(rs.getString("goodsinfo_name"));
                good.setGoodsinfoPrice(rs.getString("goodsinfo_price"));
                good.setGoodsinfoDescription(rs.getString("goodsinfo_description"));
                good.setGoodsStock(rs.getString("goods_stock"));
                return good;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.closeAll(conn,pra,rs);
        }
        return good;
    }
}
