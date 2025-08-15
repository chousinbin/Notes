package com.sinbin.list_;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/14 13:31
 * @Description:
 */
public class ListSort {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add(new Book("红楼梦", "曹雪芹", 100));
        arrayList.add(new Book("水浒传", "施耐庵", 150));
        arrayList.add(new Book("西游记", "吴承恩", 120));

        sort(arrayList);

        for (int i = 0; i < arrayList.size(); i ++) {
            System.out.println(arrayList.get(i));
        }
    }
    // 升序
    public static void sort(List list) {
        for (int i = 0; i < list.size() - 1; i ++) {
            for (int j = i + 1; j < list.size(); j ++) {
                Book book1 = (Book)list.get(i);
                Book book2 = (Book)list.get(j);

                if (book1.getPrice() > book2.getPrice()) {
                    list.set(i, book2);
                    list.set(j, book1);
                }
            }
        }
    }
}

class Book {
    String name;
    String author;
    double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
