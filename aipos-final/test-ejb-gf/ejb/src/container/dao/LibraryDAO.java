package container.dao;

import container.entity.BookInformation;
import container.entity.UpdateRequestInformation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;

@Stateless
public class LibraryDAO {

    @EJB
    JDBCConnectionProvider connectionProvider;

    public void addBook(BookInformation bookInformation) {
        String queryAuthor = "INSERT INTO author (name) VALUES ('" + bookInformation.getAuthor() + "');";
        String queryBook = "INSERT INTO book (title, author_id) " +
                "VALUES ('" + bookInformation.getTitle() +
                "', (SELECT id FROM author WHERE name = '" + bookInformation.getAuthor() + "'));";
        try {
            connectionProvider.execute(queryAuthor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connectionProvider.execute(queryBook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAuthorName(UpdateRequestInformation bookInformation) {
        String query = "UPDATE author SET " +
                "name = '" + bookInformation.getNewTemp() + "' " +
                "WHERE name = '" + bookInformation.getConstant() + "';";
        try {
            connectionProvider.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBookTitle(UpdateRequestInformation bookInformation) {
        String query = "UPDATE book SET " +
                "title = '" + bookInformation.getNewTemp() + "' " +
                "WHERE author_id = (SELECT id FROM author WHERE name = '" + bookInformation.getConstant() + "') " +
                "AND title = '" + bookInformation.getTemp() + "';";
        try {
            connectionProvider.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
