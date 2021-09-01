package com.hqyj.mc.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo01")
public class RequestDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //打印请求对象
        System.out.println(request);

        //获取请求行相关信息
        //获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式");
        System.out.println(method);
        //获取项目的虚拟目录
        String contextPath = request.getContextPath();
        System.out.println("项目的虚拟目录");
        System.out.println(contextPath);
        //获取请求的URL
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("请求的URL");
        System.out.println(requestURL.toString());
        //获取请求的URI
        String requestURI = request.getRequestURI();
        System.out.println("请求的URI");
        System.out.println(requestURI);
        //获取请求中的querystring
        String queryString = request.getQueryString();
        System.out.println("请求中的querystring");
        System.out.println(queryString);
        //获取协议
        String protocol = request.getProtocol();
        System.out.println("协议");
        System.out.println(protocol);
    }
}
