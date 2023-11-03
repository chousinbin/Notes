public class constructor {
    /*
     * 要求
     * 利用构造方法
     * 实现
     * 创建人类对象的同时
     * 指定对象年龄和姓名
     */
    public static void main(String[] args) {
        Person p1 = new Person("Jing", 18);
        System.out.println(p1.name + " " + p1.age);

        Person p2 = new Person("Bin");
        System.out.println(p2.name + " " + p2.age);

        /*
         * 定义构造方法之后创建对象必须传参
         * 因为定义构造方法之后默认无参构造方法失效
         * 想要不传参就必须在类中显示声明默认无参构造方法
         */
        Person p3 = new Person(); 
        System.out.println(p3.name + " " + p3.age);
    }
}

class Person {
    //属性
    String name;
    int age;

    //构造方法1
    public Person(String pName, int pAge) {
        name = pName;
        age = pAge;
    }

    //构造方法2
    public Person(String pName) {
        name = pName;
    }

    //默认构造方法0
    Person(){}
}