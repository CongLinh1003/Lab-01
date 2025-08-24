package iuh.fit.se.lab01.bai3;
import iuh.fit.se.lab01.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;

@WebServlet("/bai3/user")
public class UserJsonServlet extends HttpServlet {
    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");

        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        int id = 1; try { if (idStr != null) id = Integer.parseInt(idStr); } catch (NumberFormatException ignored) {}
        if (name == null)  name  = "Student";
        if (email == null) email = "student@example.com";

        mapper.writeValue(resp.getWriter(), new User(id, name, email));
    }
}
