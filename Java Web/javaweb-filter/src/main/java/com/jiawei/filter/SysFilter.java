package com.jiawei.filter;

import com.jiawei.util.Constant;

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

        Object userSession = req.getSession().getAttribute(Constant.USER_SESSION);
        if(userSession == null) {
            resp.sendRedirect("/error.jsp");
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
