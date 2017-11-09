import javax.persistence.*;
import java.util.Date;


@NamedQueries({
        @NamedQuery(name = "viewissuebook",  query = "select b from IssueBook b")
})
@Entity
public class IssueBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    User user;
    @OneToOne
    Book book;
    Date issueddate;
    Date expectedreturndate;
    @Enumerated(EnumType.STRING)
    Status status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getIssueddate() {
        return issueddate;
    }

    public void setIssueddate(Date issueddate) {
        this.issueddate = issueddate;
    }

    public Date getExpectedreturndate() {
        return expectedreturndate;
    }

    public void setExpectedreturndate(Date expectedreturndate) {
        this.expectedreturndate = expectedreturndate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
