package com.insideVM.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 */
public class HeapOOM {

  static class OOMObject {
  }
  public static void main(String[] args) {
    List<OOMObject> list = new ArrayList<OOMObject>();

    while (true) {
      list.add(new OOMObject());
    }
  }

}
