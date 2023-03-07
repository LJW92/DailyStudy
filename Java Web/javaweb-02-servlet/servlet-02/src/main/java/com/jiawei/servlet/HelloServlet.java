package com.jiawei.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        this.getInitParameter();  初始化参数
//        this.getServletConfig();  Servlet参数
//        this.getServletContext(); Servlet上下文
        ServletContext context = this.getServletContext();

        String username = "jiawei";
        context.setAttribute("username",username);//将一个数据保存在ServletContext中，键username  值 username

        System.out.println("Hello");
    }

}
