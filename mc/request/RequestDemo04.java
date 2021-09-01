package com.hqyj.mc.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/requestDemo04")
public class RequestDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //通用的获取请求参数的相关api
        //根据请求的参数名获取参数值
        String username = request.getParameter("username");
        System.out.println("username="+username);
        //获取所有的参数名
        Enumeration<String> parameterNames = request.getParameterNames();
        //遍历枚举集合
        while (parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            //根据请求参数名获取参数值
            String paramValue = request.getParameter(paramName);
            System.out.println(paramName+":"+paramValue);
        }
        //请求参数中可以同名 roles=teacher&roles=manager
        //使用getParameterValues()获取同名的参数值，返回类型为数组
        String[] parameterValues = request.getParameterValues("roles");
        if (parameterValues != null){
            //遍历打印同名参数的值
            for (String param:parameterValues)
                System.out.println("roles="+param);
        }
        //获取全部的参数名和参数值，封装到一个map对象中
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
    }

}
