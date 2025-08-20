package com.sinbin.DJTU_Java;

/**
 * @ClassName: TestBox
 * @UserName: SinBin
 * @date: 2023-04-09 21:10
 * @Description:
 */
public class TestBox {
    public static void main(String[] args) {
        Box b = new Box();
        b.setBox(1, 2, 3);
        System.out.println("长方体的体积 = " + b.volume());
    }
}

class Box {
    private int length;
    private int width;
    private int height;

    public void setBox(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int volume() {
        return length * width * height;
    }
}
