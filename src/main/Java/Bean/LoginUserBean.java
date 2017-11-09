import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Local
@Stateless
@Authenticate(Authenticate.logChoice.user)
public class LoginUserBean implements LoginI {
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    Event<LogEvent> event;
    public boolean login(String Username, String Password) {
        try{
            List<User> userList= entityManager.createNamedQuery("loginuser").setParameter("usern",Username ).setParameter("pass", Password).getResultList();
            if (userList.size() > 0) {
            AuditTrail auditTrail=new AuditTrail();
            auditTrail.setDetail("login");
            auditTrail.setName(Username);
            auditTrail.setTime(new Time(Calendar.getInstance().getTimeInMillis()));
            auditTrail.setDate(new Date());
            LogEvent logEvent=new LogEvent();
            logEvent.setAuditTrail(auditTrail);
            event.fire(logEvent);
            }
            return userList.size()>0;
        }
        catch (PersistenceException e){
            e.printStackTrace();
            return  false;
        }
    }
}
