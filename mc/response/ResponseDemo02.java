package com.hqyj.mc.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo02")
public class ResponseDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置输出流的缓冲区编码
        //response.setCharacterEncoding("utf-8");
        //设置content-type头，告诉浏览器现在响应体中的数据格式和编码
        //response.setHeader("content-type","text/html;charset=utf-8");
        //简单地书写方式
        response.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter writer = response.getWriter();
        //使用该流对象写数据
        writer.write("你好呀 response");
    }
}
