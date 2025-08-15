public class MethodDetail {
    public static void main (String[] args) {
        B ans = new B();
        ans.print2();
    }
}

class A {  //同类调用方法
    
    public void print(int n) {
        System.out.println("n=" + n);
    }
    public void sayOk() {
        print(10);
    }
}

class B {  //跨类调用方法
    public void print2() {
        A a = new A();
        a.print(20);
    }
}