package com.zhouxinbin.tomcat.servlet;

import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;
import com.zhouxinbin.util.WebUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MyCalServlet extends MyHttpServlet{

    @Override
    public void doGet(MyRequest request, MyResponse response) {
        // 获取参数
        String num1 = request.getParameters("num1");
        String num2 = request.getParameters("num2");
        // 转换
        Integer numInt1 = WebUtils.parseInt(num1, 0);
        Integer numInt2 = WebUtils.parseInt(num2, 0);
        // 计算
        Integer sum = numInt1 + numInt2;
        // 返回结果
        OutputStream outputStream = response.getOutputStream();
        String responseBody = response.responseHeader + "<h1>" + num1 + " + " + num2 + " = " + sum + "</h1>";
        try {
            outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        doGet(request, response);
    }
}
