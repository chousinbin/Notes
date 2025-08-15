public class Recursion01 {
    public static void main(String[] args) {
        Tools t1 = new Tools();

        int res = t1.factorial(5);
        System.out.println(res);
        
        int ans = t1.shulie(6);
        System.out.println("ans等于" + ans);
    }
}

class Tools {
    //阶乘
    public int factorial(int n) {
        if(n == 1) return 1;
        else return factorial(n - 1) * n;
    }
    //斐波那契数列
    public int shulie(int n) {
        if(n == 1 || n == 2) return 1;
        else return (shulie(n - 1) + shulie(n - 2));
    }
}