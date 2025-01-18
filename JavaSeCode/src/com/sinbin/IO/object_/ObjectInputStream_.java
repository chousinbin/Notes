package com.sinbin.IO.object_;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 19:21
 * @Description:
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("resource\\obj.bak"));

        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readUTF());

        /*
            序列化和反序列化所使用的对象，必须是同一个类的对象
         */
        Object obj = objectInputStream.readObject();
        System.out.println(obj.getClass());

        Dog dog = (Dog) obj;
        System.out.println(dog);
        System.out.println(dog.getName());

        objectInputStream.close();
    }
}
