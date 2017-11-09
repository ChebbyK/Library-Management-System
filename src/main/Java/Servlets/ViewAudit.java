import javax.ejb.EJB;
import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "view")
public class ViewAudit extends HttpServlet {
    @EJB
    AuditI auditI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("sName") != null) {
        List<AuditTrail> list =auditI.viewAuditTrail();
        req.setAttribute("viewAudit", list );
        RequestDispatcher rd = req.getRequestDispatcher("viewAudit.jsp");
        rd.forward(req,resp);
        }
         else{
            resp.sendRedirect("LoginLibrarian.jsp");
        }
    }
}
