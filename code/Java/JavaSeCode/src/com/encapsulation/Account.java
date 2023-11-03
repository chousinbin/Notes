package com.encapsulation;

public class Account {
    private String name;
    private double balance;
    private String pass;

    public void setName(String name) {
        if(name.length() == 2 || name.length() == 3 || name.length() == 4) {
            this.name = name;
        } else {
            System.out.println("名字长度应在2~4");
            this.name = null;
        }
    }

    public void setBalance(double balance) {
        if(balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("余额应该大于20");
            this.balance = 0;
        }
    }

    public void setPass(String pass) {
        if(pass.length() == 6) {
            this.pass = pass;
        } else {
            System.out.println("密码长度应=6");
            this.pass = "000000";
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPass() {
        return pass;
    }
}
