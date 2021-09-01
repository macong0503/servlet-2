package com.hqyj.mc.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo02")
public class RequestDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        //获取请求头相关信息
        //获取所有的请求头
        //Enumeration:枚举集合，定义了方便我们遍历集合中的数据的方式
        Enumeration<String> headerNames = request.getHeaderNames();
        //进行集合的遍历操作
        while(headerNames.hasMoreElements()){
            String headername = headerNames.nextElement();
            //根据请求头的名字来获取请求头的值
            String headervalue = request.getHeader(headername);
            System.out.println(headername+":"+headervalue);
        }



    }
}
