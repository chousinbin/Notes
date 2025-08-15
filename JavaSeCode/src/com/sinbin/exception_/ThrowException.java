package com.sinbin.exception_;

/**
 * @ClassName: ThrowException
 * @UserName: SinBin
 * @date: 2023-04-02 19:23
 * @Description:
 */
public class ThrowException {
    public static void main(String[] args) {
        try {
            ReturnExceptionDemo.methodA();
        } catch (Exception e) {  //e就是ReturnExceptionDemo.methodA中传来的异常
            System.out.println(e.getMessage());  //3
        }
        ReturnExceptionDemo.methodB();
    }
}

class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");  //1
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("methodA()的finally");  //2
        }
    }

    static void methodB() {
        try {
            System.out.println("进入方法B");  //4
            return;
        } finally {
            System.out.println("methodB()的finally");  //5
        }
    }
}
