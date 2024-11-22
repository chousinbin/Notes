//1.把java.util下的Scanner类导入
import java.util.Scanner;
public class abc {
	public static void main (String[] args) {
		//2.创建Scanner对象
		Scanner myScanner = new Scanner(System.in);
		//3.使用相关的方法接收用户的输入
		String name = myScanner.next();
		int age = myScanner.nextInt();
		double sal = myScanner.nextDouble();
		
		System.out.println(name + " " + age + " " + sal);
	}
}