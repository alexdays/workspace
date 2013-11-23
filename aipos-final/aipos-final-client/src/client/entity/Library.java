package client.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Library {

    private List<BookInformation> book;

    public Library() {
        super();
    }

    public Library(List<BookInformation> book) {
        super();
        this.book = book;
    }

    public List<BookInformation> getBook() {
        return book;
    }

    public void setBook(List<BookInformation> book) {
        this.book = book;
    }
}
