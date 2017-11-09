import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "delete")
public class Delete extends HttpServlet {
    @EJB
    BookI bookI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("sName")!=null){
            Book book = new Book();
            book.setInventoryId((req.getParameter("inventoryId")));
            if(bookI.deleteBook(book)){
                resp.sendRedirect("index.jsp");
            }
            else{
                resp.sendRedirect("Delete.jsp");
            }
        }

    }
}
