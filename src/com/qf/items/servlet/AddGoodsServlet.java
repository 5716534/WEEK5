package com.qf.items.servlet;

import com.qf.items.DAO.GoodsDao;
import com.qf.items.domain.Goodsinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String goodsinfoName = req.getParameter("goodsinfoName");
        String goodsinfoPrice = req.getParameter("goodsinfoPrice");
        String goodsinfoDescription = req.getParameter("goodsinfoDescription");
        String goodsStock= req.getParameter("goodsStock");
        Goodsinfo goods = new Goodsinfo(null,goodsinfoName,goodsinfoPrice,
                goodsinfoDescription ,goodsStock);

        GoodsDao goodsDao = new GoodsDao();
        int row = goodsDao.addGoodsInfo(goods);
        resp.sendRedirect("/indexServlet1");

    }

}
