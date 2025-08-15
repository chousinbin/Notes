package com.sinbin.inner_class.member_inner_class;

/**
 * @ClassName: Test
 * @Description:
 * 成员内部类
 * @date: 2023-03-16 17:33
 */
public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        //外部其他类调用内部类法一
        Outer.Inner inner1 = outer.new Inner();
        inner1.method();

        //外部其他类调用内部类法二
        Outer.Inner inner2 = outer.returnObject();
        inner2.method();
    }
}

class Outer {
    private String name;

    public class Inner {
        private String name = "Bin";
        private int a = 10;
        public void method() {
            System.out.println(name);
        }
    }

    public void useInner() {
        Inner inner = new Inner();
        inner.method();
        System.out.println(inner.a);
    }

    public Inner returnObject() {
        return new Inner();
    }
}
