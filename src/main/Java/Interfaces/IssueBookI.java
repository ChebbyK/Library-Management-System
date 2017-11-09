import javax.ejb.Local;
import java.util.List;
@Local
public interface IssueBookI {
    boolean addIssued(IssueBook issueBook);
    public List<IssueBook> viewAllActivities();
}
