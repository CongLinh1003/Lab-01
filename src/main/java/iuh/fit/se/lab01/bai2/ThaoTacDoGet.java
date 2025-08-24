package iuh.fit.se.lab01.bai2;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.time.Instant;

@WebServlet("/bai2/hello")
public class ThaoTacDoGet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        var out = resp.getWriter();
        out.println("<!doctype html><meta charset='utf-8'><title>Bài 2</title>");
        out.println("<h1>Bài 2</h1>");
        out.println("<p>Thời gian: " + Instant.now() + "</p>");
        out.println("<ul>");
        out.println("<li>Method: " + req.getMethod() + "</li>");
        out.println("<li>Path: " + req.getRequestURI() + "</li>");
        out.println("<li>Query: " + (req.getQueryString()==null? "" : req.getQueryString()) + "</li>");
        out.println("</ul>");
    }
}