package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {

    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String userName = "localhost";
            String password = "parola123";

            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }
}
