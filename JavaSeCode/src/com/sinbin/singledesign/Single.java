package com.sinbin.singledesign;

/**
 * @ClassName: Single
 * @Description:
 * @date: 2023-03-08 21:16
 */
public class Single {
    public static void main(String[] args) {
        GirlFriend myGirlFriend = GirlFriend.getGirlFriend();
        System.out.println(myGirlFriend);
    }
}

class GirlFriend {
    private String name;

    private GirlFriend(String name) {
        this.name = name;
    }

    private static GirlFriend gf = new GirlFriend("yuanJin");

    public static GirlFriend getGirlFriend() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
