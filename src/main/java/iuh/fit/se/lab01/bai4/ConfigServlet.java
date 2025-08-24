package iuh.fit.se.lab01.bai4;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;

@WebServlet(
        urlPatterns = "/bai4/config",
        initParams = {
                @WebInitParam(name="author", value="20060611_CongLinh"),
                @WebInitParam(name="version", value="1.0.0")
        }
)
public class ConfigServlet extends HttpServlet {
    private String author;
    private String version;

    @Override public void init() throws ServletException {
        this.author = getInitParameter("author");
        this.version = getInitParameter("version");
    }

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        ServletContext ctx = getServletContext();
        String appName = ctx.getInitParameter("appName");
        String supportEmail = ctx.getInitParameter("supportEmail");

        var out = resp.getWriter();
        out.println("<!doctype html><meta charset='utf-8'><title>Bài 4</title>");
        out.println("<h2>Init-param & Context-param</h2><ul>");
        out.println("<li>init(author): " + author + "</li>");
        out.println("<li>init(version): " + version + "</li>");
        out.println("<li>context(appName): " + appName + "</li>");
        out.println("<li>context(supportEmail): " + supportEmail + "</li>");
        out.println("</ul>");
        out.println("<form method='post'><button>Gửi doPost()</button></form>");
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}

