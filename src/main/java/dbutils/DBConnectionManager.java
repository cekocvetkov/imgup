package dbutils;

import exceptions.ConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnectionManager {

    private static final Logger log = Logger.getLogger( DBConnectionManager.class.getName() );
    private Connection connection;

    public Connection getConnection() throws ConnectionException, ClassNotFoundException {
        if (connection == null) {
            InputStream inputStream = getClass().getResourceAsStream("/db.properties");
            Properties props = new Properties();
            try {
                props.load(inputStream);
                Class.forName("org.postgresql.Driver");
                String connectionUrl = "jdbc:postgresql://" + props.getProperty("server") + ":" + props.getProperty("port") + "/" + props.getProperty("database");
                connection = DriverManager.getConnection(connectionUrl, props.getProperty("user"), props.getProperty("password"));
                connection.prepareStatement("set schema 'imgupload'").execute();
                log.info("Connected to PostgreSQL Database");
            } catch (IOException e) {
                log.info("database properties could not be read");
                throw new ConnectionException(e);
            } catch (SQLException e) {
                log.info("database connection could not be established");
                throw new ConnectionException(e);
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.info("Failed to close connection\n"+e);
            }
            connection = null;
        }
    }
}
