import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "updatingg")
public class EditBook extends Custom {
    @EJB
    BookI bookI;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("sName") != null) {
            PrintWriter out = resp.getWriter();
            Book book = new Book();
            book.setInventoryId(getData(req, "bookid"));
            Book book1 = bookI.getById(book);
            if (book1 != null && book1.getAvailable().equals(Available.yes)) {
                book1.setBookname(getData(req, "name"));
                book1.setAuthor(getData(req, "author"));
                selectBookCategory(req, book1);
                book1.setYearPublished(getData(req, "year"));
                if (bookI.updateBook(book1)) {
                    out.println("SUCCESSFUL");
                    resp.sendRedirect("index.jsp");

                } else {
                    out.println("Could not register");
                }
            } else {

                out.println("Could not find the book");
                resp.sendRedirect("index.jsp");
            }
        }
        else {
            resp.sendRedirect("LoginLibrarian.jsp");
        }
        }
    }

