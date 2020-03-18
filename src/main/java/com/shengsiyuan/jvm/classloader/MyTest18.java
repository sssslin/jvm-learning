package com.shengsiyuan.jvm.classloader;

/**
 * @Author: LinJunFeng
 * @Date: 2020-03-15 20:36
 * @Description:
 * @Version: 1.0.0
 **/
public class MyTest18 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
