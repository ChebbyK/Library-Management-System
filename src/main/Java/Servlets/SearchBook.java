import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "searchbook")
public class SearchBook extends HttpServlet {
    @EJB
    BookI bookI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("sName")!=null){
        PrintWriter out = resp.getWriter();
        Book book = new Book();
        book.setInventoryId((req.getParameter("inventoryId")));
        Book b= bookI.getById(book);
        if(b!=null){
            HttpSession sess = req.getSession();
            sess.setAttribute("inventoryId",req.getParameter("inventoryId"));
            resp.sendRedirect("IssueBook.jsp");

        }else{
            out.println("Could not find the Book");
            resp.sendRedirect("index.jsp");
        }
    }
        else{
            resp.sendRedirect("LoginLibrarian.jsp");
        }
    }

}

