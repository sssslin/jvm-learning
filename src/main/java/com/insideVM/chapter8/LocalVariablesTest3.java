package com.insideVM.chapter8;

/*
    加上int a = 0;就能正常回收的原因在于
    在没有新的变量来复用局部变量表的slot的时候，局部变量存在着placeholder表示对数据对象的引用，但是在作用域外加了int a之后，slot则会被a占据
    数组对象将失去引用，所以成功full gc
 */
public class LocalVariablesTest3 {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];

        }
        int a = 0;
        System.gc();
    }
}
