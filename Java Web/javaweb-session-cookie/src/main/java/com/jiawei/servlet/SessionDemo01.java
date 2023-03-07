package com.jiawei.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        //解决乱码
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到session
        HttpSession session = req.getSession();
        //给session中存东西
        session.setAttribute("name","嘉玮");
        //获得session的id
        String id = session.getId();
        //判断session是不是新创建的
        if (session.isNew()) {
            resp.getWriter().write("session 创建成功,ID为： " + id);
        } else {
            resp.getWriter().write("session 已经存在了,ID为： " + id);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
