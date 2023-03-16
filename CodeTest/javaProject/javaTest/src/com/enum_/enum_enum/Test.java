package com.enum_.enum_enum;

/**
 * @ClassName: Test
 * @Description:
 * @date: 2023-03-16 21:12
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
        System.out.println(Season.a);
        System.out.println(Season.b);
    }
}

enum Season {
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"), AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷"), a(), b;

    private String name;
    private String desc;

    private Season() {}  //无参构造器
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
