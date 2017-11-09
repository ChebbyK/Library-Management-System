import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class BookBean implements BookI {
    @PersistenceContext
    EntityManager entityManager;

    public boolean issueBook(Book book, IssueBook issueBook) {
        BookDao bookDao = new BookDao(entityManager);
        return bookDao.issueBook(book, issueBook);
    }

    public boolean addBook(Book book) {
        BookDao bookDao = new BookDao(entityManager);
        return  bookDao.addBook(book);
    }

    public boolean updateBook(Book book) {
        BookDao bookDao = new BookDao(entityManager);
        return  bookDao.updateBook(book);
        }

    public Book getById(Book book) {
        BookDao bookDao = new BookDao(entityManager);
        return bookDao.getById(book);
    }

    public List<Book> viewBook() {
        BookDao bookDao = new BookDao(entityManager);
        return bookDao.viewBook();
    }

    public List<Book> search(Book book) {
        BookDao bookDao = new BookDao(entityManager);
        return bookDao.search(book);
    }

    public boolean deleteBook(Book book) {
       BookDao bookDao = new BookDao(entityManager);
       return bookDao.deleteBook(book);
    }

    public boolean returnBook(Book book, ReturnBook returnBook) {
        BookDao bookDao = new BookDao(entityManager);
        return bookDao.returnBook(book,returnBook);
    }
}
