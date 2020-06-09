package com.insideVM.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串常量池是放在哪里的？
 *
 */
public class RuntimeConstantPoolOOM {

  public static void main(String[] args) {
    // 使用set保持着常量池引用，避免full gc回收常量池行为
    Set<String> set = new HashSet<String>();
    // 在short范围内足以让6M的PermSize产生OOM了
    short i =0;

    while (true) {
      set.add(String.valueOf(i++).intern());
    }
  }

}
