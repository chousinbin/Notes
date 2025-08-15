package com.sinbin.map_;

import java.util.HashMap;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/16 20:32
 * @Description:
 */
public class Map01 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "zxb");
        hashMap.put(2, "zxb");
        hashMap.put(3, "zxb");
        hashMap.put(3, "xb");
        System.out.println(hashMap);
    }
}
