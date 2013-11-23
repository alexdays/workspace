package client.controller.rest;

import client.entity.BookInformation;
import client.entity.Library;
import client.entity.Request;
import client.entity.UpdateRequestInformation;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.util.List;

public class RestClient {

    private Client client;
    private WebResource service;

    public RestClient() {
        super();
        init();
    }

    private void init() {

        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        service = client.resource("http://localhost:8080/webWeb/");
    }

    public String getAuthorByTitle(String title) {

        String author = service.path("library").path("geta").path(title)
                .get(String.class);
        return author;
    }

    public String getTitleByAuthor(String author) {

        String title = service.path("library").path("gett").path(author)
                .get(String.class);
        return title;
    }

    public void addBook(BookInformation bookInformation) {

        service.path("library").path("add").path(bookInformation.getAuthor()).path(bookInformation.getTitle())
                .put(ClientResponse.class);
    }

    public void deleteBook(BookInformation bookInformation) {

        service.path("library").path("delete").path(bookInformation.getTitle())
                .delete();
    }

    public void setBookTitle(UpdateRequestInformation information) {
        Request request = new Request(information, Request.UPDATE_TITLE);
        service.path("library")
                .post(ClientResponse.class, request);
    }

    public void setBookAuthor(UpdateRequestInformation information) {
        Request request = new Request(information, Request.UPDATE_AUTHOR);
        service.path("library")
                .post(ClientResponse.class, request);
    }

    public List<BookInformation> getAllBooks(){
        Library library = service.path("library").get(Library.class);
        return library.getBook();
    }
}
