package com.qf.items.servlet;

import com.qf.items.DAO.GoodsDao;
import com.qf.items.domain.Goodsinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errmsg = "";
        int rows = 0;

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String goodsinfoName = req.getParameter("goodsinfoName");
            String goodsinfoPrice = req.getParameter("goodsinfoPrice");
            String goodsinfoDescription = req.getParameter("goodsinfoDescription");
            String goodsStock = req.getParameter("goodsStock");
            if (goodsinfoName == null || "".equals(goodsinfoName)) {
                throw new RuntimeException("商品名不能为空");
            }

            Goodsinfo good = new Goodsinfo(id, goodsinfoName, goodsinfoPrice, goodsinfoDescription, goodsStock);
            GoodsDao goodsDao = new GoodsDao();
            rows = goodsDao.updateGoodsInfo(good);

        } catch (Exception e) {
            e.printStackTrace();
            errmsg = e.getMessage();
        }
//        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (rows > 0) {
            out.println("<script type='text/javascript'>alert('修改成功');location.href='indexServlet1';</script>");
        } else {
            out.println("<script type='text/javascript'>alert('修改失败：" + errmsg + "');history.back();</script>");
        }
    }
}