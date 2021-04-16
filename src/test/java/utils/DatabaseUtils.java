package utils;

import java.sql.*;

public class DatabaseUtils {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static Connection establishConnection() throws SQLException {
        String username = PropertyReader.databasePropertyReaderByKey("username");
        String password = PropertyReader.databasePropertyReaderByKey("password");
            return DriverManager.getConnection(
                    "jdbc:oracle:thin:@studentsuleyman.cnpfrjivolaz.us-east-2.rds.amazonaws.com:1521/ORCL", username, password);
    }

    public static Statement connectStatement() throws SQLException {
        return connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public static int getCountRow(){
        int rowCount=0;
        try {
            resultSet.last();
            rowCount=resultSet.getRow();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowCount;
    }

    public static void closeConnection(){
        if(connection!=null||statement!=null||resultSet!=null){
            try {
                connection.close();
                statement.close();
                resultSet.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
