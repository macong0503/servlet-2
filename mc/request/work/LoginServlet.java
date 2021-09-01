package com.hqyj.mc.request.work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取输入的用户名
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection con = DBUtil.getConnection();

        try {
            PreparedStatement pre = con.prepareStatement("select * from user where name = ? and password = ?");
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet resultSet = pre.executeQuery();
            if (resultSet.next()) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
                requestDispatcher.forward(request,response);
            }else{
                RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("/fail.jsp");
                requestDispatcher2.forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
/*        if ("zhangsan".equals(username) && "123456".equals(password)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
            requestDispatcher.forward(request,response);
        }else{
            RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("/fail.jsp");
            requestDispatcher2.forward(request,response);
        }*/

    }
}