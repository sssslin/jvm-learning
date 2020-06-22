package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();

        // 简单的说，就是下面这行代码传入的参数，就已经确定了，被代理对象和代理对象，然后通过生成的代理对象
        // 指明真正执行代理方法的行为，然后只要传入参数给代理对象，那么所有的执行逻辑，都是在DynamicSubject中
        // $poxy0.super.h = proxy.h =InvocationHandler = DynamicSubject的父类
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
