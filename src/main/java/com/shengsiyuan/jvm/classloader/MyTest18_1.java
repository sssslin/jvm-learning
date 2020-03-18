package com.shengsiyuan.jvm.classloader;

/**
 * @Author: LinJunFeng
 * @Date: 2020-03-15 20:40
 * @Description:
 * @Version: 1.0.0
 **/
public class MyTest18_1 {

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\MrLin\\Desktop\\");

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());
    }
}
