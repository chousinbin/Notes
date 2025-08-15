package com.sinbin.Extends;

/**
 * 讲解继承的本质
 */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();  //分析执行完这条语句的内存结构布局
        //根据查找关系返回数据
        System.out.println(son.name);  //大头儿子
        System.out.println(son.getAge());  //39
        System.out.println(son.hobby);  //旅游

    }
}
class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
    public int age = 66;
    //虽然这里个是公有的看似可以访问得到
    //但是子类Father中的age是私有的
    //访问到Father中的age查完权限发现无权限就停止了
    //所以不能访问的到Grandpa中的age
}
class Father extends GrandPa {
    String name = "大头爸爸";
    private int age = 39;


    public int getAge() {
        return age;
    }
}
class Son extends Father {
    String name = "大头儿子";
}