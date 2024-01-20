package com.exception_.try_;

import com.exception_.runningexception.ArrayIndexOutOfBounds;

/**
 * @ClassName: Exercise
 * @UserName: SinBin
 * @date: 2023-04-02 15:08
 * @Description:
 */
public class Exercise {
    public static void main(String[] args) {
        System.out.println(method());
        System.out.println(method2());

    }
    public static int method() {
        int i = 1;
        try {
            i++;  //i=2
            String[] str = new String[3];
            if(str[0].equals("Tom")) {  //空指针异常
                System.out.println(str[0]);
            }else {
                str[3] = "Jack";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return ++i;
        } catch (NullPointerException e) {
            return ++i; //有finally必须执行finally, 这里不返回值, 但是会进行++i的运算,所以i=3
        } finally {
            return ++i;  //i=4
        }
    }

    public static int method2() {
        int i = 1;
        try {
            i++;  //i=2
            String[] str = new String[3];
            if(str[0].equals("Tom")) {  //空指针异常
                System.out.println(str[0]);
            }else {
                str[3] = "Jack";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return ++i;
        } catch (NullPointerException e) {
            return ++i;
            /*
            i = 3,用临时变量temp保存3,执行完finally最后返回temp
             */
        } finally {
            i++;  //i=4
            System.out.println("i=" + i);  //"i=4"
        }
        return 0;
    }
}
