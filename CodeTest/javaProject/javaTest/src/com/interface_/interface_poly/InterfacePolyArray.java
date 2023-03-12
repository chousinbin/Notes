package com.interface_.interface_poly;

/**
 * @ClassName: InterfacePolyArray
 * @Description:
 * @date: 2023-03-12 11:25
 */
public class InterfacePolyArray {
    public static void main(String[] args) {
        UsbInterface[] myUsbDevice = new UsbInterface[2];

        myUsbDevice[0] = new Phone_();
        myUsbDevice[1] = new Camera_();

        for (int i = 0; i < myUsbDevice.length; i++) {
            myUsbDevice[i].work();
            if(myUsbDevice[i] instanceof Phone_) {  //如果接口数组的元素的运行类型是手机
                ((Phone_)myUsbDevice[i]).call();  //向下转型为手机类型 并调用该类的特有打电话方法
            }
        }
    }
}

interface UsbInterface {
    void work();
}
class Phone_ implements UsbInterface {
    public void work() {
        System.out.println("手机插入USB接口");
    }

    public void call() {
        System.out.println("手机拨打电话");
    }
}
class Camera_ implements UsbInterface {
    public void work() {
        System.out.println("相机插入USB接口");
    }
}