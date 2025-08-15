class BankAccount {
    private String account_number;
    private double leftmoney;

    public BankAccount(String account_number, double leftmoney) {
        this.account_number = account_number;
        this.leftmoney = leftmoney;
    }

    public void savemoney(double money) {
        leftmoney += money;
        System.out.println("成功存入" + money + "元，当前余额为：" + leftmoney);    
    }

    public void getmoney(double money) {
        if (leftmoney >= money) {
            leftmoney -= money;
            System.out.println("成功取出" + money + "元，当前余额为：" + leftmoney);
        } else {
            System.out.println("余额不足，无法取款！");
        }
    }

    public double getleftmoney() {
        return leftmoney;
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("123456", 500);
        ba.savemoney(1000);
        ba.getmoney(2000);
    }
}