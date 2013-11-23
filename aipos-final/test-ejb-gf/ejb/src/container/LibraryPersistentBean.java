package container;

import container.convert.LibraryConverter;
import container.dao.LibraryDAO;
import container.entity.Author;
import container.entity.Book;
import container.entity.BookInformation;
import container.entity.UpdateRequestInformation;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "LibraryPersistentEJB")
public class LibraryPersistentBean {

    @PersistenceContext(unitName="LibraryDataService")
    EntityManager entityManager;

    @Resource
    UserTransaction transaction;

    @EJB(beanName = "LibraryConverter")
    LibraryConverter converter;

    @EJB
    LibraryDAO libraryDAO;

    public LibraryPersistentBean() {
    }

    public List<BookInformation> getAllBooks() {
        List<BookInformation> retVal;
        try {
            transaction.begin();
            List<Author> authors = entityManager.createQuery("select a from Author a").getResultList();
            retVal = converter.convertToLibrary(authors);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Cannot fetch information from DB. \n" + e.getMessage(), e);
        }
        return retVal;
    }

    public String getAuthorByTitle(String title) throws SystemException {
        Author author;
        try {
            transaction.begin();
            author = searchBook(createNewBook(null, title)).getAuthor();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Cannot fetch information from DB. \n" + e.getMessage(), e);
        }
        return author.getName();
    }

    public String getTitleByAuthor(String author) throws SystemException {
        Book book;
        try {
            transaction.begin();
            List<Book> books = searchAuthor(createNewAuthor(author)).getBook();
            if(books.size() == 0) {
                return "UNKNOWN";
            }
            book = books.get(0);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Cannot fetch information from DB. \n" + e.getMessage(), e);
        }
        return book.getTitle();
    }

    public void addBook(BookInformation bookInfo) {
        try {
            libraryDAO.addBook(bookInfo);
        } catch (Exception e) {
            throw new RuntimeException("Cannot fetch information from DB. \n" + e.getMessage(), e);
        }
    }

    public void deleteBook(String title) {
        try {
            transaction.begin();
            entityManager.remove(searchBook(createNewBook(null, title)));
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException("Cannot fetch information from DB. \n" + e.getMessage(), e);
        }
    }

    public void setBookTitle(UpdateRequestInformation requestInformation) {
        try {
            libraryDAO.updateBookTitle(requestInformation);
        } catch (Exception e) {
            throw new RuntimeException("Cannot fetch information from DB. \n" + e.getMessage(), e);
        }
    }

    public void setBookAuthor(UpdateRequestInformation requestInformation) {
        try {
            libraryDAO.updateAuthorName(requestInformation);
        } catch (Exception e) {
            throw new RuntimeException("Cannot fetch information from DB. \n" + e.getMessage(), e);
        }
    }

    private Author createNewAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        author.setBook(new ArrayList<Book>());
        return author;
    }

    private Book createNewBook(Author author, String title) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        return book;
    }

    private Author searchAuthor(Author author) {
        Author storedAuthor = (Author) entityManager.createQuery("select a from Author a where a.name = :authorName")
                    .setParameter("authorName", author.getName())
                    .getSingleResult();
        return storedAuthor;
    }

    private Book searchBook(Book book) {
        Book storedBook = (Book) entityManager.createQuery("select b from Book b where b.title = :bookTitle")
                    .setParameter("bookTitle", book.getTitle())
                    .getSingleResult();
        return storedBook;
    }
}
