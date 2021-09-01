package com.hqyj.mc.session.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String Driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/shop?";
    private static String user = "root";
    private static String password = "123456";

    static {
        //建立驱动
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Connection con = null;
    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                //获得连接
                con = DriverManager.getConnection(url, user, password);
            }
            else{
                return con;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
