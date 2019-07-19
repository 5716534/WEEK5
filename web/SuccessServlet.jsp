<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/11
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>用户名</td>
            <td>${UserInfo.username}</td>
        </tr>
        <tr>
            <td>密码</td>
            <td>${UserInfo.password}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${UserInfo.sex}</td>
        </tr>
        <tr>
            <td>兴趣爱好</td>
           <td> <c:forEach items="${UserInfo.hobby}" var="user">
            ${user}
            </c:forEach></td>
        </tr>
    </table>

</body>
</html>
