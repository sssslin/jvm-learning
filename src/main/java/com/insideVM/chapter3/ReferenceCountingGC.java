package com.insideVM.chapter3;

/**
 * https://blog.51cto.com/guojuanjun/1954570
 * https://www.jianshu.com/p/12e26ed5e15a
 */
public class ReferenceCountingGC {

  public Object instance = null;

  private static final int _1MB = 1024 * 1024;

  // 这个成员属性的唯一意义就是占点内存，以便能够在GC日志中看清楚是否有回收过
  private byte[] bigSize = new byte[2 * _1MB];

  public static void testGC() {
    ReferenceCountingGC objA = new ReferenceCountingGC();
    ReferenceCountingGC objB = new ReferenceCountingGC();

    objA = null;
    objB = null;

    // 假设在这行发生GC,objA和objB能否被回收
    System.gc();
  }

  public static void main(String[] args) {
    testGC();
  }
}
