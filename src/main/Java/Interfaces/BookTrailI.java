import javax.ejb.Local;
import javax.persistence.NamedQuery;
import java.util.List;
@Local
public interface BookTrailI {
    boolean addBookTrail(BookTrail bookTrail);
    List<BookTrail>viewBookById(BookTrail bookTrail);

}
