package com.insideVM.chapter3;

/**
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * 下面这个参数在JDK8中已经移除
 * -XX:-HandlePromotionFailure
 * -XX:+UseSerialGC
 */
public class HandlePromotionTest {

  private static final int _1MB = 1024 * 1024;

  public static void main(String[] args) {
    testPretenureSizeThreshold();
  }

  public static void testPretenureSizeThreshold() {
    byte[] allocation1, allocation2, allocation3, allocation4,
        allocation5, allocation6, allocation7, allocation8;

    allocation1 = new byte[_1MB * 2];
    allocation2 = new byte[_1MB * 2];
    allocation3 = new byte[_1MB * 2];
    allocation1 = null;
    allocation4 = new byte[_1MB * 2];
    allocation5 = new byte[_1MB * 2];
    allocation6 = new byte[_1MB * 2];
    allocation4 = null;
    allocation5 = null;
    allocation6 = null;
    allocation7 = new byte[_1MB * 2];
  }
}
