package com.sinbin.inner_class.innerclass02;

/**
 * @ClassName: AnonyInnerClass
 * @Description:
 * @date: 2023-03-15 15:18
 */
public class AnonyInnerClass {
    public static void main(String[] args) {
        new OuterClass().method();
    }
}

class OuterClass {
    public void method() {
        /*
        接收调用匿名内部类的方法
         */
        Person p = new Person() {
            @Override
            public void say() {
                System.out.println("OuterClass$1.say()");
            }
        };
        p.say();
        /*
        直接调用内部类的方法
        因为匿名内部类在加载的时候就自动返回了对象实例
        并且之后不再实例新的对象, 仅仅实例这一次
         */
        new Person() {
            @Override
            public void say() {
                System.out.println("直接调用");
            }
        }.say();
    }
}
class Person {
    String name;
    public void say() {
        System.out.println("Person.say()");
    }
}
