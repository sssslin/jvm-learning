package com.shengsiyuan.jvm.classloader;

/**
 * @Author: LinJunFeng
 * @Date: 2020-03-15 17:49
 * @Description:
 * @Version: 1.0.0
 **/
public class MySample {

    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());

        new MyCat();

        System.out.println("from MySample: " + MyCat.class);
    }
}
