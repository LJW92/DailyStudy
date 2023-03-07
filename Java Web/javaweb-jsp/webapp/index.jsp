<%@ page contentType="text/html;charset=UTF-8"   %>
<html>
<body>

<%--JSP表达式
作用：用来将程序的输出，输出到客户端
<%= 变量或者表达式 %>
--%>
<%= new java.util.Date() %>

<hr>

<%--脚本片段--%>
<%
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
        sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
%>

<%
    int x = 10;
    out.println(x);
%>
<p>这是一个jsp文档</p>

<%
    int y = 2;
    out.println(y);
%>

<hr>

<%--在代码中嵌入HTML元素--%>
<%
    for (int i = 0; i < 5; i++) {

%>
<h1>hello,World <%= i %>  </h1>
<%
    }
%>

    >


</body>
</html>
