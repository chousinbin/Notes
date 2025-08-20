package com.sinbin.polymorphic.poly3;

public class test {
    public static void main(String[] args) {
        //多态的向上转型
        Animal animal = new Cat();
        animal.eat();
        animal.run();
        animal.show();
        animal.sleep();

        //多态的向下转型
        //cat的编译类型Cat, 运行类型Cat
        Cat cat = (Cat) animal;
        cat.catchMouse();  //能访问特有成员了
        cat.eat();
        cat.run();
        cat.show();
        cat.sleep();
    }
}
