package com.sinbin.reflection_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/26 19:42
 * @Description:
 */
public class Cat {

    public String name = "招财猫";

    public Cat() {}

    public Cat(String name) {
        this.name = name;
    }
    public void hi(){
//        System.out.println("招财猫");
    }

    public void cry(){
        System.out.println("招财猫哭");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
