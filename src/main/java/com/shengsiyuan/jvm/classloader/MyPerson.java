package com.shengsiyuan.jvm.classloader;

/**
 * @Author: LinJunFeng
 * @Date: 2020-03-15 20:53
 * @Description:
 * @Version: 1.0.0
 **/
public class MyPerson {

    private MyPerson myPerson;

    public void setMyPerson(Object object) {
        this.myPerson = (MyPerson) object;
    }
}
