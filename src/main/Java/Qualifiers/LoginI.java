import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public interface LoginI {
    boolean login(String Username, String Password);
}
