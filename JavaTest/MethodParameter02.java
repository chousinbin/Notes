public class MethodParameter02 {
    public static void main(String[] args) {
        Person1 pp = new Person1();
        pp.age = 10;
        pp.name = "Jing";
        
        A1 mya = new A1();
        mya.test01(pp);
        System.out.println(pp.age);  //20
    }
}

class Person1 {
    int age;
    String name;
}

class A1 {
    public void test01(Person1 p) {
        p.age = 20;
        /*
        对象是引用类型 实参受形参影响 
        因为两个方法里虽然对象名不同
        但是对象名都指向堆中同一个对象的地址
        */
        p = null;
        /*
        这里p只是在test01方法里的对象名 
        p由指向源对象地址改为了null 
        但是再另一个方法中
        那个对象名指向的还是那原来的对象的地址
        */
    }
}