<%--
  Created by IntelliJ IDEA.
  User: dehong
  Date: 2018/9/17
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎登陆</h1>
<form action="/LoginServlet" method="post">
    用户名：<input type="text" name="loginUserName"/><br>
    密&emsp;码：<input type="password" name="loginPassword"/><br>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
