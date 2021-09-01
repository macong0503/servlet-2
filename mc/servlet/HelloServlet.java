package com.hqyj.mc.servlet;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //servlet初始化方法
        System.out.println("servlet初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello,seervlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("servlet被销毁了");
    }
}
