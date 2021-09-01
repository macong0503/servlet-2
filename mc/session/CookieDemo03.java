package com.hqyj.mc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
*  显示上次访问时间
* */
@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //创建变量，假定用户第一次访问
        boolean isFirstVisit = true;
        response.setContentType("text/html;charset=utf-8");
        //获取全部cookie
        Cookie[] cookies = request.getCookies();
        //判断是否为空
        if (cookies != null){
            //遍历数组，找名叫lastvisit的cookie
            for (Cookie one : cookies) {
                String name = one.getName();
                if ("lastVisit".equals(name)){
                    //不是第一次访问
                    isFirstVisit = false;
                    //获取该cookie的value，就是上次访问时间
                    String value = one.getValue();
                    //对之前URL编码过的字符串进行URL解码
                    String decodedString = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("欢迎回来，您的上次访问时间"+decodedString);
                }
            }
        }
        //做判断是否第一次访问
        if (isFirstVisit){
            response.getWriter().write("欢迎，这是你第一次访问");

        }
        //无论是否是第一次访问，都要记录当前的访问时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //格式化当前时间
        String now = simpleDateFormat.format(new Date());
        //对时间字符串使用URL编码
        //第一个参数带编码的字符串，第二个参数规定能够使用utf-8
        String encodedString = URLEncoder.encode(now, "utf-8");
        System.out.println(encodedString);
        //创建一个记录当前时间的cookie
        Cookie cookie = new Cookie("lastVisit",encodedString);
        //设置该cookie保存30天
        cookie.setMaxAge(30*24*60*60);
        //让浏览器保存cookie
        response.addCookie(cookie);
    }
}
