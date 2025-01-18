package com.sinbin.inner_class.exercise;

/**
 * @ClassName: Exercise01
 * @Description:
 * 匿名内部类的练习
 * @date: 2023-03-18 22:51
 */
public class Exercise01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.testWork(new ICalculate() {
            @Override
            public int work(int n1, int n2) {
                return n1 + n2;
            }
        }, 1, 2);

        phone.testWork(new ICalculate() {
            @Override
            public int work(int n1, int n2) {
                return n1 * n2;
            }
        }, 3, 4);
    }
}

interface ICalculate {
    public int work(int n1, int n2);
}

class Phone {
    public void testWork(ICalculate calculate, int n1, int n2) {
        int result = calculate.work(n1, n2);
        System.out.println("计算结果=" + result);
    }
}
