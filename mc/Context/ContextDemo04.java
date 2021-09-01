package com.hqyj.mc.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/ContextDemo04")
public class ContextDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取Servletcontext对象
        ServletContext servletContext1 = request.getServletContext();
       //获取b.txt的真实路径
        String realPath1 = servletContext1.getRealPath("/b.txt");
        System.out.println(realPath1);
        //获取c.txt的真实路径
        String realPath2 = servletContext1.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath2);
        //获取a.txt的真实路径
        String realPath3 = servletContext1.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath3);
        File file = new File(realPath3);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        System.out.println(line);
        reader.close();
    }
}
