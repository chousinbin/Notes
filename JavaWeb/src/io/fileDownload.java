package io;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/fileDownload")
public class fileDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取文件路径 + 名称
        String fileName = request.getParameter("name");
        ServletContext servletContext = request.getServletContext();
        String downloadPath = "/static/";
        String downloadRealPath = downloadPath + fileName;
        System.out.println(downloadRealPath);
        // 设置响应头
        String mimeType = servletContext.getMimeType(downloadRealPath);
        System.out.println(mimeType);
        response.setContentType(mimeType);
        // 火狐 Base64 编码
        if (request.getHeader("User-Agent").contains("Firefox")) {
            response.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" +
                    new BASE64Encoder().encode(fileName.getBytes("UTF-8")) + "?=");
        } else { // 其他 URL 编码
            response.setHeader("Content-Disposition", "attachment; filename=" +
                    URLEncoder.encode(fileName, "UTF-8"));
        }
        // 输入流拷贝到输出流
        InputStream resourceAsStream = servletContext.getResourceAsStream(downloadRealPath);
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}