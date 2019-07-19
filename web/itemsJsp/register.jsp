<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/15
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
${msg}<br/>
<form action="/registerServlet" method="post">
    <caption>注册页面</caption>
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    电话：<input type="text" name="phone"/><br/>
    email：<input type="text" name="email"/><br/>
    地址：<input type="text" name="addrs"/><br/>
    兴趣爱好：<input type="text" name="hobby"/><br/>
    <select name="sex">
        <option selected value="">性别</option>
        <option value="男">男</option>
        <option value="女">女</option>
        <br/>
    </select>
    <input type="submit" value="注册"/>


<body/>

</html>
