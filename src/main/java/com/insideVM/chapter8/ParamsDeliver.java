package com.insideVM.chapter8;

/**
 * Java的参数传递机制很简单，其实就是值传递。
 * 所谓值传递，也就是我们在给方法传递一个参数的时，传递的是该参数的一个拷贝而不是参数本身。
 * ​基本类型变量的传参，前面已经说了，意味着变量被拷贝，然后将拷贝的值传给方法。所以无论方法如何操作，方法也不会影响到原变量。
 */
public class ParamsDeliver {

    public static void main(String[] args) {
        int a = 1;
        Test t1 = new Test();
        t1.changeNum(a);
        System.out.println(a);

    }

}
class Test{
    public void changeNum(int i) {
        i = 0;
    }
}
