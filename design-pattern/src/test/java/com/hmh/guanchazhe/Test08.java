package com.hmh.guanchazhe;

import java.util.*;

public class Test08 {
    public static void main(String[] args) {
        // Vector的基本使用代码不再演示，参考Test06的ArrayList代码

        // 如何将一个非线程安全的ArrayList转换成线程安全的ArrayList
        List list = new ArrayList();  // 这是一个非线程安全的ArrayList

        // 调用Collections.synchronizedList(list<Object> list)方法
        Collections.synchronizedList(list);  // list已经是线程安全的了

        // 还没有学线程和多线程的情况下，这里就暂时不看效果了

    }
}
