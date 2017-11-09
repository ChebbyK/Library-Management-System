import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class IssueBookDao extends CustomDao<IssueBook> {
    public IssueBookDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean addIssuedBook(IssueBook issueBook) {
        return this.addCustom(issueBook);

    }
    @SuppressWarnings(value = "unchecked")
    public List<IssueBook> viewAllActivities(){
        try{
            return entityManager.createNamedQuery("viewissuebook").getResultList();
        }
        catch (PersistenceException e){
            e.printStackTrace();
            return null;
        }
    }

}