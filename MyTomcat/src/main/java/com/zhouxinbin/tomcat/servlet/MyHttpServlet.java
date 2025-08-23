package com.zhouxinbin.tomcat.servlet;

import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;

import java.io.IOException;

public abstract class MyHttpServlet implements MyServlet {
    @Override
    public void init() throws Exception {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void service(MyRequest request, MyResponse response) throws IOException {
        // 忽略大小写
        if (request.getMethod().equalsIgnoreCase("GET")) {
            this.doGet(request, response);
        } else if (request.getMethod().equalsIgnoreCase("POST")) {
            this.doPost(request, response);
        }
    }
    public abstract void doGet(MyRequest request, MyResponse response);
    public abstract void doPost(MyRequest request, MyResponse response);
}
