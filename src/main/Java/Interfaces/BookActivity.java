import javax.ejb.Local;
import java.util.List;
@Local
public interface BookActivity {
    boolean issueBook(Book book, IssueBook issueBook);
    boolean returnBook(Book book, ReturnBook returnBook);
}
