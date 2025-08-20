package com.sinbin.DJTU_Java;

/**
 * @ClassName: test1
 * @UserName: SinBin
 * @date: 2023-05-15 16:14
 * @Description:
 */
public class test1 {
    public static void main(String[] args) {

    }
}

interface I1 {
    default public int f1() {
        return 0;
    }
}

class A {
    double f1(int x, int y) {
        return 0;
    }
}

class B extends A {
    //缩小返回类型范围的重写
//    int f1(int x, int y) {
//        return 0;
//    }
}
