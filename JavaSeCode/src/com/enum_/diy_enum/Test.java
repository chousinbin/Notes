package com.enum_.diy_enum;

/**
 * @ClassName: Test
 * @Description:
 * @date: 2023-03-16 20:44
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

class Season {
    private String name;
    private String desc;

    //1. 构造器私有化
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //2. 删除setXxx()方法

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    //3. 在Season内部直接创建固定的对象
    //4. 通过final修饰优化对象, 使调用对象时类不会加载
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
