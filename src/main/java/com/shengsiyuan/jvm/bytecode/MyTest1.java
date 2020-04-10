package com.shengsiyuan.jvm.bytecode;

/**
 * 在这个demo中，aload_0指的是，从LocalVariableTable去获取变量
 * 这里，获取到的this.
 * iload_1指的是，去本地变量表里获取局部变量a，
 * putfield指的是，给这个a赋值，这个指令是，接受参数的，参数就是a
 */
public class MyTest1 {

    // 从字节码可以看出来，变量的初始化，其实不是在声明的那一行开始的
    // 而是在构造方法里面，统一将变量初始化的，
    private int a = 1;

    public MyTest1(int a, Long b) {
        this.a = a;
        this.b = b;
    }

    public MyTest1(int x) {
        this.a = a;
    }

    private Long b = 2L;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Long getB() {
        return b;
    }

    public void setB(Long b) {
        this.b = b;
    }

    // LocalVariableTable中index指的就是每个变量的
    // 索引在索引表中的顺序，用来表示是第几个变量
    // 与之对应的是 javap -verbose 出来的Slot
    public void testIndex(int a, long b) {
        a = 8;
        b = 9L;
    }
}
