import javax.ejb.Local;

@Local
public interface LibrarianI {
    boolean addLibrarian(Librarian librarian);
    Librarian getById(Librarian librarian);
}
