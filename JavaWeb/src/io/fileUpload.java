package io;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = "/fileUpload")
public class fileUpload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            System.out.println("文件表单");
            // 解析上传数据的工具对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            // 解决接收文件中文乱码问题
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
                // 从请求的表单中获取数据（文件和非文件）
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        String name = fileItem.getString("utf-8");
                        System.out.println("家具名=" + name);
                    } else {
                        // 获取文件名
                        String fileName = fileItem.getName();
                        // 文件名唯一化 UUID + 系统毫秒数 前缀
                        fileName = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_" + fileName;
                        System.out.println("文件名=" + fileName);
                        // 获取全路径
                        String filePath = "/upload/";
                        String realPath = request.getServletContext().getRealPath(filePath);
                        System.out.println(realPath);
                        // 按日期分目录
                        realPath = realPath + WebUtils.getYMD();
                        // 创建目录
                        File file = new File(realPath);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        // 文件拷贝到指定目录
                        String filePathName = realPath + fileName;
                        fileItem.write(new File(filePathName));
                        // 提示信息
                        response.setContentType("text/html;charset=utf-8");
                        response.getWriter().write("上传成功");
                    }
                }
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("非文件表单");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}