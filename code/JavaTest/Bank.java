class BankAccount {
    private String account_number;
    private double leftmoney;

    public BankAccount(String account_number, double leftmoney) {
        this.account_number = account_number;
        this.leftmoney = leftmoney;
    }

    public void savemoney(double money) {
        leftmoney += money;
        System.out.println("�ɹ�����" + money + "Ԫ����ǰ���Ϊ��" + leftmoney);    
    }

    public void getmoney(double money) {
        if (leftmoney >= money) {
            leftmoney -= money;
            System.out.println("�ɹ�ȡ��" + money + "Ԫ����ǰ���Ϊ��" + leftmoney);
        } else {
            System.out.println("���㣬�޷�ȡ�");
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