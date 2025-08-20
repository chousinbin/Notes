package com.sinbin.hashset_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/15 21:03
 * @Description: 模拟 HashMap
 */
public class HashMap_ {
    public static void main(String[] args) {
        Node[] table = new Node[16];
        System.out.println(table);

        Node john = new Node("John", null);
        table[2] = john;

        Node jack = new Node("Jack", null);
        john.next = jack;

        Node rose = new Node("Rose", null);
        jack.next = rose;


    }
}

class Node {
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}
