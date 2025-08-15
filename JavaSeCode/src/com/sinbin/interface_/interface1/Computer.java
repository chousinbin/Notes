package com.sinbin.interface_.interface1;

/**
 * @ClassName: Computer
 * @Description:
 * @date: 2023-03-10 18:30
 */
public class Computer {
    public void work(Usb usbIn) {
        usbIn.Connect();
        usbIn.Break();
    }
}
