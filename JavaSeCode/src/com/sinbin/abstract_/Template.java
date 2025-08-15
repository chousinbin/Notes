package com.sinbin.abstract_;

/**
 * @ClassName: Template
 * @Description:
 * 本类为抽象类
 * 子类Sub继承本类
 * 不同子类有不同的计算任务
 * 本抽象父类计算出不同子类计算任务所耗时间
 * @date: 2023-03-09 17:52
 */
abstract public class Template {
    public abstract void job();

    public void calculateTime() {
        long startTime = System.currentTimeMillis();
        job();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime));
    }
}
