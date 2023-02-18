package com.usr;  //类在包中后 每个类代码第一行自动显示

import com.bin.Person;  //引入包中的类 同名类最多引入一个

public class test {
    public static void main(String[] args) {
        //由于com.bin.Person类被引入 所以可以省略所在包前缀
        Person person1 = new Person();
        System.out.println(person1);

        //没被引入的类 使用时必须要有所在包前缀
        com.jing.Person person2 = new com.jing.Person();
        System.out.println(person2);
    }
}
