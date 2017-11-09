import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "bookid",query = "select  s from Book s where s.inventoryId=:inventory"),
        @NamedQuery(name = "viewallbooks",  query = "select b from Book b"),
        @NamedQuery(name= "deletebook", query="delete  from Book s where s.inventoryId=:inventory")
})
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long bookId;
    @Column(unique = true)
    String inventoryId;
    String bookname;
    String author;
    @Enumerated(EnumType.STRING)
    Bookcategory bookcategory;
    @Enumerated(EnumType.STRING)
    Available available;
    String yearPublished;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Bookcategory getBookcategory() {
        return bookcategory;
    }

    public void setBookcategory(Bookcategory bookcategory) {
        this.bookcategory = bookcategory;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Available getAvailable() {
        return available;
    }

    public void setAvailable(Available available) {
        this.available = available;
    }
}
