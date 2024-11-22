package com.enum_;

/**
 * @ClassName: EnumMethod
 * @Description:演示Enum类的成员方法
 * @date: 2023-03-18 15:57
 */
public class EnumMethod {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        //name()返回当前枚举常量的名称
        System.out.println(autumn.name());
        //toString(), 已经被Enum类重写, 返回当前对象名, 子类可以重写该方法, 用于返回对象属性信息
        System.out.println(Season.SPRING);
        //ordinal()返回当前枚举常量的编号(从0开始)
        System.out.println(autumn.ordinal());
        //values()返回包含当前枚举类的所有对象名的数组
        Season[] values = Season.values();
        for(Season value : values) {
            System.out.println(value);
        }
        //valueOf()将字符串与枚举类中的对象名进行匹配, 匹配成功返回对象, 否则报错
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
        System.out.println(spring == Season.SPRING);
        //compareTo()比较两个枚举常量的位置号, 返回前者位置号与后者位置号相减的结果
        System.out.println(Season.SPRING.compareTo(Season.SUMMER));

    }
}

enum Season {
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷");

    private String name;
    private String desc;

    private Season() {}  //无参构造器
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}


