import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Local
@Stateless
public class LibrarianBean implements LibrarianI {
    @PersistenceContext
    EntityManager entityManager;
    public boolean addLibrarian(Librarian librarian) {
       LibrarianDao librarianDao = new LibrarianDao(entityManager);
      return librarianDao.addLibrarian(librarian);
    }

    public Librarian getById(Librarian librarian) {
        LibrarianDao librarianDao = new LibrarianDao(entityManager);
        return librarianDao.getById(librarian);
    }
}
