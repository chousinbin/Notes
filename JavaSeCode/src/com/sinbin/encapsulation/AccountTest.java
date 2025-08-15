package com.sinbin.encapsulation;

public class AccountTest {
    public static void main(String[] args) {
        Account p1 = new Account();
        p1.setName("Bin");
        p1.setBalance(99.99);
        p1.setPass("123456");

        System.out.println(p1.getName());
        System.out.println(p1.getBalance());
        System.out.println(p1.getPass());
    }
}
