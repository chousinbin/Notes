public class Scope {
    public static void main(String[] args) {
        S s1 = new S();
        s1.say();
    }
}

class S {
    String name = "Jing";  //ȫ�ֱ���:������Ϊ������S��
    public void say() {
        int score = 10;  //�ֲ�����:������Ϊ��������say��
        String name = "Bin";
        System.out.println("sayName = " + name);
    }
    
}
