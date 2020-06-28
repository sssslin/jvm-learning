package com.insideVM.chapter8;

/**
 * 字段不参与多态
 * 在多态的情况下，声明为父类类型的引用变量只能调用父类中的方法，但如果此变量实际引用的是子类对象，而子类对象中覆盖了父类的方法，这时父类对象调用的是子类中的方法，
 * 这种机制就成为虚方法调用。所以，同样的两个引用变量调用相同的方法结果可能不同。
 *
 * https://blog.csdn.net/yulinyige/article/details/22826773
 * 在子类执行构造函数的之前，将先执行父类的构造函数，且由于虚方法调用机制，所以第一句输出的money值为0
 * 这类题目考察的其实是多态以及虚拟机层面的机制问题
 */
public class FieldHasNoPolymorphic {

    static class   Father {

        public int money = 1;

        public Father () {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney () {
            System.out.println("I am Father, i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son  () {
            money = 4;
            showMeTheMoney();
        }

        public void showMeTheMoney () {
            System.out.println("I am Son, i have $" + money);
        }
    }

    public static void main(String[] args) {
        Father gay = new Son();
        System.out.println("This  gay has $"  + gay.money);
    }

}
