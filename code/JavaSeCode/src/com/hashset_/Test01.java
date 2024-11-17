package com.hashset_;

import java.util.HashSet;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/16 16:25
 * @Description: 验证链表个数大于 8 才扩容
 */
public class Test01 {
    public static void main(String[] args) {
        HashSet hashset = new HashSet();

        for (int i = 0; i < 8; i++) {
            hashset.add(new A(i + ""));
        }
        // 在此设置断点，发现插入8个结点到同一索引后，数组大小还是 16，证明未触发数组扩容，也就说明未触发树化
        hashset.add(new A(9 + ""));
        // 执行到此，发现数组扩容为 32，证明当链表长度达到 9，也就是大于 8 时，才触发红黑树化
    }

}

class A {
    String name;

    public A(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}