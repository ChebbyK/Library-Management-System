import javax.persistence.*;
import java.util.Date;

@Entity
public class ReturnBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    BookTrail bookTrail;
    Date returndate;
    @ManyToOne
    User user;
    String fine;

    public BookTrail getBookTrail() {
        return bookTrail;
    }

    public void setBookTrail(BookTrail bookTrail) {
        this.bookTrail = bookTrail;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }
}
