public class object01 {
	public static void main (String[] args) {
		//1. new Peo(); ����һ��Peo��Ķ���
		//2. Peo cat1 = new Peo(); �Ѵ����Ķ��󸳸�cat1
		Peo peo1 = new Peo();  //ʵ����һ��Peo��Ķ���cat1
		
        peo1.name = "Jing";
		peo1.age = 18;
		peo1.weight = "55";

		System.out.println(peo1.name + " " + peo1.age + " " + peo1.weight);
        
        Peo peo2 = peo1;
        System.out.println("peo2.age=" + peo2.age);
	}
}

class Peo {
    //���ԣ���Ա������filed
	String name;
	int age;
	String weight;
    //��Ϊ
}