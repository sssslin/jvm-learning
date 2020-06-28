package com.insideVM.chapter8;

import java.io.Serializable;

/**
 * 这个方法表明了虚拟机会通过语义，语法的规则选择更加合理的版本，具有一定的优先级顺序
 *
 */
public class Overload {

    public static void sayHello (Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello (int arg) {
        System.out.println("hello int");
    }

    public static void sayHello (long arg) {
        System.out.println("hello long");
    }

    public static void sayHello (Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello (char arg) {
        System.out.println("hello char");
    }

    public static void sayHello (char... arg) {
        System.out.println("hello char...");
    }

    public static void sayHello (Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
