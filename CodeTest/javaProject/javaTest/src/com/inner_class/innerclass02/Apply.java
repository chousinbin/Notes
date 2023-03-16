package com.inner_class.innerclass02;

/**
 * @ClassName: Apply
 * @Description:
 * 匿名内部类的最佳实践
 * 把匿名内部类当做实参直接传递间接高效
 * @date: 2023-03-15 16:09
 */
public class Apply {
    public static void main(String[] args) {
        /*
        需求:使用一次调用方法
         */

        //把匿名内部类当做实参
        f1(new Pic() {
            @Override
            public void say() {
                System.out.println("修改后的输出");
            }
        });

        //传统方法
        f1(new Picture());


    }

    public static void f1(Pic p) {
        p.say();
    }
}

interface Pic {
    public void say();
}

class Picture implements Pic{
    @Override
    public void say() {
        System.out.println("输出");
    }
}