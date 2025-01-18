package com.sinbin.object_;

/**
 * @ClassName: equals1
 * @Description:
 * @date: 2023-03-06 16:19
 */
public class equals1 {
    public static void main(String[] args) {
        Integer integer1 = new Integer(100);
        Integer integer2 = new Integer(100);
        System.out.println(integer1 == integer2);  //false
        System.out.println(integer1.equals(integer2)); //true
    }
}
