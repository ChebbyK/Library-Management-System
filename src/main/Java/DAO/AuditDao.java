import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class AuditDao extends  CustomDao<AuditTrail> {

    public AuditDao(EntityManager entityManager) {
        super(entityManager);
    }

    public  boolean addAudit(AuditTrail auditTrail){
        return this.addCustom(auditTrail);
    }
    @SuppressWarnings(value = "unchecked")
    public List<AuditTrail> viewAuditTrail(){
        try{
            return entityManager.createNamedQuery("viewallactivity").getResultList();
        }
        catch (PersistenceException e){
            e.printStackTrace();
            return null;
        }
    }
}
