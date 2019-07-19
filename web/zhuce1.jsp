<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/11
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${msg}<br/>
    <form action="successServlet" method="post">
        用户名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        兴趣爱好：<input type="checkbox" name="hobby" value="唱歌"/>唱歌
        <input type="checkbox" name="hobby" value="跳舞"/>跳舞
        <input type="checkbox" name="hobby" value="Rap"/>Rap
        <input type="checkbox" name="hobby" value="篮球"/>篮球<br/>
        <select name="sex">
            <option selected value="">性别</option>
            <option value="男">男</option>
            <option value="女">女</option><br/>
        </select>
        <input type="submit" value="注册"/>
    </form>


</body>
</html>
