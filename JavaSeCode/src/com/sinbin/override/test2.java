package com.sinbin.override;

public class test2 {
    public static void main(String[] args) {
        Person person = new Person("abc", 18);
        System.out.println(person.say());
        Student student = new Student("Bin", 20, "2118140201", 570);
        System.out.println(student.say());

    }
}
