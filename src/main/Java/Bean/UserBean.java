import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;
@Local
@Stateless
public class UserBean implements UserI {
    @PersistenceContext
    EntityManager entityManager;
    public boolean register(User user) {
        UserDao userDao = new UserDao(entityManager);
        return  userDao.registerUser(user);
    }

    public User search(User user){
        UserDao userDao = new UserDao(entityManager);
        return userDao.searchUser(user);
    }


}
