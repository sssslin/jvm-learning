//package com.shengsiyuan.jvm.classloader;
//import java.util.concurrent.TimeUnit;
//
///**
// * 参考文章：https://www.cnblogs.com/grey-wolf/p/11378747.html
// * 这个示例模拟了ClassLoader这个类在使用loadClass()方法中可能出现deadlock问题
// */
//public class TestClassLoading {
//
//    public static class A{
//        static {
//            System.out.println("class A init");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            // new B();
//            B.test();
//        }
//
//        public static void test() {
//            System.out.println("aaa");
//        }
//    }
//
//    public static class B{
//        static {
//            System.out.println("class B init");
//            // new A();
//            A.test();
//        }
//
//
//        public static void test() {
//            System.out.println("bbb");
//        }
//    }
//    public static void main(String[] args) {
//        new Thread(() -> A.test()).start();
//        new Thread(() -> B.test()).start();
//    }
//}
