package iuh.fit.se.lab01.bai5;

import iuh.fit.se.lab01.util.HtmlEscaper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;

@WebServlet("/bai5/register")
public class RegisterServlet extends HttpServlet {
    private void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String fullName = req.getParameter("fullName");
        String email    = req.getParameter("email");
        String password = req.getParameter("password");
        String gender   = req.getParameter("gender");
        String[] interests = req.getParameterValues("interests");
        String country  = req.getParameter("country");
        String about    = req.getParameter("about");

        //Validate
        if (fullName==null || fullName.trim().length()<2 ||
                email==null || !email.contains("@") ||
                password==null || password.length()<6 ||
                gender==null || gender.isEmpty()) {
            resp.getWriter().println("<p style='color:#b00020'>Thiếu/sai dữ liệu. Quay lại <a href='"+req.getContextPath()+"/register.jsp'>form</a>.</p>");
            return;
        }

        var out = resp.getWriter();
        out.println("<!doctype html><meta charset='utf-8'><title>Kết quả đăng ký</title>");
        out.println("<h2>Thông tin đã nhập (không hiển thị password)</h2><ul>");
        out.println("<li>Họ tên: " + HtmlEscaper.esc(fullName) + "</li>");
        out.println("<li>Email: " + HtmlEscaper.esc(email) + "</li>");
        out.println("<li>Giới tính: " + HtmlEscaper.esc(gender) + "</li>");
        out.println("<li>Sở thích: " + HtmlEscaper.esc(interests == null ? "(none)" : String.join(", ", interests)) + "</li>");
        out.println("<li>Quốc gia: " + HtmlEscaper.esc(country) + "</li>");
        out.println("<li>Giới thiệu: " + HtmlEscaper.esc(about) + "</li>");
        out.println("</ul><p><a href='"+req.getContextPath()+"/register.jsp'>Quay lại Form</a></p>");
    }

    @Override protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException { handle(req, resp); }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException { handle(req, resp); }
}
