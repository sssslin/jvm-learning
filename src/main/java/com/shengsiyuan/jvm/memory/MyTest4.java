//package com.shengsiyuan.jvm.memory;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//
///**
// * 方法区产生内存溢出错误
// *
// * 关于永久代和metaspace的讲解
// * https://www.infoq.cn/article/Java-PERMGEN-Removed
// *
// * 文章中的交换区是什么意思?
// */
//public class MyTest4 {
//
//    public static void main(String[] args) {
//        for (; ; ) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(MyTest4.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
//
//            System.out.println("hello world");
//
//            enhancer.create();
//        }
//    }
//}
