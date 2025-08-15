package com.sinbin.exception_;

/**
 * @ClassName: HomeWork01
 * @UserName: SinBin
 * @date: 2023-04-02 19:40
 * @Description:
 */
public class HomeWork01 {
    public static void main(String[] args) {
        try {
            if(args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数错误");
            }

            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            int res = cal(n1, n2);

            System.out.println("结果=" + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("输入的数据类型不是整数");
        } catch (ArithmeticException e) {
            System.out.println("不能除0");
        }
    }

    static int cal(int n1, int n2) {
        return n1 / n2;
    }
}
