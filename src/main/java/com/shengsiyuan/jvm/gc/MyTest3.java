package com.shengsiyuan.jvm.gc;

/**
 *  -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
 *  -XX:+SurvivorRatio=8 -XX:MaxTenuringThreshold=5 -XX:+PrintTenuringDistribution
 *
 *  MaxTenuringThreshold作用:在可以自动调节对象晋升(Promote)到老年代阈值的GC中,设置该阈值的最大值
 *  该参数的默认值为15,CMS中默认值为6,G1中默认为15(在JVM中,该数值是由4个bit来表示的,所以最大值1111,即15)
 *  问题:为什么G1中默认的阈值为15?
 *
 *  经历了多次GC后,存活的对象会在From Survivor与To Survivor之间来回存放,而这里面的一个前提是这两个
 *  空间有足够的大小来存放这些数据,在GC算法中,会计算每个对象的年龄大小,如果达到某个年龄后发现总大小已经
 *  大于了Survivor空间的50%,那么这时候就需要调整阈值,不能再继续等到默认的15次GC后才完成晋升,因为这样
 *  会导致Survivor空间不足,所以要调整阈值,让这些存活对象尽快完成晋升.
 */
public class MyTest3 {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];

        System.out.println("hello world");
    }
}
