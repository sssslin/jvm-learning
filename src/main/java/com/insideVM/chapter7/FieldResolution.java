package com.insideVM.chapter7;

/**
 * @author junfeng.ling
 * @date 2020/3/23 13:51
 * @Description:
 */
public class FieldResolution {

    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        // 假如注释掉以下这行代码，将会出现菱形继承问题，所以javac编译器拒绝编译
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
