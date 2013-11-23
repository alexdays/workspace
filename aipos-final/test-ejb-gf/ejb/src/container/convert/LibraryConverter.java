package container.convert;

import container.entity.Author;
import container.entity.Book;
import container.entity.BookInformation;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LibraryConverter {

    public LibraryConverter() {
        super();
    }

    public List<BookInformation> convertToLibrary(List<Author> authors) {
        List<BookInformation> library = new ArrayList<BookInformation>();
        for (Author author : authors) {
            library.addAll(convertToBookInformation(author.getName(), author.getBook()));
        }
        return library;
    }

    private List<BookInformation> convertToBookInformation(String authorName, List<Book> books) {
        List<BookInformation> libraryPart = new ArrayList<BookInformation>();
        for (Book book : books) {
            libraryPart.add(
                    new BookInformation(authorName, book.getTitle())
            );
        }
        return libraryPart;
    }

    public Author convertToAuthor(BookInformation bookInfo) {
        Author author = new Author();
        author.setName(bookInfo.getAuthor());
        return author;
    }
}
