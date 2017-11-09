import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "loginlib")
public class LoginLibrarian extends HttpServlet {
    @Inject
    @Authenticate(Authenticate.logChoice.librarian)
    private  LoginI loginI;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String user= req.getParameter("Username");
        String pass=req.getParameter("Password");
        if(loginI.login(user,pass)){
            HttpSession session = req.getSession();
            session.setAttribute("sName",req.getParameter("Username"));
            resp.sendRedirect("index.jsp");
        }
        else{
            out.println("ERROR: CANNOT LOGIN");
        }
    }
}
