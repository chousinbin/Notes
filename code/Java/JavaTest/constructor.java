public class constructor {
    /*
     * Ҫ��
     * ���ù��췽��
     * ʵ��
     * ������������ͬʱ
     * ָ���������������
     */
    public static void main(String[] args) {
        Person p1 = new Person("Jing", 18);
        System.out.println(p1.name + " " + p1.age);

        Person p2 = new Person("Bin");
        System.out.println(p2.name + " " + p2.age);

        /*
         * ���幹�췽��֮�󴴽�������봫��
         * ��Ϊ���幹�췽��֮��Ĭ���޲ι��췽��ʧЧ
         * ��Ҫ�����ξͱ�����������ʾ����Ĭ���޲ι��췽��
         */
        Person p3 = new Person(); 
        System.out.println(p3.name + " " + p3.age);
    }
}

class Person {
    //����
    String name;
    int age;

    //���췽��1
    public Person(String pName, int pAge) {
        name = pName;
        age = pAge;
    }

    //���췽��2
    public Person(String pName) {
        name = pName;
    }

    //Ĭ�Ϲ��췽��0
    Person(){}
}