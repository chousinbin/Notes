package com.sinbin.interface_.interface1;

/**
 * @ClassName: Camera
 * @Description:
 * @date: 2023-03-10 18:31
 */
public class Camera implements Usb {
    public void Connect() {
        System.out.println("相机连接中");
    }

    public void Break() {
        System.out.println("相机断开中");
    }
}
