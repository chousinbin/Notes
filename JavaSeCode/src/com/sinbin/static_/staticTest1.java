package com.sinbin.static_;

/**
 * @ClassName: staticTest1
 * @Description:
 * @date: 2023-03-07 18:57
 */
public class staticTest1 {
    public static void main(String[] args) {
        People p1 = new People();
        People p2 = new People("bin");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(People.num);
    }
}

class People {
    private String name;
    private int id;

    static int init = 1001;  //初始编号
    static int num = 0;  //记录创建的People实例个数

    public People() {
        this.id = init;
        init++;
        num++;
    }

    public People(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
