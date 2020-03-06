package com.shengsiyuan.jvm.classloader;

/**
 *对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求父类全部都已经初始化完毕
 * -XX:+TraceClassLoading:追踪类的加载信息并打印出来（可验证类的加载顺序）
 */
public class MyTest1 {
    public static void main(String[] args) {
        // 场景2：访问某个类或接口的静态变量，或者对该静态变量赋值
        System.out.println(MyChild1.str);
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}
// 场景5：初始化一个类的子类
class MyChild1 extends MyParent1 {

    public static String str2 = "welcome";
    static {
        System.out.println("MyChild1 static block");
    }
}
