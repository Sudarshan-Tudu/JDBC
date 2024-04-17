package org.CRUDOperation;

import org.JDBCUtil.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMySQLQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtil.getJdbcConnection();
            if (connection != null){
                String mySqlQuery = "SELECT * FROM student WHERE s_id=?";

                preparedStatement = connection.prepareStatement(mySqlQuery);

                if (preparedStatement != null){
                    preparedStatement.setInt(1, 101);

                    resultSet = preparedStatement.executeQuery();

                    if (resultSet!= null){

                    }
                }

            }
        } catch (IOException | SQLException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeResource(connection, preparedStatement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
