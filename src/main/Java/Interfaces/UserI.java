import javax.ejb.Local;
import java.util.List;
@Local
public interface UserI  {
    boolean register(User user);
   User search(User user);

}
