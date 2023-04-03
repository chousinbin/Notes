package com.annotation;

/**
 * @ClassName: Test
 * @Description:
 * @date: 2023-03-18 20:09
 */
public class Test {
    public static void main(String[] args) {
        C c = new C();

    }
}

class A {
    public void hi() {

    }
}
@SuppressWarnings({""})
class B extends A {
    @Override
    public void hi() {

    }
}
@Deprecated
class C {

}