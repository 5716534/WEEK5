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
    <title>save</title>
  </head>
  <body>

    <form action="saveServlet" method="post">
      <input type=hidden name="id" value="${user.id}">
      用户名：<input type="text" name="loginName" value="${user.loginName}"/><br/>
      密码：<input type="password" name="password" value="${user.password}"/><br/>
      <input type="submit" value="保存"/>
      <input type="reset" value="重置"/>
    </form>
  </body>

</html>
