import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

public class CustomDao<T> {

    EntityManager entityManager;

    public CustomDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  boolean addCustom(T t){
        try {
            entityManager.persist(t);
            return true;
        }
        catch (PersistenceException e){
            e.printStackTrace();
            return  false;
        }

    }
}
