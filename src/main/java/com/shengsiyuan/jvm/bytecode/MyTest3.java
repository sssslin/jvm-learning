package com.shengsiyuan.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/*
    对于Java类中的每一个实例方法(非static方法),其在编译后生成的字节码中,方法参数的数量总是会比源代码中方法
    参数的数量多一个(this),它位于方法的第一个参数处;这样,我们就可以在Java的实例方法中使用this去访问当前对象
    的属性以及其他方法.

    这个操作是在编译期间完成的,即由javac编译器在编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的
    访问;接下来在运行期间,由JVM在调用实例方法时,自动向实例方法传入该this参数.所以,在实例方法的局部变量表中,至少
    会有一个指向当前对象的局部变量
 */

// Java字节码对于异常的处理方式：
/*
    1.统一采用异常表的方式来对异常进行处理
    2.在jdk 1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式
    3.当异常处理存在finally语句块时，现代化的JVM采取的处理方式是将finally语句块的字节码拼接到每一个catch块后面，换句话说，程序中存在多少
    个catch块，，就会在每一个catch块后面重复多少个finally语句块的字节码
 */
public class MyTest3 {

    public void test() throws IOException, FileNotFoundException, NullPointerException  {
        // 4个局部变量分别为:this, is, serverSocket+3个ex中的一个
        // 实际运行中如果没有异常,则最终的局部变量则为3个局部变量
        try {
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (Exception ex) {

        } finally {
            System.out.println("finally");
        }
    }
}
