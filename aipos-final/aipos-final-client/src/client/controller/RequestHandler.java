package client.controller;


import client.controller.rest.RestClient;
import client.entity.BookInformation;
import client.entity.UpdateRequestInformation;

import javax.servlet.ServletContext;
import java.util.List;

public class RequestHandler {

    private static RequestHandler instance;
    private RestClient restClient;

    private RequestHandler() {
        restClient = new RestClient();
    }

    public static RequestHandler getInstance() {
        if (instance == null) {
            instance = new RequestHandler();
        }
        return instance;
    }

    public void process(Action action, UpdateRequestInformation bookInformation, ServletContext servletContext) {
        servletContext.setAttribute("authorName", bookInformation.getConstant());
        servletContext.setAttribute("bookTitle", bookInformation.getTemp());
        servletContext.setAttribute("newValue", bookInformation.getNewTemp());
        switch (action) {
            case ADD:
                addBook(convert(bookInformation));
                break;
            case REMOVE:
                removeBook(convert(bookInformation));
                break;
            case GET_AUTHOR:
                getAuthor(convert(bookInformation), servletContext);
                break;
            case GET_TITLE:
                getTitle(convert(bookInformation), servletContext);
                break;
            case UPDATE_AUTHOR:
                updateAuthor(bookInformation);
                break;
            case UPDATE_TITLE:
                updateTitle(bookInformation);
                break;
        }
    }

    private BookInformation convert(UpdateRequestInformation information) {
        return new BookInformation(
            information.getConstant(),
            information.getTemp()
        );
    }

    private void addBook(BookInformation bookInformation) {
        restClient.addBook(bookInformation);
    }

    private void removeBook(BookInformation bookInformation) {
        restClient.deleteBook(bookInformation);
    }

    private void getAuthor(BookInformation bookInformation, ServletContext servletContext) {
        String authorName = restClient.getAuthorByTitle(bookInformation.getTitle());
        servletContext.setAttribute("authorName", authorName);
    }

    private void getTitle(BookInformation bookInformation, ServletContext servletContext) {
        String bookTitle = restClient.getTitleByAuthor(bookInformation.getAuthor());
        servletContext.setAttribute("bookTitle", bookTitle);
    }

    private void updateAuthor(UpdateRequestInformation bookInformation) {
        restClient.setBookAuthor(bookInformation);
    }

    private void updateTitle(UpdateRequestInformation bookInformation) {
        restClient.setBookTitle(bookInformation);
    }

    public void fetchLibrary(ServletContext servletContext) {
        List<BookInformation> books = restClient.getAllBooks();
        servletContext.setAttribute("library", books);
    }
}
