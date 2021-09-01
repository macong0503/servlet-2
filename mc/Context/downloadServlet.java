package com.hqyj.mc.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
/*
*  实现文件下载
* */
@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求参数的编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数 filename
        String filename = request.getParameter("filename");
        //拿到对应文件的虚拟路径
        String path = "/img/"+filename;
        System.out.println(path);
        //获取真实路径
        ServletContext servletContext = getServletContext();

        
        String realPath = servletContext.getRealPath(path);
        System.out.println(realPath);

        //设置响应头信息
        response.setHeader("content-disposition","attachment;filename="+filename);
        //通过Servletcontext对象获取文件的mimetype
        String mimeType = servletContext.getMimeType(filename);
        //服务器告诉浏览器，响应体中的数据的格式
        response.setContentType(mimeType);


        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));

        //使用response对象获取相应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //流对拷
        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        bis.close();

    }
}
