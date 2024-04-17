package org.CRUDOperation;

import org.JDBCUtil.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMySQLQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtil.getJdbcConnection();
            if (connection != null){
                String mySqlQuery = "INSERT INTO student(s_id, name, marks) VALUES (?, ?, ?)";

                preparedStatement = connection.prepareStatement(mySqlQuery);

                if (preparedStatement != null){
                    preparedStatement.setString(2, "suda");
                    preparedStatement.setInt(1, 101);
                    preparedStatement.setInt(3, 60);

                    int effectedRow = preparedStatement.executeUpdate();

                    if (effectedRow ==1) { System.out.println("Row Inserted");}
                    else {System.out.println("Row not Inserted");}

                }

//                statement = connection.createStatement();
//                //String myInsertQuery = "INSERT INTO student(s_id, name, marks) VALUES (01, 'adam', 99),(02, 'bob', 66), (03, 'marley', 77),(09, 'casey', 88),(10, 'paul', 88);";
//                String myInsertQuery = "TRUNCATE TABLE student";
//
//                int effectedRow =
//                        statement.executeUpdate(myInsertQuery);
//
//                if (effectedRow==1){
//                    System.out.println("Row Inserted");
//                } else System.out.println("Row not Inserted");
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
