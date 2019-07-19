<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/17
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updateGoodsServlet" method="post">
    <input type="hidden" name="id" value="${good.id}" />
    <table border="1">
        <tr>
            <td>商品名</td>
            <td><input type="text" name="goodsinfoName" value="${good.goodsinfoName}" /></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="goodsinfoPrice" value="${good.goodsinfoPrice}" /></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><input type="text" name="goodsinfoDescription" value="${good.goodsinfoDescription}" /></td>
        </tr>
        <tr>
            <td>库存</td>
            <td><input type="text" name="goodsStock" value="${good.goodsStock}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="保存" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
