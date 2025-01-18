package com.sinbin.polymorphic.poly2;

public class PolyObject {
    public static void main(String[] args) {
        //对象animal
        //编译类型是Animal
        //运行类型是Dog
        Animal animal = new Dog();
        //执行要看运行类型
        //运行时, 执行到改行, animal的运行类型是Dog
        //所以结果是Dog cry()
        animal.cry();  //"Dog cry()"

        //animal这个类对象名此时
        //指向堆中的猫对象
        //运行的时候就看Cat对象
        animal = new Cat();
        animal.cry();  //"Cat cry()"


    }
}

class Animal {
    public void cry() {
        System.out.println("Animal cry()");
    }
}
class Cat extends Animal {
    public void cry() {
        System.out.println("Cat cry()");
    }
}
class Dog extends Animal {
    public void cry() {
        System.out.println("Dog cry()");
    }
}
