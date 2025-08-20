import java.util.Scanner;

public class Method01 {
	public static void main (String[] args) {
		Person Jing = new Person();
		Jing.speak();  //调用方法
		Jing.cal01();
		Jing.cal02(99);
		int res03 = Jing.cal03(1, 100);
		System.out.println(res03);
	}
}

class Person {
	String name;
	int age;

	//声明方法
	public void speak() {
		System.out.println("我是好人");
	}

    public void cal01() {
        int res = 0;
        for(int i = 1; i <= 100; i++)
            res += i;
        System.out.println(res);
    }

    public void cal02(int n) {
    	int res = 0;
    	for(int i = 0; i <= n; i++)
    		res += i;
    	System.out.println(res);
    }

    public int cal03(int num1, int num2) {
    	int res = 0;
    	for(int i = num1; i <= num2; i++)
    		res += i;
    	return res;
    }
}