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

@WebServlet(urlPatterns = "returnBook")
public class ReturnBookServlet extends HttpServlet {
    @EJB
    UserI userI;
    @EJB
    BookI bookI;
    @EJB
    BookTrailI bookTrailI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("sesname") != null) {
            PrintWriter out = resp.getWriter();
            User user = new User();
            IssueBook issueBook = new IssueBook();
            Book book = new Book();
            book.setInventoryId((req.getParameter("inventoryId")));
            Book book1 = bookI.getById(book);
            if (book1 == null) {
                resp.sendRedirect("AddBook.jsp");
            }
            user.setNatId(req.getParameter("natid"));
            User user1 = userI.search(user);
            if (user1 == null) {
                resp.sendRedirect("AddUser.jsp");
            }
            if (book1 != null && user1 != null) {
                if (book1.getAvailable().equals(Available.no)) {
                    issueBook.setBook(book1);
                    issueBook.setUser(user1);
                    issueBook.setStatus(Status.returned);
                    issueBook.setIssueddate(new Date());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(issueBook.getIssueddate());
                    cal.add(Calendar.DATE, 10);
                    Date returndate = cal.getTime();
                    issueBook.setExpectedreturndate(returndate);
                    book1.setAvailable(Available.yes);
                    BookTrail bookTrail = new BookTrail();
                    ReturnBook returnBook = new ReturnBook();
                    bookTrail.setBook(book1);
                    bookTrail.setUser(user1);
                    bookTrail.setStatus(Status.returned);
                    bookTrail.setIssuedate(issueBook.getIssueddate());
                    bookTrail.setExpectedReturnDate(issueBook.getExpectedreturndate());
                    returnBook.setBookTrail(bookTrail);
                    returnBook.setReturndate(new Date());
                    returnBook.setUser(user1);
                    if(returnBook.getReturndate().compareTo(issueBook.getExpectedreturndate())> 0){
                        returnBook.setFine(String.valueOf(40));
                    }
                    else{
                        returnBook.setFine(String.valueOf(0));
                    }

                    if (bookI.issueBook(book1, issueBook) && bookTrailI.addBookTrail(bookTrail) && bookI.returnBook(book1,returnBook)) {
                        out.println("Successful");
                        resp.sendRedirect("UserNav.jsp");
                    } else {
                        out.println("<html><body><p>Unable To find the book</p><body></html>");
                    }
                }
            } else {
                out.println("<html><body><p>ERROR</p><body></html>");
            }


        } else {
            resp.sendRedirect("LoginUser.jsp");
        }
    }
}

