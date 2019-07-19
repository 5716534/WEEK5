<%--
  Created by IntelliJ IDEA.
  User: 57716
  Date: 2019/7/15
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
    <form action="/loginServlet1" method="post">
        <table border="1" >
        <tr>
            <th>用户名：</th>
            <td><input type="text" name="username"/><br/></td>
        </tr>
            <th>密码：</th>
            <td><input type="password" name="password"/><br/></td>
       <tr>
           <td colspan="3" align="center">
        <input type="submit" value="登陆"/>
        <input type="reset" value="重置"/>
        <input type="button" value="注册"
               onclick="javascript:window.location.href='/itemsJsp/register.jsp'"/>
           </td>
       </tr>
        </table>
    </form>

</body>
</html>
