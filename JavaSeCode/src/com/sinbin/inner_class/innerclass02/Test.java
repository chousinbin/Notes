package com.sinbin.inner_class.innerclass02;

/**
 * @ClassName: Test
 * @Description:
 * 匿名内部类
 * @date: 2023-03-14 18:34
 */
public class Test {
    public static void main(String[] args) {
        new Outer().method();
    }
}

class Outer {
    public void method() {
        /*
        tiger的编译类型为IA
        tiger的运行类型为这个匿名内部类
        以下这个内部类相当于
        class Outer$1 implements IA{
            public void cry() {
                System.out.println("老虎叫");
            }
        }
         */
        IA tiger = new IA() {
            public void cry() {
                System.out.println("老虎叫");
            }
        };

        tiger.cry();

        //演示基于类的匿名内部类
        /*
        编译类型:CA
        运行类型:这个匿名内部类Outer$2
        匿名内部类实质
        class Outer$2 extends CA {

        }
         */
        CA ca = new CA() {
            @Override
            public void say() {
                System.out.println("Outer$2.say()");
            }
        };
        ca.say();
    }
}

interface IA {
    public void cry();
}

class CA {
    public void say() {
        System.out.println("CA.say()");
    }
}
