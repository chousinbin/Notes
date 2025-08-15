package com.sinbin.polymorphic.poly1;

public class test {
    public static void main(String[] args) {
        Master bin = new Master("斌");

        Dog dog1 = new Dog("旺旺");
        Bone bone1 = new Bone("猪排");
        bin.feed(dog1, bone1);

        Cat cat = new Cat("英短");
        Fish fish = new Fish("草鱼");
        bin.feed(cat, fish);

        Pig pig = new Pig("八戒");
        Rice rice = new Rice("米饭");
        bin.feed(pig, rice);


    }
}
