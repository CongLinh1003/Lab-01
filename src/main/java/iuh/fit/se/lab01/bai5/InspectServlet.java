package iuh.fit.se.lab01.bai5;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/bai5/inspect")
public class InspectServlet extends HttpServlet {
    @Override protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException { render(req, resp); }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException { render(req, resp); }

    private void render(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        var out = resp.getWriter();
        out.println("<!doctype html><meta charset='utf-8'><title>HTTP Inspect</title>");
        out.println("<h2>HTTP Request</h2><pre>");
        out.println(req.getMethod()+" "+req.getRequestURI()+(req.getQueryString()==null? "":"?"+req.getQueryString())+" "+req.getProtocol());
        for (Enumeration<String> e = req.getHeaderNames(); e.hasMoreElements();) {
            String n = e.nextElement();
            out.println(n + ": " + req.getHeader(n));
        }
        out.println("</pre><h2>Parameters</h2><pre>");
        for (Enumeration<String> e = req.getParameterNames(); e.hasMoreElements();) {
            String n = e.nextElement();
            out.println(n + " = " + String.join(", ", req.getParameterValues(n)));
        }
        out.println("</pre><p>Hãy submit form <a href='"+req.getContextPath()+"/register.jsp'>GET/POST</a> rồi quay lại trang này để so sánh.</p>");
    }
}