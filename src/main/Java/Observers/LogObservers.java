import javax.ejb.EJB;
import javax.enterprise.event.Observes;

public class LogObservers {
    @EJB
    AuditI auditI;
    public void send(@Observes LogEvent logEvent){
        auditI.addAuditTrail(logEvent.getAuditTrail());
    }
}
