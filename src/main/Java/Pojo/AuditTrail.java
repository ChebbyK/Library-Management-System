import javax.ejb.EJB;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
@Entity
@NamedQueries({
        @NamedQuery(name = "viewallactivity",  query = "select a from AuditTrail a")
})
public class AuditTrail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long auditId;
    String detail,name;
    Date date;
    Time time;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
