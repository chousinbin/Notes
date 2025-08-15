public class Methodtest02 {
    //克隆对象
    public static void main(String[] args) {
        Person02 p = new Person02();
        p.name = "Jing";
        p.age = 18;

        MyTools02 copy = new MyTools02();
        System.out.println(copy.copyPerson(p).age + "\n" + copy.copyPerson(p).name);
    }
}

class Person02 {
    int age;
    String name;
}

class MyTools02 {
    public Person02 copyPerson(Person02 p) {
        Person02 pp = new Person02();
        pp.age = p.age;
        pp.name = p.name;
        return pp;
    }
}
