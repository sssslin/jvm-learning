package com.shengsiyuan.jvm.classloader;

/*
    对于数组来说，其类型是由JVM在运行期间动态生成的，
    表示为[Lcom.shengsiyuan.jvm.classloader.MyParent4这种形式，是由JVM在运行时动态生成的
    其父类型就是Object。

    对数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度后的类型

    助记符：
    anewarray:表示创建一个引用类型的（如类、接口、数组）数组，并将其压入栈顶
    newarray:表示创建一个指定类型的（如int、float、char等）数组，并将其压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
        // 创建一个实例的话，虚拟机加载的类型就是我们定义的类型
        MyParent4 myParent4 = new MyParent4();
        System.out.println(myParent4.getClass());

        // 创建一个数组的话，虚拟机加载的类型就是以下这种类型，所以下面这种情况不会打印静态代码块
        // class com.shengsiyuan.jvm.classloader.MyParent4
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());

//        MyParent4[][] myParent4s1 = new MyParent4[1][1];
//        System.out.println(myParent4s1.getClass());
//
//        System.out.println(myParent4s.getClass().getSuperclass());
//        System.out.println(myParent4s1.getClass().getSuperclass());
//
//        System.out.println("=====");
//
//        int[] ints = new int[1];
//        System.out.println(ints.clone());
//        System.out.println(ints.getClass().getSuperclass());
//
//        char[] chars = new char[1];
//        System.out.println(chars.getClass());
//
//        boolean[] booleans = new boolean[1];
//        System.out.println(booleans.getClass());
//
//        short[] shorts = new short[1];
//        System.out.println(shorts.getClass());
//
//        byte[] bytes = new byte[1];
//        System.out.println(bytes.getClass());
    }
}

class MyParent4 {

    static {
        System.out.println("MyParent4 static block");
    }
}
