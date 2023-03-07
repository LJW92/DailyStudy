package com.jiawei.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//统计在线的Session
public class OnlineCountListener implements HttpSessionListener {
    //创建session监听
    //一旦创建session就会触发
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if (onlineCount == null){
            onlineCount = 1;
        } else {
            int count = onlineCount;
            onlineCount = count + 1;
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }
    //销毁session
    //session一旦被销毁就会触发这个事件
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if (onlineCount == null){
            onlineCount = 0;
        } else {
            int count = onlineCount;
            onlineCount = count - 1;
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }
}
