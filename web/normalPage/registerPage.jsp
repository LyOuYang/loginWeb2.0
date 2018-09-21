<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="align-content: center">欢迎注册</h1>
<h1 style="font-size: 13px;color: red">${errors.repetitionError}</h1>
<form action="/RegisterServlet" method="post">
    <table>
        <tr>
            <td>用户名：<input type="text" name="userName"/></td>
            <td><p style="font-size: 10px;color: red">${errors.userNameError}</p></td>
        </tr>
        <tr>
            <td>密&emsp;码：<input type="password" name="passWord"/></td>
            <td><p style="font-size: 10px;color: red">${errors.passWordError}</p></td>
        </tr>
    </table>
    <input type="submit" value="登陆"/>
</form>
</body>
</html>
