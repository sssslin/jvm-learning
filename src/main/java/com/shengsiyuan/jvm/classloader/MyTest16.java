package com.shengsiyuan.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(String classLoaderName) {
        super(); // 将系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);
    }
    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent); // 显式指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    // 如果不注释这行,则虚拟机将会隐式的调用这个方法,把类加载器名称打印成数组的形式.
//    @Override
//    public String toString() {
//        return "[" + this.classLoaderName + "]";
//    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        System.out.println("findClass invoked:" + className);
        System.out.println("class loader name:" + this.classLoaderName);

        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", "\\");
        try {
            this.classLoaderName = this.classLoaderName.replace(".", "\\");

            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        // loader1.setPath("D:\\DownloadAndData\\private\\Java\\jvm-learning\\target\\classes\\");
        loader1.setPath("C:\\Users\\MrLin\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println();

        loader1 = null;
        clazz = null;
        object = null;

        System.gc();

       // Thread.sleep(2000000);

        loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\MrLin\\Desktop\\");
        clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);

        System.out.println();
//        MyTest16 loader2 = new MyTest16(loader1, "loader2");
//        loader2.setPath("C:\\Users\\MrLin\\Desktop\\");
//
//        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
//        System.out.println("class:" + clazz.hashCode());
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2);
//
//        System.out.println();
//
//        MyTest16 loader3 = new MyTest16("loader3");
//        loader3.setPath("C:\\Users\\MrLin\\Desktop\\");
//
//        Class<?> clazz3 = loader3.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
//        System.out.println("class:" + clazz.hashCode());
//        Object object3 = clazz3.newInstance();
//        System.out.println(object2);
//
//        System.out.println();

    }
}
