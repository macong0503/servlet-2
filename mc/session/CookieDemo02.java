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
@WebServlet("/cookieDemo02")
public class CookieDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CookieDemo02被访问");
        //通过request对象来获取浏览器发送给服务器的所有的cookie
        Cookie[] cookies = request.getCookies();
        //不为null是遍历cookie数组
        if (cookies!=null){
            for (Cookie one : cookies) {
                //获取cookie的名
                String name = one.getName();
                //获取cookie的值
                String value = one.getValue();
                System.out.println(name+" = "+value);
            }
        }

    }
}
