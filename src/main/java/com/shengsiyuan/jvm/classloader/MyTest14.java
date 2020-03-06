package com.shengsiyuan.jvm.classloader;

import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "com/shengsiyuan/jvm/classloader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        Class<?> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());
    }
}
