package com.hqyj.mc.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置状态码
        response.setStatus(302);
        //设置响应头
        //response.setHeader("location","http://www.baidu.com");
        //跳转到自己的网址的首页
        String contextPath = request.getContextPath();
        //response.setHeader("location",contextPath+"/");
        response.sendRedirect("http://www.baidu.com");
    }
}
