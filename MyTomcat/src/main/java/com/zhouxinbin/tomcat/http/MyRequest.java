package com.zhouxinbin.tomcat.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class MyRequest {
    private String method;
    private String uri;
    private HashMap<String, String> params = new HashMap<>();
    private InputStream inputStream = null;

    public MyRequest(InputStream inputStream) {
        this.inputStream = inputStream;
        // 封装 HTTP 请求
        init();
    }

    private void init() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String requestLine = bufferedReader.readLine();
            String[] requestLineArray = requestLine.split(" ");
            // 提取方法
            method = requestLineArray[0];
            // 提取 URI
            int index = requestLineArray[1].indexOf("?");
            if (index != -1) {
                uri = requestLineArray[1].substring(0, index);
                // 提取参数
                String param = requestLineArray[1].substring(index + 1);
                String[] paramArray = param.split("&");
                // 防止用户提交 /MyCalServlet?
                if (null != paramArray && !"".equals(paramArray)) {
                    for (String s : paramArray) {
                        String[] keyValue = s.split("=");
                        if (keyValue.length == 2) {
                            params.put(keyValue[0], keyValue[1]);
                        }
                    }
                }
            } else {
                uri = requestLineArray[1];
            }
            // 此处关流会导致 socket 关闭
            // inputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getParameters(String name) {
        if (params.containsKey(name)) {
            return params.get(name);
        }
        return "";
    }

    public String getMethod() {
        return method;
    }
    public String getUri() {
        return uri;
    }
    @Override
    public String toString() {
        return "MyRequest{" +
                "method='" + method + '\'' +
                ", uri='" + uri + '\'' +
                ", params=" + params +
                '}';
    }
}
