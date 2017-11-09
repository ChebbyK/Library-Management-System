import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Local
@Stateless
public class AuditBean implements AuditI {
    @PersistenceContext
    EntityManager entityManager;

    public boolean addAuditTrail(AuditTrail auditTrail) {
      AuditDao auditDao= new AuditDao(entityManager);
      return  auditDao.addAudit(auditTrail);
    }

    public List<AuditTrail> viewAuditTrail() {
        AuditDao auditDao = new AuditDao(entityManager);
        return auditDao.viewAuditTrail();
    }
}
