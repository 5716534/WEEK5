package com.qf.items.DAO;;
import com.qf.items.domain.Goodsinfo;
import com.qf.items.utils.Jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/xiangmu1?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "123456";

    // 获得连接对象
    public Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public void closeAll(Connection conn, PreparedStatement sta, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (sta != null) sta.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Goodsinfo findById(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pra = null;

        try {
            // 1、获得连接对象
            conn = this.getConnection();
            // 2、获得预编译语句集并执行SQL语句
            String sql = "select * from goodsinfo where id = ?";
            // 2.1 获得预编译语句集
            pra = conn.prepareStatement(sql);
            // 2.2 设置占位符的值
            pra.setInt(1, id);
            // 2.3 执行sql语句
            rs = pra.executeQuery();//不要传入sql
            // 2.4 遍历结果集
            // 根据主键查询，所以只会有0或1条记录
            if (rs.next()) {
                Goodsinfo good = new Goodsinfo();
                good.setId(rs.getInt("id"));
                good.setGoodsinfoName(rs.getString("goodsinfoName"));
                good.setGoodsinfoPrice(rs.getString("goodsinfoPrice"));
                good.setGoodsinfoDescription(rs.getString("goodsinfoDescription"));
                good.setGoodsStock(rs.getString("goodsStock"));
                return good;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 3、关闭资源
            this.closeAll(conn, pra, rs);
        }
        return null;
    }

    public int updateGoodsInfo(Goodsinfo good) {

        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            // 1、获得连接对象
            conn = Jdbc.getConnection();

            // 2、创建语句集
            StringBuffer sf = new StringBuffer();
            sf.append(" update goodsinfo set ");
            sf.append("    goodsinfo_name = ? ");
            sf.append("    ,goodsinfo_price = ? ");
            sf.append("    ,goodsinfo_description = ? ");
            sf.append("    ,goods_stock = ? ");
            sf.append(" where id = ? ");
            List<Object> paramList = new ArrayList<>();
            paramList.add(good.getGoodsinfoName());
            paramList.add(good.getGoodsinfoPrice());
            paramList.add(good.getGoodsinfoDescription());
            paramList.add(good.getGoodsStock());
            paramList.add(good.getId());
            pra = conn.prepareStatement(sf.toString());
            // 设置占位符的值
            if (paramList != null && paramList.size() > 0) {
                for (int i = 0; i < paramList.size(); i++) {
                    pra.setObject(i + 1, paramList.get(i));
                }
            }
            // 执行sql并获得受影响的行数
            int rows = pra.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pra, rs);
        }
        return 0;
    }

    public int addGoodsInfo(Goodsinfo good) {
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try {
            // 1、获得连接对象
            conn = Jdbc.getConnection();
            String sql = "insert into goodsinfo (goodsinfo_name,goodsinfo_price, " +
                    "goodsinfo_description,goods_stock) values (?,?,?,?)";
            pra = conn.prepareStatement(sql);
            //设置占位符的值id
            pra.setString(1,good.getGoodsinfoName());
            pra.setString(2,good.getGoodsinfoPrice());
            pra.setString(3,good.getGoodsinfoDescription());
            pra.setString(4,good.getGoodsStock());
//            }
            // 执行sql语句返回结果集
            return pra.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.closeAll(conn, pra, rs);
        }
        return 0;
    }
}



