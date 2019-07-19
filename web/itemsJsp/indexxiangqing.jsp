<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/15
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情列表</title>
</head>
<body>
    <form action="#" method="post">
       <table border="1">
           <caption>商品详情</caption>
           <tr>
               <th>ID</th>
               <th>商品名</th>
               <th>商品价格</th>
               <th>商品描述</th>
               <th>商品库存</th>
               <th>操作</th>
           </tr>
           <tr>
               <td>${goods.id}</td>
               <td>${goods.goodsinfoName}</td>
               <td>${goods.goodsinfoPrice}</td>
               <td>${goods.goodsinfoDescription}</td>
               <td>${goods.goodsStock}</td>
               <td>
                   <input type="button" value="修改"
                          onclick="onUpdateUrl('${goods.id}')"/>
                   <input type="button" value="删除"
                          onclick="checkDel(${goods.id})"/>
               </td>
           </tr>
       </table>
    </form>
</body>
    <script type="text/javascript">
        function checkDel(ID){
            location.href = "/deleteServlet1?id=" + ID;
    }

        function onUpdateUrl(ID) {
            window.location.href = "/localDataServlet2?id="+ID;
        }
    </script>
</html>
