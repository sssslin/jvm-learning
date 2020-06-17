package com.insideVM.chapter7;



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
        // 由不同的类加载器加载，所以即使是一样的class文件，由于命名空间不同，比对结果仍然是false
        Object obj = myLoader.loadClass("com.insideVM.chapter7.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.insideVM.chapter7.ClassLoaderTest);
    }
}
