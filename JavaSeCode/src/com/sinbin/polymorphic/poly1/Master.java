package com.sinbin.polymorphic.poly1;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //方法重载调用feed
//    public void feed(Dog dog, Bone bone) {
//        System.out.println("主人" + name + "给" +
//                dog.getName() + "喂" + bone.getName());
//    }
//    public void feed(Cat cat, Fish fish) {
//        System.out.println("主人" + name + "给" +
//                cat.getName() + "喂" + fish.getName());
//    }
//    public void feed(Pig pig, Rice rice) {
//        System.out.println("主人" + name + "给" +
//                pig.getName() + "喂" + rice.getName());
//    }
    //通过以上代码可以发现随着程序的动物和食物增多
    //代码量也随之增多 不利于管理与维护

    //使用多态机制, 可以统一管理主人喂食问题
    //animal 编译类型是Animal, 可以指向接收Animal子类对象
    //food 编译类型是Food, 可以指向接收Food子类对象
    public void feed(Animal animal, Food food) {
        System.out.println("主人" + name + "给" +
                animal.getName() + "喂" + food.getName());
    }

}
