package com.sinbin.zeromoneycommunication;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import  java.util.Scanner;
/**
 * @ClassName: MoneyTest
 * @Description:
 * 零钱通
 * 收益, 消费, 查看明细, 退出系统
 * 面向过程的实现
 * @date: 2023-03-20 15:49
 */
public class MoneyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String choice;
        String choice2;
        String details = "";
        Date date = null;  //date是java.util.Date类型, 表示日期时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //可以用于日期格式化

        double money = 0;
        double balance = 0;

        while(loop) {
            System.out.println("=========零钱通系统========");
            System.out.println("\t\t1消费明细");
            System.out.println("\t\t2入   账");
            System.out.println("\t\t3消   费");
            System.out.println("\t\t4退出系统");
            System.out.println("=========================");
            System.out.print("请选择(1-4):");

            choice = scanner.next();

            switch(choice) {
                case "1":
                    System.out.println("=========消费明细========");
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("请输入入账的金额:");
                    money = scanner.nextDouble();

                    if(money <= 0) {
                        System.out.println("入账金额有误 需要大于0");
                        break;
                    }

                    System.out.println("入账了:" + money);

                    balance += money;

                    date = new Date();
                    System.out.println(sdf.format(date));  //把我们的date使用sdf的日期格式化输出

                    details += "收益入账\t" + "+" + money + "\t" + sdf.format(date) + "\t" + "余额" + balance + "\n";
                    break;
                case "3":
                    System.out.print("请输入消费的金额:");
                    money = scanner.nextDouble();

                    if(money <= 0 || balance < money) {
                        System.out.println("消费金额有误 需要在0.0 - " + balance);
                        break;
                    }

                    System.out.println("消费了:" + money);

                    balance -= money;

                    date = new Date();
                    System.out.println(sdf.format(date));

                    details += "收益消费\t" + "-" + money + "\t" + sdf.format(date) + "\t" + "余额" + balance + "\n";
                    break;
                case "4":
                    do {
                        System.out.print("确定退出系统?(y/N):");
                        choice2 = scanner.next();
                    } while(!choice2.equals("y") && !choice2.equals("N"));

                    if(choice2.equals("y")) {
                        System.out.println("退出系统中...");
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("输入选项有误重新输入");
            }
        }
    }
}
