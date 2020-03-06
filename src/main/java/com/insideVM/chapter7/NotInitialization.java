package com.insideVM.chapter7;

/**
 * @Author: LinJunFeng
 * @Date: 2020-02-28 21:40
 * @Description:
 * @Version: 1.0.0
 **/
public class NotInitialization {

    public static void main(String[] args) {
       // System.out.println(SubClass.value);
//        SuperClass[] sca = new SuperClass[10];
//        System.out.println(sca.getClass());
//        System.out.println(sca.getClass().getSuperclass());
        System.out.println(ConstClass.HELLOWORLD);
    }
}
