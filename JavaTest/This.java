public class This {
    public static void main(String[] args) {
        People p1 = new People("Jing", 18);
        System.out.println(p1.name + " " + p1.age);

        People p2 = new People();
        System.out.println(p2.name + " " + p2.age);

    }
}

class People {
    String name;
    int age;

    public People() {
        this("THIS", 99);
    }
    
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
