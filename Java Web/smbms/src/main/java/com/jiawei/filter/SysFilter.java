package com.jiawei.filter;

import com.jiawei.pojo.User;
import com.jiawei.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //从Session中获取user
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);

        if (user == null) {
            resp.sendRedirect("/smbms/error.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }
    public void destroy() {

    }
}
