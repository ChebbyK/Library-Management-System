import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "update")
public class UpdateBook extends HttpServlet {
@EJB
BookI bookI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sess = req.getSession(false);
        if(sess.getAttribute("sName")!=null){
        Book book = new Book();
        book.setInventoryId((req.getParameter("inventoryId")));
        List<Book> booklist=  bookI.search(book);

        for (Book b :booklist){
          HttpSession session = req.getSession();
            session.setAttribute("inventoryId", b.getInventoryId());
            session.setAttribute("bookname", b.getBookname());
            session.setAttribute("author",b.getAuthor());
            session.setAttribute("bookcategory",b.getBookcategory());

            session.setAttribute("yearPublished",b.getYearPublished());

        }
        resp.sendRedirect("updatebook.jsp");
    }
        else{
            resp.sendRedirect("LoginLibrarian.jsp");
        }
}}
