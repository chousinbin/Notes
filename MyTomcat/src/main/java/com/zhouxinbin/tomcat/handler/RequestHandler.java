package com.zhouxinbin.tomcat.handler;

import com.zhouxinbin.tomcat.Tomcat;
import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;
import com.zhouxinbin.tomcat.servlet.MyCalServlet;
import com.zhouxinbin.tomcat.servlet.MyHttpServlet;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements Runnable{
    private Socket socket = null;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 创建 HttpRequest 对象读取 Socket 上的请求
            InputStream inputStream = socket.getInputStream();
            MyRequest myRequest = new MyRequest(socket.getInputStream());
            // 创建 HttpResponse 对象把响应返回到浏览器
            MyResponse myResponse = new MyResponse(socket.getOutputStream());
            // 获取 URI 获得实例
            String uri = myRequest.getUri();


            // 判断应用上下文是否正确
            String applicationContext = uri.substring(0, uri.lastIndexOf("/"));
            if (applicationContext.equals(Tomcat.ApplicationConText)) {
                // 判断静态资源还是 Servlet
                if (uri.contains(".")) {
                    doStatic(uri, myRequest, myResponse);
                } else {
                    doServlet(uri, myRequest, myResponse);
                }
            } else { // 不符合上下文
                errorPage(myResponse);
            }

            // 关流
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void doStatic(String uri, MyRequest myRequest, MyResponse myResponse) throws IOException {
        String path = Tomcat.class.getResource("/").getPath();
        path = path + uri.substring(Tomcat.ApplicationConText.length() + 1);
        System.out.println(path);
        OutputStream outputStream = myResponse.getOutputStream();

        File file = new File(path);
        if (!file.exists()) {
            String response404 = "HTTP/1.1 404 Not Found\r\nContent-Type: text/html\r\n\r\n<h1>404 Not Found</h1>";
            outputStream.write(response404.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            return;
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            // 设置正确的 Content-Type（根据文件扩展名）
            String contentType = getContentType(path);
            String responseHeader = "HTTP/1.1 200 OK\r\nContent-Type: " + contentType + "\r\n\r\n";
            outputStream.write(responseHeader.getBytes(StandardCharsets.UTF_8));
            // 读取文件内容并写入 OutputStream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            String response500 = "HTTP/1.1 500 Internal Error\r\nContent-Type: text/html\r\n\r\n<h1>500 Server Error</h1>";
            outputStream.write(response500.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }

    private void doServlet(String uri, MyRequest myRequest, MyResponse myResponse) throws IOException {
        // 判断是否存在实例
        uri = uri.substring(uri.lastIndexOf("/"));
        String servletName = Tomcat.servletUrlMapping.get(uri);
        // 避免获取 URL 时 空指针异常
        if (servletName == null) {
            servletName = "";
        }
        MyHttpServlet myHttpServlet = Tomcat.servletMapping.get(servletName);
        // 判断实例是否在 web.xml 中
        if (myHttpServlet != null) {
            // 动态绑定，调用运行类型的 GET 或 POST
            myHttpServlet.service(myRequest, myResponse);
        } else { // 不存在实例
            errorPage(myResponse);
        }
    }

    private void errorPage(MyResponse myResponse) throws IOException {
        String responseBody = myResponse.responseHeader + "<h1> 404 NOT FOUND </h1>";
        OutputStream outputStream = myResponse.getOutputStream();
        outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }
    private static String getContentType(String filePath) {
        if (filePath.endsWith(".html")) {
            return "text/html;charset=utf-8";
        } else if (filePath.endsWith(".css")) {
            return "text/css";
        } else if (filePath.endsWith(".js")) {
            return "application/javascript";
        } else if (filePath.endsWith(".png")) {
            return "image/png";
        } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
            return "image/jpeg";
        } else {
            return "application/octet-stream"; // 默认二进制流（浏览器会下载）
        }
    }

}