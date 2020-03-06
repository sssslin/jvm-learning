package com.insideVM.chapter7;

/**
 * @Author: LinJunFeng
 * @Date: 2020-02-28 21:55
 * @Description:
 * @Version: 1.0.0
 **/
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String  HELLOWORLD = "hello world";
}
