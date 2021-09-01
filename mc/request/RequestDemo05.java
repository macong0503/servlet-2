package com.hqyj.mc.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/requestDemo05")
public class RequestDemo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //演示请求转发
        System.out.println("RequestDemo05");
        //共享一个数据，一个字符串名字叫user值叫张三
        request.setAttribute("user","zhangsan");

        //获取请求转发器,同时获得地址
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo06");
        //执行请求转发
        requestDispatcher.forward(request,response);

    }

}
