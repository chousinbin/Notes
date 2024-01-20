package com.DJTU_Java;

/**
 * @ClassName: TestBankAccount
 * @UserName: SinBin
 * @date: 2023-04-10 12:57
 * @Description:
 */
public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(123456, 500);
        bankAccount.saveMoney(1000);
        bankAccount.getLeftMoney();
        bankAccount.getMoney(2000);
        bankAccount.getLeftMoney();
    }
}

class BankAccount {
    private int account_number;
    private double left_money;

    public void saveMoney(double money) {
        System.out.println("存入了" + money);
        left_money += money;
    }

    public void getMoney(double money) {
//        if(left_money < money) {
//            System.out.println("当前余额不足,取钱失败!");
//            return;
//        }
        System.out.println("取出了" + money);
        left_money -= money;
    }

    public void getLeftMoney() {
        System.out.println("当前余额 = " + left_money);
    }

    public BankAccount(int account_number, double left_money) {
        this.account_number = account_number;
        this.left_money = left_money;
    }
}
