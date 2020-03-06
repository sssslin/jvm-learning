package com.shengsiyuan.jvm.classloader;

// 常量在编译阶段会存入到调用常量的方法所在的类的常量池种，
// 本质上，调用类并没有直接引用到定义常量的类，因此并不会出发
// 定义常量的初始化
// 注意：这里指的是将常量存放到了MyTest2的常量池种，之后MyTest2
// 与MyParent2就没有任何关系了
// 甚至，我们可以将MyParent2的class文件删除

/*  jdk的rt包下面的com.sun.org.apache.bcel.internal.generic
    定义了注记符。
    注记符：
    ldc表示将int，float或是String类型的常量值从常量池中推送至栈顶
    binpush表示将单字节（-128 ~ 127）的常量值推至栈顶
    sipush表示将短整型常量值（-32768 ~ 32767）
    iconst_1表示将int类型1推送至栈顶 （iconst_m1 ~ iconst_5）
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.s);
    }
}
class MyParent2 {

    public static final String str = "hello world";

    public static final short s = 127;

    public static final int i = -2;

    public static final int m = 6;

    static {
        System.out.println("MyParent2 static block");
    }
}
