package com.insideVM.chapter8;

/**
 * -verbose:gc
 */
public class LocalVariablesTest2 {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }
}
