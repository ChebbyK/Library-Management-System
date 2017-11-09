import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class BookDao extends CustomDao<Book>{


    public BookDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean issueBook(Book book , IssueBook issueBook) {
        if (getById(book) != null) {
            try {
                entityManager.merge(book);
                entityManager.persist(issueBook);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else
            return false;
    }
    public boolean returnBook(Book book, ReturnBook returnBook ){
        if (getById(book) != null) {
            try {
                entityManager.merge(book);
                entityManager.persist(returnBook);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else
            return false;
    }
    public boolean addBook(Book book) {
        return this.addCustom(book);
    }

    public  boolean updateBook(Book book) {
            try {
                entityManager.merge(book);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    }
    @SuppressWarnings(value = "unchecked")
    //List
    public Book getById(Book book) {
        try{
            List<Book> book1=entityManager.createNamedQuery("bookid").setParameter("inventory",book.getInventoryId()).getResultList();
            return book1.size()>0?book1.get(0):null;
        }
        catch(PersistenceException e){
            e.printStackTrace();
            return null;
        }
    }
    // Object
    public  List<Book> search(Book book){
        try{
            return entityManager.createNamedQuery("bookid").setParameter("inventory",book.getInventoryId()).getResultList();

        }
        catch(PersistenceException e){
            e.printStackTrace();
            return null;
        }
    }
    @SuppressWarnings(value = "unchecked")
    public List<Book> viewBook() {
        try{
            return entityManager.createNamedQuery("viewallbooks").getResultList();
        }
        catch (PersistenceException e){
            e.printStackTrace();
            return null;
        }
    }
    public  boolean deleteBook(Book book) {
        try {
            entityManager.remove(entityManager.merge(book));

//            int delete = entityManager.createNamedQuery("deletebook").setParameter("inventory", book.getInventoryId()).executeUpdate();
//            if (delete > 0) {
                return true;
//            } else {
//                return false;
//            }
        }
        catch (PersistenceException e){
            e.printStackTrace();
            return false;
        }
    }
}
