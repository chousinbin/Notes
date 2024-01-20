public class object01 {
	public static void main (String[] args) {
		//1. new Peo(); 创建一个Peo类的对象
		//2. Peo cat1 = new Peo(); 把创建的对象赋给cat1
		Peo peo1 = new Peo();  //实例化一个Peo类的对象cat1
		
        peo1.name = "Jing";
		peo1.age = 18;
		peo1.weight = "55";

		System.out.println(peo1.name + " " + peo1.age + " " + peo1.weight);
        
        Peo peo2 = peo1;
        System.out.println("peo2.age=" + peo2.age);
	}
}

class Peo {
    //属性，成员变量，filed
	String name;
	int age;
	String weight;
    //行为
}