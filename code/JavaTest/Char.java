public class Char {
	public static void main(String[] args) {
        //在Java中char就是整数 遵循Unicode编码规则
		char c1 = 97;  
        char c2 = 'a';
        System.out.println(c1);
		System.out.println((int)c2);  //强制转换
        
        //char运算
        System.out.println('a' + 10);  //'k';
	}
}