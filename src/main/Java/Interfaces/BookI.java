import javax.ejb.Local;
import java.util.List;
@Local
public interface BookI extends BookActivity{
    boolean addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Book book);
     Book getById(Book book);
    List <Book> viewBook();
    List<Book>search(Book book);



}
