package com.hqyj.mc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
*  保存一个cookie
* */
@WebServlet("/cookieDemo01")
public class CookieDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CookieDemo01被访问");
        //创建一个cookie对象,名值对，数据类型都是String
        Cookie cookie = new Cookie("username","zhangsan");
        //设置cookie的存活时长
        cookie.setMaxAge(60);
        //使用response发送给浏览器cookie
        response.addCookie(cookie);
        //在创建一个cookie
        Cookie cookie1 = new Cookie("username1","李四");
        response.addCookie(cookie1);



    }
}
