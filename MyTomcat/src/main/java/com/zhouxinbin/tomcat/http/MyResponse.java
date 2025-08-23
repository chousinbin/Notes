package com.zhouxinbin.tomcat.http;

import java.io.OutputStream;

public class MyResponse {
    private OutputStream outputStream = null;
    // 后期可以添加 setContentType()
    public static final String responseHeader =
            "HTTP/1.1 200 OK\r\nContent-Type: text/html;charset=utf-8\r\n\r\n";

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
