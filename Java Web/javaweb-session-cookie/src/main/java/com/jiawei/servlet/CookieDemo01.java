package com.jiawei.servlet;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        //服务器告诉你，你来的时间，把这个时间封装成一个信件，下次来就知道你来了

        //解决中文乱码
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        
        //Cookie服务器端从客户端获取
        Cookie[] cookies = req.getCookies(); //数组，可能存在多个
        
        //判断cookie是否存在
        if (cookies != null) {
            //如果存在
            out.write("你上次访问的时间是： ");
            for (Cookie cookie : cookies) {
                //获取cookie的名字
                if (cookie.getName().equals("LastLoginTime")) {
                    //获取cookie的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toString());
                }


            }
            
        }else {
            out.write("这是您第一次访问本网站");
        }
        
        //服务器给客户端响应一个cookie

        Cookie cookie = new Cookie("LastLoginTime", System.currentTimeMillis() + "");
        //设置一天之后过期； 设置-1则为session结束就过期
        cookie.setMaxAge(24*60*60);

        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        doGet(req, resp);
    }
}
