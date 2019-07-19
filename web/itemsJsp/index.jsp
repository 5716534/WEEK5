<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/16
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>

<input type="button" value="新增"
       onclick="javascript:window.location.href='/itemsJsp/insert.jsp'"/>
<table border="1">
        <caption>商品列表</caption>
        <tr>
            <td>ID</td>
            <td>商品名</td>
            <td>商品价格</td>
            <th>操作</th>
        </tr>

        <c:forEach items="${list}" var="goods">
            <tr>
                <td>${goods.id}</td>
                <td>${goods.goodsinfoName}</td>
                <td>${goods.goodsinfoPrice}</td>
            <td>
                <input type="button" value="删除"
                       onclick="checkDel(${goods.id})"/>
                <input type="button" value="详情"
                       onclick="javascript:window.location.href='/localDataServlet1?id='+${goods.id}"/>
            </td>
            </tr>
        </c:forEach>
    </table>
</body>
    <script type="text/javascript">
        function checkDel(ID){
            if(confirm("确定要删除吗？")){
                location.href = "/deleteServlet1?id=" + ID;
            }
         }

    </script>
</html>
