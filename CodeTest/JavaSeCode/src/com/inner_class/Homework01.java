package com.inner_class;

/**
 * @ClassName: Homework01
 * @Description:https://cdn.jsdelivr.net/gh/chousinbin/Image/202303191739214.png
 * @date: 2023-03-19 17:25
 */
public class Homework01 {
    public static void main(String[] args) {
        Car car1 = new Car(-20);
        car1.useAirFlow();
        Car car2 = new Car(50);
        car2.useAirFlow();
        Car car3 = new Car(20);
        car3.useAirFlow();
    }
}

class Car {
    private int temperature;

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if(temperature > 40) {
                System.out.println("吹冷风");
            } else if (temperature < 0) {
                System.out.println("吹暖风");
            } else {
                System.out.println("空调关闭");
            }
        }
    }

    public void useAirFlow() {
        new Air().flow();
    }
}
