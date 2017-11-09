import javax.ejb.Local;
import java.util.List;
@Local
public interface AuditI {
    boolean addAuditTrail(AuditTrail auditTrail);
    List<AuditTrail> viewAuditTrail();
}
