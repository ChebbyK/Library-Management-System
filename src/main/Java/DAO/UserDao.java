import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class UserDao extends CustomDao<User>{


    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean registerUser(User user) {
        return this.addCustom(user);
    }
    @SuppressWarnings(value = "unchecked")
    public List<Book> viewBook() {
        try{
            return entityManager.createNamedQuery("viewallbooks").getResultList();
        }
        catch (PersistenceException e){
            e.printStackTrace();
            return null;
        }
    }
    @SuppressWarnings(value = "unchecked")
    public User searchUser(User user) {
        try{
            List<User> user1=entityManager.createNamedQuery("userid").setParameter("natid",user.getNatId()).getResultList();
            return user1.size()>0?user1.get(0):null;
        }
        catch(PersistenceException e){
            e.printStackTrace();
            return null;
        }
    }
    }



