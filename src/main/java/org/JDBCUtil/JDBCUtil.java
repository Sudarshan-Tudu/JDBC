package org.JDBCUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    //Task to get the Properties from the Application and File and Loading the Driver with Connection.
    public static Connection getJdbcConnection() throws IOException, SQLException {
        FileInputStream fis = new FileInputStream("Application.properties");
        Properties p = new Properties(); //Properties is subclass of HashTable Class
        p.load(fis);

        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");

        System.out.println(url);
        System.out.println(user);
        System.out.println(password);

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if (connection != null){
            connection.close();
        }
        if (preparedStatement != null){
            preparedStatement.close();
        }
        if (resultSet != null){
            resultSet.close();
        }
    }
}
