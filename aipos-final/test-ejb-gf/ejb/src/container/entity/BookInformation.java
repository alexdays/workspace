package container.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class BookInformation {

    private String author;

    private String title;

    public BookInformation() {
        super();
    }

    public BookInformation(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @XmlElement
    public String getAuthor() {
        return author;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }
}
