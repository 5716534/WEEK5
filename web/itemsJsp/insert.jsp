<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/16
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>insert</title>
<body>
    <form action="/addGoodsServlet" method="post">
        <input type=hidden name="id" value="${good.id}"/><br/>
        商品名：<input type="text" name="goodsinfoName" value="${good.goodsinfoName}" /><br/>
        商品价格：<input type="text" name="goodsinfoPrice" value="${good.goodsinfoPrice}" /><br/>
        商品描述：<input type="text" name="goodsinfoDescription" value="${good.goodsinfoDescription}"/><br/>
        商品库存：<input type="text" name="goodsStock"  value="${good.goodsStock}"/><br/>
        <input type="submit" value="保存"/>
        <input type="reset" value="重置"/>
    </form>
</body>
</head>
</html>
