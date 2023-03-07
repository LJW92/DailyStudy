package com.jiawei.servlet;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //        ①要获取下载文件的路径
        String realPath = "D:\\IDEA_Projects\\javaweb-02-servlet\\response\\src\\main\\resources\\heimao.jpg";
        System.out.println("下载文件的路径:" + realPath);
        //        ②下载的文件名是什么
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //        ③设置想办法让浏览器能支持(Content-Disposition)下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8") );
        //        ④获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //        ⑤创建缓冲区
        int len;
        byte[] buffer = new byte[1024];
        //        ⑥获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //        ⑦将FileOutputStream流写入到buffer缓冲区 ⑧使用OutputStream将缓冲区中的数据输出到客户端
        while((len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
