package com.IO.object_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 19:09
 * @Description:
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("resource\\obj.bak"));

        objectOutputStream.writeInt(100);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeDouble(1.2);
        objectOutputStream.writeChar('z');
        objectOutputStream.writeUTF("zxb");
        objectOutputStream.writeObject(new Dog("旺旺", 15));

        objectOutputStream.close();
    }
}
