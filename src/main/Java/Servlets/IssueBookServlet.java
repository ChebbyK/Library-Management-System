import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

@WebServlet(urlPatterns = "issuebook")
public class IssueBookServlet extends HttpServlet {
    @EJB
    IssueBookI issueBookI;
    @EJB
    BookI bookI;
    @EJB
    UserI userI;
    @EJB
    BookTrailI bookTrailI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("sName") != null) {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            User user = new User();
            IssueBook issueBook = new IssueBook();
            Book book = new Book();
            book.setInventoryId((req.getParameter("inventoryId")));
            Book book1 = bookI.getById(book);
            user.setNatId(req.getParameter("natid"));
            User user1 = userI.search(user);
            if (book1 == null) {
                resp.sendRedirect("AddBook.jsp");
            }
            if (user1 == null) {
                resp.sendRedirect("AddUser.jsp");
            }
            if (book1 != null && user1 != null) {
                if (book1.getAvailable().equals(Available.yes) ) {
                    issueBook.setBook(book1);
                    issueBook.setUser(user1);
                    issueBook.setStatus(Status.issued);
                    issueBook.setIssueddate(new Date());
                    Calendar cal= Calendar.getInstance();
                    cal.setTime(issueBook.getIssueddate());
                    cal.add(Calendar.DATE, 10);
                    Date returndate=cal.getTime();
                    issueBook.setExpectedreturndate(returndate);
                    book1.setAvailable(Available.no);
                    BookTrail bookTrail = new BookTrail();
                    bookTrail.setBook(book1);
                    bookTrail.setUser(user1);
                    bookTrail.setStatus(Status.issued);
                    bookTrail.setIssuedate(new Date());
                    Calendar ca= Calendar.getInstance();
                    ca.setTime(bookTrail.getIssuedate());
                    cal.add(Calendar.DATE, 10);
                    Date rdate=cal.getTime();
                    bookTrail.setExpectedReturnDate(rdate);
                    if (bookI.issueBook(book1, issueBook) && bookTrailI.addBookTrail(bookTrail)) {

                        out.println("Successful");
                        resp.sendRedirect("index.jsp");
                    }
                    else {
                        out.println("<html><body><p>Unable To find the book</p><body></html>");
                    }
                }
                }
             else {
                out.println("<html><body><p>Unable To find the book</p><body></html>");
            }
        } else {
            resp.sendRedirect("LoginLibrarian.jsp");
        }
    }  }
