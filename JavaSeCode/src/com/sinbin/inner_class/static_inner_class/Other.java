package com.sinbin.inner_class.static_inner_class;

/**
 * @ClassName: Other
 * @Description:
 * @date: 2023-03-16 18:55
 */
public class Other {
    public static void main(String[] args) {
        Outer outer = new Outer();

        outer.getInnerPrivateStaticMember();

        //外部其他类调用静态内部类法一
        //因为静态内部类可以直接通过类名访问
        Outer.Inner inner01 = new Outer.Inner();
        inner01.method();
        //外部其他类调用静态内部类法二
        Outer.Inner inner02 = outer.getStaticInnerClassObject();
        inner02.method();
    }
}

class Outer {
    private static int num = 10;

    static class Inner {
        private static int num = 20;
        public void method() {
            System.out.println("外部类的静态属性=" + Outer.num);
        }
    }

    public void getInnerPrivateStaticMember() {
        Inner inner = new Inner();
        System.out.println("静态内部类的静态私有属性=" + inner.num);
        inner.method();
    }

    public Inner getStaticInnerClassObject() {
        return new Inner();
    }
}
