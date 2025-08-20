package com.sinbin.super_;

/**
 * 方法或属性重名 super,this与直接访问的案例
 */
public class test3 {
    public static void main(String[] args) {
        BB bb = new BB();

        bb.useCal();
        bb.useSum();

        System.out.println(bb.getN1());

    }
}

class AA {
    int n1 = 888;
    public void cal() {
        System.out.println("cal() in AA");
    }
    public void sum() {
        System.out.println("sum() in AA");
    }
}

class BB extends AA {
    int n1 =88;

    public void cal() {
        System.out.println("cal() in BB");
    }
    public void useCal() {
        //因为cal()没有重名的方法/属性
        //所有可以使用任意三种方式调用cal()
        this.cal();
        cal();
        super.cal();  //直接查找父类
    }
    public void useSum() {
        sum();
        this.sum();
        super.sum();
    }

    public int getN1() {
        return super.n1;
    }
}

