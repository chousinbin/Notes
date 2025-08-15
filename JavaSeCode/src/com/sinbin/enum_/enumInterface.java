package com.sinbin.enum_;

/**
 * @ClassName: enumInterpace
 * @Description:
 * @date: 2023-03-18 17:10
 */
public class enumInterface {
    public static void main(String[] args) {
        Music.CLASSIC.playing();
    }
}

interface IP {
    public void playing();
}

enum Music implements IP{
    CLASSIC;

    @Override
    public void playing() {
        System.out.println("播放音乐");
    }
}
