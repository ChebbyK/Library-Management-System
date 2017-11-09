import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "addlib")
public class AddLibrarian extends HttpServlet {
    @EJB
    LibrarianI librarianI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("sName") != null) {
            PrintWriter out = resp.getWriter();
            Librarian librarian= new Librarian();
            librarian.setEmpnumber(req.getParameter("natid"));
            Librarian l = librarianI.getById(librarian);
            if(l==null) {
                librarian.setEmpnumber(req.getParameter("natid"));
                librarian.setName(req.getParameter("name"));
                librarian.setEmail(req.getParameter("email"));
                String gen = req.getParameter("gender");
                if (gen.equals("female")) {
                    librarian.setGender(Gender.female);
                } else if (gen.equals("male")) {
                    librarian.setGender(Gender.male);

                }
                librarian.setUsername(req.getParameter("username"));
                librarian.setPassword(req.getParameter("password"));
                if (librarianI.addLibrarian(librarian)) {
                    out.println("SUCCESFUL");
                    resp.sendRedirect("index.jsp");
                } else {
                    out.println("INVALID");
                }
            }
            else{
                out.println("COULD NOT REGISTER");
            }
        }
        else{
            resp.sendRedirect("LoginLibrarian.jsp");
        }
    }
}
