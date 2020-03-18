package com.shengsiyuan.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author: LinJunFeng
 * @Date: 2020-03-18 20:24
 * @Description:
 * @Version: 1.0.0
 **/
public class MyTest27 {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc://localhost:3306/mytestdb", "username", "password");
    }
}
