public class Scope {
    public static void main(String[] args) {
        S s1 = new S();
        s1.say();
    }
}

class S {
    String name = "Jing";  //全局变量:作用域为整个类S中
    public void say() {
        int score = 10;  //局部变量:作用域为整个方法say中
        String name = "Bin";
        System.out.println("sayName = " + name);
    }
    
}
