public class MethodTest01 {
    public static void main(String[] args) {
        AA a = new AA();
        Boolean res = a.isOdd(9);
        System.out.println(res);
    }
}

class AA {
    public boolean isOdd(int n) {
        if(n % 2 == 0) return true;
        else return false;
    }
}
