package com.sinbin.interface_.interface_poly;

/**
 * @ClassName: poly
 * @Description:
 * @date: 2023-03-12 11:18
 */
public class poly {
    public static void main(String[] args) {
        //接口类型的变量可以指向实现了该接口的类的对象实例
        Usb myUsb = new Phone();
        myUsb = new Camera();
    }
}

interface Usb {
    void connect();
    void stop();
}

class Computer {
    //接口类型的形参可以接收实现了该接口的类的对象实例
    public void work(Usb myUsb) {
        myUsb.connect();
        myUsb.stop();
    }
}

class Phone implements Usb {
    public void connect() {

    }
    public void stop() {

    }
}

class Camera implements Usb {
    public void connect() {

    }
    public void stop() {

    }
}
