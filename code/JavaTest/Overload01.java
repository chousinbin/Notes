public class Overload01 {
    public static void main(String[] args) {
        MyCalculator Calculator = new MyCalculator();

        System.out.println(Calculator.calculate(1, 2));
        System.out.println(Calculator.calculate(1, 2.5));
        System.out.println(Calculator.calculate(1.8, 2));
        System.out.println(Calculator.calculate(1, 2, 3));
    }
}

class MyCalculator {
    //������֮��
    public int calculate(int n1, int n2) {
        return (n1 + n2);
    }
    //�����͸�����֮��
    public double calculate(int n1, double n2) {
        return (n1 + n2);
    }
    //������������֮��
    public double calculate(double n1, int n2) {
        return (n1 + n2);
    }
    //������֮��
    public int calculate(int n1, int n2, int n3) {
        return (n1 + n2 + n3);
    }
}