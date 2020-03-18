package com.shengsiyuan.jvm.classloader;

import javax.sound.midi.Soundbank;

/**
 * @Author: LinJunFeng
 * @Date: 2020-03-15 17:47
 * @Description:
 * @Version: 1.0.0
 **/
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by:" + this.getClass().getClassLoader());
        // 不同命名空间之间是相互不可见的,子类的命名空间能看见父类所加载的类,反之则不行
       // System.out.println("from MyCat: " + MySample.class);
    }
}
