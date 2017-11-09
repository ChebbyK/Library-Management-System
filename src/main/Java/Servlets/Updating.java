import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Updating extends HttpServlet {
    @EJB
    BookI bookI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("sName")!=null){
        PrintWriter out = resp.getWriter();
        Book book = new Book();
        book.setInventoryId((req.getParameter("bookid")));
        Book book1 = bookI.getById(book);
        if (book1 != null && book1.getAvailable().equals(Available.yes)){
            book1.setBookname(req.getParameter("name"));
            book1.setAuthor(req.getParameter("author"));
//            String bookCat = (req.getParameter("bookcat"));

            selectBookCategory(req, book1);
//            if (bookCat.equals("science")) {
//                book1.setBookcategory(Bookcategory.science);
//            } else if (bookCat.equals("maths")) {
//                book1.setBookcategory(Bookcategory.mathematics);
//            } else if (bookCat.equals("law")) {
//                book1.setBookcategory(Bookcategory.law);
//            } else if (bookCat.equals("history")) {
//                book1.setBookcategory(Bookcategory.history);
//            } else if (bookCat.equals("art")) {
//                book1.setBookcategory(Bookcategory.art);
//            } else if (bookCat.equals("language")) {
//                book1.setBookcategory(Bookcategory.languages);
//            }
            book1.setYearPublished(req.getParameter("year"));

            if (bookI.updateBook(book1)) {
                out.println("SUCCESSFUL");
                resp.sendRedirect("index.jsp");

            } else {
                out.println("Could not register");
            }
        }
        else{
out.println("The Book is not available");
        }
        }

        else{
            resp.sendRedirect("LoginLibrarian.jsp");
        }
}

    private void selectBookCategory(HttpServletRequest req, Book book1) {
        if (req.getParameter("bookcat").equals("science"))
        {book1.setBookcategory(Bookcategory.science);}
        else if (req.getParameter("bookcat").equals("maths")){
            book1.setBookcategory(Bookcategory.mathematics);
        }else if (req.getParameter("bookcat").equals("law")){
            book1.setBookcategory(Bookcategory.law);
        }else if (req.getParameter("bookcat").equals("history")){
            book1.setBookcategory(Bookcategory.history);
        }else  if (req.getParameter("bookcat").equals("art")){
            book1.setBookcategory(Bookcategory.art);
        }else if (req.getParameter("bookcat").equals("languages")){
            book1.setBookcategory(Bookcategory.languages);
        }
    }
}
