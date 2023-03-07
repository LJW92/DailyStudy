<%--
  Created by IntelliJ IDEA.
  User: 34926
  Date: 2023/1/13
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<h1>登陆</h1>
<div>
    <%--以post方式提交表单到login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名: <input type="text" name="username"> <br>
        密码: <input type="password" name="password"> <br>
        爱好：
        <input type="checkbox" name="hobby" value="女孩">女孩
        <input type="checkbox" name="hobby" value="代码">代码
        <input type="checkbox" name="hobby" value="唱歌">唱歌
        <input type="checkbox" name="hobby" value="电影">电影

        <br>
        <input type="submit">
    </form>

</div>
</body>
</html>
