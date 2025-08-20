package com.sinbin.interface_;

/**
 * @ClassName: Exercise2
 * @Description:
 * https://cdn.jsdelivr.net/gh/chousinbin/Image/202303191722378.png
 * @date: 2023-03-19 16:42
 */
public class Exercise2 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", Factory.getHorse());  //默认骑马, 传马
        System.out.println(person);

        person.common();  //实例化对象时已经传马了, 在Person中会判断, 所以这步不会新实例化马对象
        System.out.println(person);

        person.passRival();  //过河需要船只, 之前是马, 所以新实例化船对象
        System.out.println(person);

        person.common();
        System.out.println(person);

        person.passRival();
        System.out.println(person);
    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("平时骑马");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("遇河开船");
    }
}

class Factory {  //因为是工厂类, 我们可以把方法用static修饰, 我们不必实例化对象
    private static Horse horse = new Horse();  //静态对象的马儿, 总用同一匹马
    public static Horse getHorse() {
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void common() {
        if(!(vehicles instanceof Horse)) {
            vehicles = Factory.getHorse();
        }
        vehicles.work();
    }

    public void passRival() {
        if(!(vehicles instanceof Boat)) {
            vehicles = Factory.getBoat();
        }
        vehicles.work();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}