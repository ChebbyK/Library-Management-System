import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Custom  extends HttpServlet{
    public String getData(HttpServletRequest req, String data) {
        return req.getParameter(data);
    }

    public void selectBookCategory(HttpServletRequest req, Book book1) {
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
