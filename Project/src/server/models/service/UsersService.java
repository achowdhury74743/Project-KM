package server.models.service;

import server.Logger;
import server.DatabaseConnection;
import server.models.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersService {

    public static String selectAllInto(List<server.models.Users> targetList) {
        targetList.clear();
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT UserID, Username, Password, Level, EXPtoNextLevel, UserEXP FROM User"
            );
            if (statement != null) {
                ResultSet results = statement.executeQuery();
                if (results != null) {
                    while (results.next()) {
                        targetList.add(new server.models.Users(results.getInt("UserID"), results.getString("Username"), results.getString("Password"), results.getInt("Level"), results.getInt("EXPtoNextLevel"), results.getInt("UserEXP")));


                    }
                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select all from 'User' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
        return "OK";
    }

    public static server.models.Users selectById(int id) {
        server.models.Users result = null;
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT UserID, Username, Password, Level, EXPtoNextLevel, UserEXP FROM User WHERE UserID = ?"
            );
            if (statement != null) {
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                if (results != null && results.next()) {
                    result = new server.models.Users(results.getInt("UserID"), results.getString("Username"), results.getString("Password"), results.getInt("Level"), results.getInt("EXPtoNextLevel"), results.getInt("UserEXP"));


                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select by id from 'User' table: " + resultsException.getMessage();

            Logger.log(error);
        }
        return result;
    }

    public static String insert(server.models.Users itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "INSERT INTO User (UserID, Username, Password, Level, EXPtoNextLevel, UserEXP) VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setInt(1, itemToSave.getUser_ID());
            statement.setString(2, itemToSave.getUsername());
            statement.setString(3, itemToSave.getPassword());
            statement.setInt(4, itemToSave.getLevel());
            statement.setInt(5, itemToSave.getExp_to_next_level());
            statement.setInt(6, itemToSave.getUser_exp());










            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't insert into 'User' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

    public static String update(server.models.Users itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "UPDATE User SET Username = ?, Password = ?, Level = ?, EXPtoNextLevel = ?, UserEXP = ? WHERE UserID = ?"
            );
            statement.setString(1, itemToSave.getUsername());
            statement.setString(2, itemToSave.getPassword());
            statement.setInt(3, itemToSave.getLevel());
            statement.setInt(4, itemToSave.getExp_to_next_level());
            statement.setInt(5, itemToSave.getUser_exp());










            statement.setInt(6, itemToSave.getUser_ID());
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't update 'User' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

    public static String deleteById(int id) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "DELETE FROM User WHERE UserID = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't delete by id from 'User' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

}