import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class IssueBookBean implements IssueBookI {
    @PersistenceContext
    EntityManager entityManager;
    public boolean addIssued(IssueBook issueBook) {
        IssueBookDao issueBookDao = new IssueBookDao(entityManager);
         return issueBookDao.addIssuedBook(issueBook);
    }

    public List<IssueBook> viewAllActivities() {
      IssueBookDao issueBookDao = new IssueBookDao(entityManager);
      return issueBookDao.viewAllActivities();
    }
}
