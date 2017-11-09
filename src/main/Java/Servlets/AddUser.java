import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "adduser")
public class AddUser extends HttpServlet {
    @EJB
    UserI userI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("sName") != null) {
            PrintWriter out = resp.getWriter();
            User u = new User();
            u.setNatId(req.getParameter("natid"));
            User user = userI.search(u);
            if (user == null) {
                u.setNatId(req.getParameter("natid"));
                u.setName(req.getParameter("name"));
                u.setContact(req.getParameter("contact"));
                u.setEmail(req.getParameter("email"));
                String gen = req.getParameter("gender");
                if (gen.equals("female")) {
                    u.setGender(Gender.female);
                } else if (gen.equals("male")) {
                    u.setGender(Gender.male);

                }
                u.setUsername(req.getParameter("username"));
                u.setPassword(req.getParameter("password"));
                if (userI.register(u)) {
                    out.println("SUCCESFUL");
                    resp.sendRedirect("index.jsp");
                } else {
                    out.println("INVALID");
                }
            } else {
                out.println("COULD NOT REGISTER");
            }
        }
        else{
                resp.sendRedirect("LoginLibrarian.jsp");
            }
        }
    }
