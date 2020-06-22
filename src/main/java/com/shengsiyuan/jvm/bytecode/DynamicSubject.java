package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 流程梳理：动态代理首先会生成一个代理类，其中核心的就是被代理的request方法
 * $Proxy0.class中的super.h其實就是Proxy中的InvocationHandler h属性，
 * 又由于我们的DynamicSubject接口实现了其invoke方法，所以，真正执行的是我们的DynamicSubject的invoke方法
 * 代理类中的 super.h.invoke(this, m3, (Object[])null);,表明method方法将会是request方法
 * 同理可得after这行打印的代码，也会将代理的request方法
 */
public class DynamicSubject implements InvocationHandler {

    private Object sub;

    public DynamicSubject(Object obj) {
        this.sub = obj;
    }

    // 执行流程 proxy.request---> DynamicSubject.invoke--->realSubject
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before calling: " + method);

        // 以上构造方法，将会把client中的RealSubject实例给传进来，最终通过反射执行request方法
        method.invoke(this.sub, args);

        System.out.println("after calling: " + method);

        return null;
    }
}
