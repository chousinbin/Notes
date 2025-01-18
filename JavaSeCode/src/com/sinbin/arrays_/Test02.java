package com.sinbin.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 13:23
 * @Description: 对 Book 类内的 4 个对象按照价格进行排序
 */
public class Test02 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("Java从入门到放弃",300);

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;

                double res = b2.getPrice() - b1.getPrice();
                // 适应返回类型
                if (res > 0) return 1;
                else if (res < 0) return -1;
                else return 0;
            }
        });

        System.out.println(Arrays.toString(books));
    }
}

class Book {
    String name;
    double price;

    Book(){}
    Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}