import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addBook")
public class AddBook extends Custom{
    @EJB
    BookI bookI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("sName")!=null){
        PrintWriter out = resp.getWriter();
            Book book1 = new Book();
        book1.setInventoryId(getData(req,"bookid"));
            Book b = bookI.getById(book1);
//            System.out.println(b.bookname);
        if(b==null) {
            book1.setInventoryId(getData(req,"bookid"));
            book1.setBookname(getData(req, "name"));
            book1.setAuthor(getData(req, "author"));
            selectBookCategory(req, book1);

            book1.setYearPublished(getData(req,"year"));
            book1.setAvailable(Available.yes);

            if (bookI.addBook(book1)) {
                out.println("SUCCESSFUL");
                resp.sendRedirect("index.jsp");

            } else {
                out.println("Could not register");
            }
        }
        else {
            out.println("COULD NOT REGISTER");
             }
    }
        else{
            resp.sendRedirect("LoginLibrarian.jsp");
        }
    }
}
