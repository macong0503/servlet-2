package com.hqyj.mc.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ContextDemo01")
public class ContextDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取Servletcontext对象
        ServletContext servletContext1 = request.getServletContext();
        System.out.println(servletContext1);

        //使用this.Servletcontext
        ServletContext servletContext2 = getServletContext();
        System.out.println(servletContext2);

        System.out.println(servletContext1 == servletContext2);
    }
}
