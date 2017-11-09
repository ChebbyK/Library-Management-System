import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name= "loginstaff", query = "select  s from Librarian s where s.username=:usern and s.password=:pass"),
        @NamedQuery(name = "staffid",query = "select  s from Librarian s where s.empnumber=:natid"),
})
public class Librarian extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long libid;
    @Column(unique = true)
    String empnumber;

    public long getLibid() {
        return libid;
    }

    public void setLibid(long libid) {
        this.libid = libid;
    }

    public String getEmpnumber() {
        return empnumber;
    }

    public void setEmpnumber(String empnumber) {
        this.empnumber = empnumber;
    }
}
