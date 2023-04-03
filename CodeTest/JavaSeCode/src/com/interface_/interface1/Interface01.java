package com.interface_.interface1;

/**
 * @ClassName: Interface01
 * @Description:
 * @date: 2023-03-09 18:27
 */
public class Interface01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();
        Computer computer = new Computer();

        computer.work(phone);
        computer.work(camera);
    }
}
