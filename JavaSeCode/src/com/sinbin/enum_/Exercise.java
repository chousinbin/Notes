package com.sinbin.enum_;

/**
 * @ClassName: Exercise
 * @Description:
 * @date: 2023-03-18 15:40
 */
public class Exercise {
    public static void main(String[] args) {
        Gender boy = Gender.BOY;
        Gender boy2 = Gender.BOY;


        System.out.println(boy);  //Enum的toString() return name;所以输出BOY
        System.out.println(boy == boy2);  //T
    }
}

enum Gender {
    BOY, GIRL;
}
