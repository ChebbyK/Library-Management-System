import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class BookTrailBean implements  BookTrailI {
    @PersistenceContext
    EntityManager entityManager;
    public boolean addBookTrail(BookTrail bookTrail) {
        BookTrailDao bookTrailDao = new BookTrailDao(entityManager);
        return bookTrailDao.addTrail(bookTrail);
    }

    public List<BookTrail> viewBookById(BookTrail bookTrail) {
        BookTrailDao bookTrailDao = new BookTrailDao(entityManager);
        return bookTrailDao.viewBookById(bookTrail);
    }
}
