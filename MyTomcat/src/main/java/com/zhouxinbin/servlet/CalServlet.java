package com.zhouxinbin.servlet;

import com.zhouxinbin.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/CalServlet")
public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String numStr1 = request.getParameter("num1");
        String numStr2 = request.getParameter("num2");

        int num1 = WebUtils.parseInt(numStr1, 0);
        int num2 = WebUtils.parseInt(numStr2, 0);
        int sum = num1 + num2;

        PrintWriter writer = response.getWriter();
        writer.println(num1 + " + " + num2 + " = " + sum);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}