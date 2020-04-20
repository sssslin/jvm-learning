package com.shengsiyuan.jvm.memory;

/*
    虚拟机栈: Stack Frame 栈帧---访问堆的方式有两种,句柄或者直接指向;栈帧我理解为阉割版的指针,只能指向,不能操作---线程私有
    程序计数器(Program Counter):---线程私有
    本地方法栈:主要用于执行本地(native)方法---在Oracle公司实现的hotpot JVM中,本地方法栈和虚拟机栈是合二为一的.
    堆(heap): JVM管理的最大的一块内存房间,与堆相关的一个重要概念是垃圾收集器.现代几乎所有的垃圾收集器都是采用分代收集算法.
    所以,堆空间基于这一点进行了划分.新生代与老年代.Eden空间,  From Survivor空间与To Survivor空间.

    方法区(Method Area): 存储元信息(Meta data).永久代(Permanent Generation),从JDK 1.8开始,彻底废弃了永久代
    使用元空间(meta space)代替

    运行时常量池:方法区的一部分内容.
    直接内存:Direct Memory, 与java NIO 密切相关的.JVM通过堆上的DirectByteBuffer来操作直接内存.
 */
public class MyTest1 {
}
