package com.insideVM.chapter7;

import sun.security.util.Length;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author junfeng.ling
 * @date 2020/3/23 14:19
 * @Description:
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0 ,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object obj = myLoader.loadClass("com.insideVM.chapter7.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.insideVM.chapter7.ClassLoaderTest);
    }
}
