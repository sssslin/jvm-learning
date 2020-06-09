package com.insideVM.chapter3;

/**
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=15
 * -XX:+PrintTenuringDistribution
 * -XX:+UseSerialGC
 */
public class HugeObjectTest3 {

  private static final int _1MB = 1024 * 1024;

  public static void main(String[] args) {
    testPretenureSizeThreshold();
  }

  public static void testPretenureSizeThreshold() {
    byte[] allocation1, allocation2, allocation3, allocation4;

    allocation1 = new byte[_1MB / 4];
    allocation2 = new byte[_1MB / 4];
    allocation3 = new byte[_1MB * 4];
    allocation4 = new byte[_1MB * 4];
    allocation4 = null;
    allocation4 = new byte[_1MB * 4];
  }

}
