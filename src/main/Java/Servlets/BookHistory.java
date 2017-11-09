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
@WebServlet (urlPatterns = "viewStatus")
public class BookHistory extends HttpServlet {
    @EJB
    BookI bookI;
    @EJB
    BookTrailI bookTrailI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("sName")!=null){
    Book book= new Book();
    book.setInventoryId((req.getParameter("inventoryId")));
    Book b= bookI.getById(book);
    BookTrail bookTrail = new BookTrail();
    bookTrail.setBook(b);
    bookTrailI.viewBookById(bookTrail);
        List<BookTrail> list =bookTrailI.viewBookById(bookTrail);
        req.setAttribute("viewBook", list );
        RequestDispatcher rd = req.getRequestDispatcher("ViewBookStatus.jsp");
        rd.forward(req,resp);
    }
        else{
            resp.sendRedirect("LoginLibrarian.jsp");
        }
    }
}
