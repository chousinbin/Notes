package com.sinbin.exception_.try_;

/**
 * @ClassName: Test02
 * @UserName: SinBin
 * @date: 2023-04-02 14:38
 * @Description:
 * 演示多个catch语句
 */
public class Test02 {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            //person = null;
            System.out.println(person.name);

            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }catch (NullPointerException e) {
            System.out.println("空指针异常:" + e.getMessage());
        }catch (ArithmeticException e) {
            System.out.println("算数异常:" + e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class Person {
    String name = "jack";
}