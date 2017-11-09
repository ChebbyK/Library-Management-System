import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class BookTrailDao extends  CustomDao<BookTrail> {
    public BookTrailDao(EntityManager entityManager) {
        super(entityManager);
    }
    boolean addTrail(BookTrail bookTrail){
        return  this.addCustom(bookTrail);
    }
    @SuppressWarnings(value = "unchecked")
    public List<BookTrail> viewBookById(BookTrail bookTrail){
        try{
            return entityManager.createNamedQuery("viewbyid").setParameter("inventory",bookTrail.getBook().getInventoryId()).getResultList();

        }
        catch(PersistenceException e){
            e.printStackTrace();
            return null;
        }
    }
}
