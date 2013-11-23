package client.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}