package com.IO.Decorators;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 14:04
 * @Description: 处理流
 */
public class BufferedReader_ extends Reader_{
    private Reader_ reader_; // Reader_ 类型的私有属性

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }
    @Override
    public void read() {
        this.getReader_().read();
    }
    // 多次读取文件
    public void read(int num) {
        for (int i = 0; i < num; i++) {
            reader_.read();
        }
    }

    public Reader_ getReader_() {
        return reader_;
    }

    public void setReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }
}
