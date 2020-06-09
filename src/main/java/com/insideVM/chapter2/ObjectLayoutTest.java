package com.insideVM.chapter2;

import org.openjdk.jol.vm.VM;

/**
 * 通过jol可以了解到一个对象在内存中的布局
 */
public class ObjectLayoutTest {

  public static void main(String[] args) {
    System.out.println(VM.current().details());
  }

}
