package com.sinbin.inner_class.base;

/**
 * @ClassName: Base
 * @Description:
 * 局部内部类
 * @date: 2023-03-14 16:12
 */
public class Base {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m2();
    }
}

class Outer {
    private int n1;
    public void m1() {
        System.out.println("Outer.m1()");
    }

    public void m2() {
        class Inner01 {
            private int n1 = 800;

            public void m3() {
                m1();
                /*
                内部类属性和外部类属性同名时:
                遵循就近原则
                如果需要访问外部类的同名属性
                则通过外部类名.this.属性名 的方式访问
                 */
                System.out.println(n1);
                System.out.println(Outer.this.n1);
            }
        }

        Inner01 inner = new Inner01();

        inner.m3();
        System.out.println(inner.n1);
    }

//    public void m4() {
//        Inner01 inner = new Inner01();
//    }没有作用域

}
