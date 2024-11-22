package com.generics_;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/22 19:01
 * @Description:
 */
public class GenericsExtends {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<A> list3 = new ArrayList<>();
        List<B> list4 = new ArrayList<>();
        List<C> list5 = new ArrayList<>();

        fun1(list1);
        fun1(list2);
        fun1(list3);
        fun1(list4);
        fun1(list5);

//        fun2(list1);
//        fun2(list2);
        fun2(list3);
        fun2(list4);
        fun2(list5);

        fun3(list1);
//        fun3(list2);
        fun3(list3);
        fun3(list4);
        fun3(list5);
    }
    // Object
    public static void fun1(List<?> list) {

    }
    // A B C
    public static void fun2(List<? extends A> list) {

    }
    // C B A Object
    public static void fun3(List<? super C> list) {

    }
}

class A {

}

class B extends A {

}

class C extends B {

}
