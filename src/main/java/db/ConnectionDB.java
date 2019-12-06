package db;

import models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionDB {
    private static Connection myConnection = null;
    private Statement myStatement = null;
    private ResultSet myResultSet = null;

    public static Connection createUserConnection() {
        try {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            connection.init("jdbc:mysql://localhost:3306/macao");
            myConnection = DatabaseConnection.getInstance().getConnection();
            return myConnection;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("CONNECTION FAILED");
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public ArrayList<User> getAccounts() {
        createUserConnection();
        ArrayList<User> users = new ArrayList<User>();
        try {
            myStatement = myConnection.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                int id = rs.getInt("idusers");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String userType = rs.getString("usertype");
                User user = new User(id, username, password, userType);
                users.add(user);
            }
            if (users.isEmpty()) {
                System.out.println("Nu exista niciun user in  baza de date");
            }
            rs.close();
            myStatement.close();
            myConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Connection getMyConnection() {
        return myConnection;
    }

    public void setMyConnection(Connection myConnection) {
        ConnectionDB.myConnection = myConnection;
    }

    public Statement getMyStatement() {
        return myStatement;
    }

    public void setMyStatement(Statement myStatement) {
        this.myStatement = myStatement;
    }

    public ResultSet getMyResultSet() {
        return myResultSet;
    }

    public void setMyResultSet(ResultSet myResultSet) {
        this.myResultSet = myResultSet;
    }
}
