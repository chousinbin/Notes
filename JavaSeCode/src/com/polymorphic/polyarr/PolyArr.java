package com.polymorphic.polyarr;

/**
 * @ClassName: PolyArr
 * @Description: 创建一个P对象两个S对象两个T对象, 统一放在数组中, 并调用每个say方法
 * @date: 2023-02-23 11:26
 */
public class PolyArr {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("a1", 11);
        persons[1] = new Student("a2", 22, 100);
        persons[2] = new Student("a3" , 23, 200);
        persons[3] = new Teacher("a4", 30, 3000);
        persons[4] = new Teacher("a5", 34, 4000);

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());
            //persons[1].study();
            //persons[3].teach();
            //这里无法访问到子类的特有属性
            //我们采用instanceof类型判断+向下转型
            if(persons[i] instanceof Student) {
                ((Student) persons[i]).study();
            } else if(persons[i] instanceof Teacher) {
                ((Teacher)persons[i]).teach();
            } else if(persons[i] instanceof Person) {
                //不做处理
            } else {
                System.out.println("对象类型有误 无法能调用独有方法");
            }
        }

    }
}
