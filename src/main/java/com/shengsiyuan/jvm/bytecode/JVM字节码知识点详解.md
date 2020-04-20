# JVM字节码知识点详解

## Code结构

- attribute_length表示attribute所包含的字节数,不包含attribute_name_index和attribute_length字段
- max_stack表示这个方法运行的任何时刻所能达到的操作数栈的最大深度
- max_lcoals表示方法执行期间创建的局部变量的书目,包含用来表示传入的参数的局部变量



- start_pc和end_pc表示在code数组中的从start_pc和end_pc处(包含start_pc,不包含end_pc)的指令抛出的异常会由这个表项来处理
- handler_pc表示处理异常的代码的开始处，catch_type表示会被处理的异常类型，它指向常量池里的一个异常类。当catch_type为0时，表示处理所有的异常。





### 问题:一个class字节码文件能不能没有init方法?

解答:可以没有,首先,规范里并没有要求method中一定要有init方法,第二,一个接口的字节码就没有init方法.

简单的做了一个实验,发现抽象类还是有init方法的,但是接口是没有的



那么,为什么要这么设计呢?构造器的作用是什么?抽象类有构造器,但是为什么还是不能被new出来?