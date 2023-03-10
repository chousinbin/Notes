package com.interface_.interface1;

/**
 * @ClassName: Phone
 * @Description:
 * @date: 2023-03-10 18:30
 */
public class Phone implements Usb {
    public void Connect() {
        System.out.println("手机连接中");
    }

    public void Break() {
        System.out.println("手机断开中");
    }
}
