public class Recursion01 {
    public static void main(String[] args) {
        Tools t1 = new Tools();

        int res = t1.factorial(5);
        System.out.println(res);
    }
    
}

class Tools {
    public int factorial(int n) {
        if(n == 1) return 1;
        else return factorial(n - 1) * n;
    }
}

