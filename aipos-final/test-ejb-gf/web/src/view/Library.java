package view;

import container.LibraryPersistentBean;
import container.entity.BookInformation;
import view.entity.Request;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.SystemException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.util.List;

@Path("library")
public class Library {

    LibraryPersistentBean library;

    public Library() throws NamingException {
        library = (LibraryPersistentBean) new InitialContext()
                .lookup("java:app/ejb/LibraryPersistentEJB!container.LibraryPersistentBean");
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public view.entity.Library getBooks() throws JAXBException {
        List<BookInformation> books = library.getAllBooks();
        view.entity.Library lib = new view.entity.Library();
        lib.setBook(books);
        return lib;
    }

    @GET
    @Path("geta/{title}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBookAuthor(@PathParam("title") String title) {
        try {
            return library.getAuthorByTitle(title);
        } catch (SystemException e) {
            return "UNKNOWN";
        } catch (RuntimeException e) {
            return "UNKNOWN";
        }
    }

    @GET
    @Path("gett/{author}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBookTitle(@PathParam("author") String author) {
        try {
            return library.getTitleByAuthor(author);
        } catch (SystemException e) {
            return "UNKNOWN";
        } catch (RuntimeException e) {
            return "UNKNOWN";
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void updateBook(JAXBElement<Request> element) {
        Request request = element.getValue();
        switch (request.getType()) {
            case Request.UPDATE_AUTHOR:
                library.setBookAuthor(request.getRequestInformation());
                break;
            case Request.UPDATE_TITLE:
                library.setBookTitle(request.getRequestInformation());
                break;
        }
    }

    @PUT
    @Path("add/{author}/{title}")
    public void addBook(@PathParam("title") String title, @PathParam("author") String author) {
        BookInformation bookInformation = new BookInformation(author, title);
        library.addBook(bookInformation);
    }

    @DELETE
    @Path("delete/{title}")
    public void deleteBook(@PathParam("title") String title) {
        library.deleteBook(title);
    }
}
