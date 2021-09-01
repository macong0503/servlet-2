package com.hqyj.mc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet({"/Demo04","/demo4"})
//@WebServlet("*.do")//任何.do结尾的都可以匹配到该Servlet，不以/打头
//@WebServlet("/demo/demo4")
//@WebServlet("/demo/*")
//@WebServlet("/*")//*通配方式优先级较低
//@WebServlet("/")// /表示匹配所有urlpatten,除了.jsp结尾的
public class ServletDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo04....");
    }
}
