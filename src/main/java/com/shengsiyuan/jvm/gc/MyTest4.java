package com.shengsiyuan.jvm.gc;

/**
 *-verbose:gc
 * -Xmx200M
 * -Xmn50M
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:MaxTenuringThreshold=3
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        myGC();
        Thread.sleep(1000);
        System.out.println("111111");

        myGC();
        Thread.sleep(1000);
        System.out.println("222222");

        myGC();
        Thread.sleep(1000);
        System.out.println("333333");

        myGC();
        Thread.sleep(1000);
        System.out.println("444444");

        byte[] byte_3 = new byte[1024 * 1024];
        byte[] byte_4 = new byte[1024 * 1024];
        byte[] byte_5 = new byte[1024 * 1024];

        myGC();
        Thread.sleep(1000);
        System.out.println("555555");

        myGC();
        Thread.sleep(1000);
        System.out.println("666666");

        System.out.println("hello world");
    }

    private static void myGC() {
        for (int i = 0; i < 40; i++) {
            byte[] byteArray = new byte[1024 * 1024];
        }
    }
}
