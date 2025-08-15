package com.sinbin.exception_;

/**
 * @ClassName: CustomException
 * @UserName: SinBin
 * @date: 2023-04-02 19:05
 * @Description:接收Person对象年龄时,要求范围在18-120之间,否则抛出自定义异常,并给出提示信息
 */
public class CustomException {
    public static void main(String[] args) {
        int age = 800;

        if(age < 18 || age > 120) {
            throw new AgeException("输入应在18-120之间");
        }

        System.out.println("输入范围正确");
    }
}
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}