package com.jiawei.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.jiawei.pojo.Role;
import com.jiawei.pojo.User;
import com.jiawei.service.role.RoleServiceImpl;
import com.jiawei.service.user.UserService;
import com.jiawei.service.user.UserServiceImpl;
import com.jiawei.util.Constants;
import com.jiawei.util.PageSupport;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method.equals("savepwd") && method != null) {
            this.updatePwd(req, resp);
        } else if (method.equals("pwdmodify") && method != null) {
            this.pwdModify(req, resp);
        } else if (method.equals("query") && method != null) {
            this.query(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session拿id
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        boolean isDone;
        if (attribute != null && !StringUtils.isNullOrEmpty(newpassword)) {
            UserService userService = new UserServiceImpl();
            isDone = userService.updatePwd(((User) attribute).getId(), newpassword);
            if (isDone) {
                req.setAttribute("message", "修改密码成功，请退出，使用新密码登录。");
                //密码修改成功，移除当前session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "密码修改失败");
            }
        } else {
            req.setAttribute("message", "新密码不合规。");
        }

        req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp); //把信息送过去
    }

    public void pwdModify(HttpServletRequest req, HttpServletResponse resp) {
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
        //万能的map
        Map<String, String> resultMap = new HashMap<String, String>();
        if (attribute == null) { //session expired
            resultMap.put("result", "sessionerror");
        } else if (StringUtils.isNullOrEmpty(oldpassword)) {
            resultMap.put("result", "error");
        } else {
            String userPassword = ((User) attribute).getUserPassword();
            if (oldpassword.equals(userPassword)) {
                resultMap.put("result", "true");
            } else {
                resultMap.put("result", "false");
            }
        }
        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void query(HttpServletRequest req, HttpServletResponse resp) {
        //查询用户列表

        //从前端获取数据
        String queryname = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;
        //获取用户列表

        UserServiceImpl userService = new UserServiceImpl();
        int pageSize = 5;
        int currentPageNum = 1;


        if (queryname == null) {
            queryname = "";
        }
        if (temp != null && !temp.equals("")) {
            queryUserRole = Integer.parseInt(temp);
        }
        if (pageIndex != null) {
            currentPageNum = Integer.parseInt(pageIndex);
        }

        //获取用户的总数
        int totalCount = userService.getUserCount(queryname, queryUserRole);

        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNum);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalPageCount(totalCount);

        int totalPageCount = Math.round(totalCount / pageSize) + 1;

        if (currentPageNum < 1) {
            currentPageNum = 1;
        } else if (currentPageNum > totalPageCount) {
            currentPageNum = totalPageCount;
        }

        //获取用户列表展示
        List<User> userList = userService.getUserList(queryname, queryUserRole, currentPageNum, pageSize);
        req.setAttribute("userList", userList);

        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList", roleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNum);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("queryUsername", queryname);
        req.setAttribute("totalPageCount", totalPageCount);

        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

