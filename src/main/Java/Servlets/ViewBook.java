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
@WebServlet (urlPatterns = "viewbook")
public class ViewBook extends HttpServlet {
    @EJB
    BookI bookI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("sesname")!=null){
            List<Book> list = bookI.viewBook();
            req.setAttribute("viewBook", list);
            RequestDispatcher rd = req.getRequestDispatcher("ViewBook.jsp");
            rd.forward(req, resp);
        }
        else{
            resp.sendRedirect("LoginUser.jsp");
        }
    }
}
