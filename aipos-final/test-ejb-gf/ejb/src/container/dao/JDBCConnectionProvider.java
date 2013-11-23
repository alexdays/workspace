package container.dao;

import javax.ejb.Stateless;
import java.sql.*;

@Stateless
public class JDBCConnectionProvider {

    private Statement statement;

    public JDBCConnectionProvider() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/aipos5",
                    "root",
                    "festinelente"
            );
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public boolean execute(String query) throws SQLException {
        return statement.execute(query);
    }
}
