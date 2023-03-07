package com.jiawei.servlet.user;

import com.jiawei.pojo.User;
import com.jiawei.service.user.UserService;
import com.jiawei.service.user.UserServiceImpl;
import com.jiawei.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //servlet: 控制层，调用业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("LoginServlet--start...");

        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //和密码对比，调用业务层
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword); //已经把登陆的人查出来了
        if(user != null){ //查有此人，可以登陆
            //将用户的信息放倒session中
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            //跳转内部主页
            resp.sendRedirect("jsp/frame.jsp");
        } else { //没有这个人
            //回到登陆界面 提示错误
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
