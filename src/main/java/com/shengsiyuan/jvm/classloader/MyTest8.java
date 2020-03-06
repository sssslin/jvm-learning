package com.shengsiyuan.jvm.classloader;

import java.util.Random;

/**
 * @Author: LinJunFeng
 * @Date: 2020-03-03 13:44
 * @Description:
 * @Version: 1.0.0
 **/
public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest {

    public static final int x = new Random().nextInt(3);

    static {
        System.out.println("FinalTest static block");
    }
}