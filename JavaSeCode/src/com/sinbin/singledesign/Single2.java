package com.sinbin.singledesign;

/**
 * @ClassName: Single2
 * @Description:
 * @date: 2023-03-08 21:42
 */
public class Single2 {
    public static void main(String[] args) {
        GirlFriend2 myGf = GirlFriend2.getGirlFriend();
        System.out.println(myGf);
    }
}

class GirlFriend2 {
    private String name;

    private GirlFriend2(String name) {
        this.name = name;
    }

    private static GirlFriend2 gf;

    public static GirlFriend2 getGirlFriend() {
        if(gf == null)
            gf = new GirlFriend2("yuanJin");
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend2{" +
                "name='" + name + '\'' +
                '}';
    }
}