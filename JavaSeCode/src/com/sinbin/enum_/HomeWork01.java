package com.sinbin.enum_;

/**
 * @ClassName: HomeWork01
 * @Description:
 * @date: 2023-03-19 17:43
 */
public class HomeWork01 {
    public static void main(String[] args) {
        Color color = Color.BLACK;

        //enum枚举类使用switch
        //switch会根据 括号内对象名所指向的枚举常量对象名 与 case中的常量对象名 进行匹配
        switch(color) {
            case RED:
                System.out.println("当前的对象对应枚举常量是红色");
                break;
            case BLUE:
                System.out.println("当前的对象对应枚举常量是蓝色");
                break;
            case GREEN:
                System.out.println("当前的对象对应枚举常量是绿色");
                break;
            case BLACK:
                System.out.println("当前的对象对应枚举常量是黑色");
                break;
            case YELLOW:
                System.out.println("当前的对象对应枚举常量是黄色");
                break;
            default:
                System.out.println("没有枚举到");
        }
    }
}
interface SHOW {
    public void show();
}
enum Color implements SHOW{
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("redValue=" + redValue + " "
                + "greenValue=" + greenValue + " "
                + "blueValue=" + blueValue);
    }
}
