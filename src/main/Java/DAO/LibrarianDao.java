import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class LibrarianDao extends CustomDao<Librarian> {

    public LibrarianDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean addLibrarian(Librarian librarian) {
        return this.addCustom(librarian);
    }
    @SuppressWarnings(value = "unchecked")
    public Librarian getById(Librarian librarian) {
        try {
            List<Librarian> book1 = entityManager.createNamedQuery("staffid").setParameter("natid", librarian.empnumber).getResultList();
            return book1.size() > 0 ? book1.get(0) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }
}