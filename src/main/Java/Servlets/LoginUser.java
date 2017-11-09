import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "loginuser")
public class LoginUser extends HttpServlet {
    @Inject
    @Authenticate(Authenticate.logChoice.user)
    private  LoginI loginI;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String usern= req.getParameter("Username");
        String pass=req.getParameter("Password");
        if(loginI.login(usern,pass)){
            HttpSession session = req.getSession();
            session.setAttribute("sesname",req.getParameter("Username"));
            resp.sendRedirect("UserNav.jsp");
        }
        else{
            out.println("Unable to log in");
        }
    }
}
