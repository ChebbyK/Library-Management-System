import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "userid",query = "select  s from User s where s.natId=:natid"),
        @NamedQuery(name= "loginuser", query = "select  s from User s where s.username=:usern and s.password=:pass")
})
public class User extends  Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long userId;
    @Column(unique = true)
    String natId;
    String contact;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNatId() {
        return natId;
    }

    public void setNatId(String natId) {
        this.natId = natId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
