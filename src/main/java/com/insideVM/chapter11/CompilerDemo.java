package com.insideVM.chapter11;

/**
 * @author junfeng.ling
 * @date 2020/7/3 11:39
 * @Description:
 * VM 参数
 * -XX:+PrintCompilation
 * -XX:+UnlockDiagnosticVMOptions(必须放在下面这个参数前面，不然会报错)
 * -XX:+PrintInlining
 * -XX:+PrintOptoAssembly 只有在debug版本的VM下才能运行
 * 在windows下的小伙伴可以从这里下载openjdk的debug版本：
 * https://github.com/ojdkbuild/ojdkbuild/releases
 * https://blog.csdn.net/VimGuy/article/details/82080711
 * Ideal Graph Visulizer：http://ssw.jku.at/General/Staff/TW/igv.html，貌似只支持JDK6和JDK7
 */
public class CompilerDemo {

    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        // 这个空循环用于后面演示JIT代码优化过程
        for (int j = 0; j < 10000; j++) ;
        return i * 2;
    }

    public static long calcSum() {
        long sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += doubleValue(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }
}
