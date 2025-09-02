package cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/DecoderCookie")
public class DecoderCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // URL 解码
        Cookie cookie = CookieUtils.readCookieByName("name", request.getCookies());
        String decode = null;
        if (cookie != null) {
            decode = URLDecoder.decode(cookie.getValue(), "UTF-8");
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<p1>" + decode+ "</p1>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}