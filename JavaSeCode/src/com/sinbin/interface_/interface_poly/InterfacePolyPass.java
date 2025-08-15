package com.sinbin.interface_.interface_poly;

/**
 * @ClassName: InterfacePolyPass
 * @Description:
 * @date: 2023-03-12 19:08
 */
public class InterfacePolyPass {
    public static void main(String[] args) {
        I1 i1 = new C1();
        //如果类C1实现了接口I2
        //并且接口I2继承了接口I1
        //那么相当于类C1也实现了接口I1
    }
}

interface I1 {}
interface I2 extends I1 {}
class C1 implements I2 {}