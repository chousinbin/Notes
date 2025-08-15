package com.sinbin.test;

public class test {
    public static void main(String[] args) {
        String[] hobbys = {"111", "222", "333"};
        String hobby = "";
        for(int i = 0; i < 3; i++) {
            hobby += hobbys[i];
            hobby += " ";
        }
        System.out.println(hobby);
    }
}
