package com.insideVM.chapter10;

// 要使用自定义的注解处理器，但是书中的做法太古老
// 于是在idea上用SPI + maven pom + idea setting-Annotation processor设置:obtain processors from project classpath
// 参考文档：https://blog.csdn.net/ly199108171231/article/details/102394958
// 这样配置后，编译BADLY_NAMED_CODE这个类时才会出现各种警告
public class BADLY_NAMED_CODE {

    enum colors {
        red, blue, green;
    }

    static final int _FORTY_TWO = 42;

    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
        return;
    }

    protected void NOTcamelCASEmethodNAME() {
        return;
    }
}
