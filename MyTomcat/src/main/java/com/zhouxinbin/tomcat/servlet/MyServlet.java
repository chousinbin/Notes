package com.zhouxinbin.tomcat.servlet;

import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public interface MyServlet {
    void init() throws Exception;

    void service(MyRequest request, MyResponse response) throws IOException;

    void destroy();
}
