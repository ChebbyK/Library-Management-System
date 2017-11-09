import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet (urlPatterns = "logout")
public class LogoutLibrarian extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session= req.getSession(false);
        if(session.getAttribute("username")==null){
            resp.sendRedirect("LoginLibrarian.jsp");
        }
        else{
            session.invalidate();
            resp.sendRedirect("index.jsp");
        }
    }
}
