<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/9
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="editServlet" method="post">
      <table border="1">
        <tr>
          <td>ID</td>
          <td>用户名</td>
          <td>密码</td>
          <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="u" varStatus="user">
          <tr>
            <td>${u.id}</td>
            <td>${u.loginName}</td>
            <td>${u.password}</td>
            <td>
              <input type="button" value="修改"
                     onclick="javascript:window.location.href='localDataServlet?id=' + ${u.id}"/>
              <input type="button" value="删除" onclick="checkDel(${u.id})"/>
            </td>
          </tr>
        </c:forEach>
      </table>
      <input type="button" value="新增"
             onclick="javascript:window.location.href='save.jsp'"/>
    </form>



  </body>


  <script type="text/javascript">
      function checkDel(ID){
          if(confirm("确定要删除吗？")){
              location.href = "deleteServlet?id=" + ID;
          }
      }
  </script>
</html>
