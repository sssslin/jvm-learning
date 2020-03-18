package com.shengsiyuan.jvm.classloader;

/**
 * @Author: LinJunFeng
 * @Date: 2020-03-15 17:52
 * @Description:
 * @Version: 1.0.0
 **/
public class MyTest17 {

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());

        // 如果注释掉该行,那么并不会实例化MySample对象,即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象,即没有对MyCat进行主动使用,这里就不会加载MyCat class
        Object object = clazz.newInstance();

    }
}
