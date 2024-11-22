package com.zeromoneycommunication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName: SmallChangeSysOOP
 * @Description:
 * @date: 2023-03-20 20:05
 */
public class SmallChangeSysOOP {
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //可以用于日期格式化

    boolean loop = true;
    String key;
    String choice;
    String details = "";
    Date date = null;  //date是java.util.Date类型, 表示日期时间


    double money = 0;
    double balance = 0;


    public void mainMenu() {
        while (loop) {
            System.out.println("=========零钱通菜单========");
            System.out.println("\t\t1 消费明细");
            System.out.println("\t\t2 入   账");
            System.out.println("\t\t3 消   费");
            System.out.println("\t\t4 退出系统");
            System.out.println("=========================");
            System.out.print("请选择(1-4):");

            key = scanner.next();
            switch (key) {
                case "1":
                    getDetails();
                    break;
                case "2":
                    income();
                    break;
                case "3":
                    pay();
                    break;
                case "4":
                    stop();
                    break;
                default:
                    System.out.println("输入选项有误重新输入");
            }
        }
    }
    public void getDetails() {
        System.out.println(details);
    }
    public void income() {
        System.out.print("入账金额:");
        money = scanner.nextDouble();

        if(money <= 0) {
            System.out.println("入账金额有误 需要大于0");
            return;
        }

        System.out.println("入账了:" + money);

        balance += money;

        date = new Date();
        System.out.println(sdf.format(date));  //把我们的date使用sdf的日期格式化输出

        details += "收益入账\t" + "+" + money + "\t" + sdf.format(date) + "\t" + "余额" + balance + "\n";
    }

    public void pay() {
        System.out.print("支出金额:");

        money = scanner.nextDouble();

        if(money <= 0 || balance < money) {
            System.out.println("消费金额有误 需要在0.0 - " + balance);
            return;
        }

        System.out.println("消费了:" + money);

        balance -= money;

        date = new Date();
        System.out.println(sdf.format(date));

        details += "收益消费\t" + "-" + money + "\t" + sdf.format(date) + "\t" + "余额" + balance + "\n";
    }

    public void stop() {
        do {
            System.out.print("确定退出系统?(y/N):");
            choice = scanner.next();
        } while(!choice.equals("y") && !choice.equals("N"));

        if(choice.equals("y")) {
            System.out.println("退出系统中...");
            loop = false;
        }
    }
}
