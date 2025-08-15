package com.sinbin.generics_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/22 15:20
 * @Description:
 */
public class CustomGenericsClass {
    public static void main(String[] args) {
        Tiger<Double, String, Integer> tiger = new Tiger();
//        tiger.setT("AA");
        Tiger tiger1 = new Tiger();
        tiger1.setT("AA");
    }
}

class Tiger<T, R, M> {
    String name;
    // 属性使用泛型
    T t;
    R r;
    M m;
    T[] ts;
    // 泛型的数组不能直接实例化
    // T[] tt = new T[8];

    public Tiger() {}
    // 方法的参数使用泛型
    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 方法的返回类型使用泛型
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}
