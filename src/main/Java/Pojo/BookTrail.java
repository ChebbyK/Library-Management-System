import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name= "viewbyid", query = "select b from BookTrail b where b.book.inventoryId=:inventory")
})
public class BookTrail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long bookId;
    @ManyToOne
    Book book;
    @ManyToOne
    User user;
    @Enumerated(EnumType.STRING)
    Status status;
    Date issuedate;
    Date expectedReturnDate;
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }
}
