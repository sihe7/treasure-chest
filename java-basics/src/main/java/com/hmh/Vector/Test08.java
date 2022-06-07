package com.hmh.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08 {
    /**
     * 关于Vector集合的使用：
     * 1、Vector也实现了List接口，和ArrayList用法基本相同。
     * 这里我们对比着学习Vector。
     *
     * 2、Vector和ArrayList一样，底层也是一个Object类型的数组Object[]。
     *
     * 3、ArrayList的无参数构造默认数组容量是10，Vector的默认容量也是10。
     *
     * 4、Vector和ArrayList构建时一样，都可以指定容量的大小。
     * 使用有参数的构造方法，传一个int型参数，指定容量。
     *
     * 5、当集合容量不够用时，Vector和ArrayList一样，都会实现自动扩容。（可以参考源代码）
     *
     * ArrayList集合的自动扩容的新容量是原来的1.5倍。
     * Vector集合的自动扩容的新容量是原来的2倍。
     *
     * 6、Vector和ArrayList集合都实现了List接口，遍历方式都有3种：
     *
     * 通过获取迭代器遍历
     * 通过下标完成遍历
     * 通过增强for循环，foreach遍历
     * 7、ArrayList是非线程安全的，方法没有使用synchronized修饰符修饰。
     *
     * 而Vector是线程安全的，方法都用了synchronized修饰符修饰。
     *
     * 但Vector线程安全反而效率很低，没有ArrayList集合用的多。
     *
     * Vector的基本测试代码跟ArrayList一样，参考ArrayList：ArrayList的使用
     *
     * 8、如何将非线程安全的List转成线程安全的List？
     *
     * 使用Collections.synchronizedList(list list)方法
     * ————————————————
     * @param args
     */
    public static void main(String[] args) {
        // Vector的基本使用代码不再演示，参考Test06的ArrayList代码

        // 如何将一个非线程安全的ArrayList转换成线程安全的ArrayList
        List list = new ArrayList();  // 这是一个非线程安全的ArrayList

        // 调用Collections.synchronizedList(list<Object> list)方法
        Collections.synchronizedList(list);  // list已经是线程安全的了

        // 还没有学线程和多线程的情况下，这里就暂时不看效果了
        System.out.println("===");

    }
}
