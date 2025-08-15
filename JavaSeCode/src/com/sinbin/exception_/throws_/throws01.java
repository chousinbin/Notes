package com.sinbin.exception_.throws_;

/**
 * @ClassName: throws01
 * @UserName: SinBin
 * @date: 2023-04-02 15:58
 * @Description:
 * f1()方法内的异常通过throws抛给调用者main()
 * 在main()中使用try-catch处理异常, 最终程序能继续执行
 * 如果在main()中不处理异常, 就会一直把异常向上隐式抛给JVM, 然后中断程序
 */
public class throws01 {
    public static void main(String[] args) {
        //f1();
        try {
            f1();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("程序继续执行");
    }

    public static void f1() throws ArithmeticException{
        int n1 = 10;
        int n2 = 0;
        System.out.println(n1 / n2);
    }
}
