package com.hqyj.mc.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo03")
public class RequestDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求体相关信息
        //如果请求体中是字符型信息，可以使用getreader()获取字符流对象
        BufferedReader reader = request.getReader();
        //使用该字符流对象获取字符信息
        String line = null;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        //如果请求体中是字节型信息，使用getinputstream()获取字节输入流对象
        //ServletInputStream inputStream = request.getInputStream();


    }
}
