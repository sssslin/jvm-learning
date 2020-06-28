package com.insideVM.chapter8;

// 当传入对象引用时

/**
 * 引用的值传递，就是赋值对象的地址传递给Java方法，那么JVM就会寻址找到该对象，所以该方法根据引用的方法会影响对象本身。
 */
public class ParamsDeliver2{
    public static void main(String[] args) {
        Num a = new Num();
        Test b = new Test();
        b.changeNum(a);
        System.out.println(a.k);
    }
    static class Test{
        public void changeNum(Num i) {
            i.k = 0;;
        }
}

    static class Num{
        public int k = 1;
    }

}