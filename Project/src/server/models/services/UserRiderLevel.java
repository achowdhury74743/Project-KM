package server.models.services;

import server.Logger;
import server.DatabaseConnection;
import server.models.UserRiderLevel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRiderLevelService {

public static String selectAllInto(List<UserRiderLevel> targetList) {
        targetList.clear();
        try {
        PreparedStatement statement = DatabaseConnection.newStatement(
        "SELECT User ID, Rider ID, Rider Level, Rider EXP, Rider EXP to Next Level FROM User-Rider-Level"
        );
        if (statement != null) {
        ResultSet results = statement.executeQuery();
        if (results != null) {
        while (results.next()) {
        targetList.add(new User-Rider-Level(results.getInt("User ID"), results.getInt("Rider ID"), results.getInt("Rider Level"), results.getInt("Rider EXP"), results.getInt("Rider EXP to Next Level")));


        }
        }
        }
        } catch (SQLException resultsException) {
        String error = "Database error - can't select all from 'User-Rider-Level' table: " + resultsException.getMessage();

        Logger.log(error);
        return error;
        }
        return "OK";
        }

public static User-Rider-Level selectById(int id) {
        User-Rider-Level result = null;
        try {
        PreparedStatement statement = DatabaseConnection.newStatement(
        "SELECT User ID, Rider ID, Rider Level, Rider EXP, Rider EXP to Next Level FROM User-Rider-Level WHERE User ID = ?"
        );
        if (statement != null) {
        statement.setInt(1, id);
        ResultSet results = statement.executeQuery();
        if (results != null && results.next()) {
        result = new User-Rider-Level(results.getInt("User ID"), results.getInt("Rider ID"), results.getInt("Rider Level"), results.getInt("Rider EXP"), results.getInt("Rider EXP to Next Level"));


        }
        }
        } catch (SQLException resultsException) {
        String error = "Database error - can't select by id from 'User-Rider-Level' table: " + resultsException.getMessage();

        Logger.log(error);
        }
        return result;
        }

public static String insert(User-Rider-Level itemToSave) {
        try {
        PreparedStatement statement = DatabaseConnection.newStatement(
        "INSERT INTO User-Rider-Level (User ID, Rider ID, Rider Level, Rider EXP, Rider EXP to Next Level) VALUES (?, ?, ?, ?, ?)"
        );
        statement.setInt(1, itemToSave.getUser ID());
        statement.setInt(2, itemToSave.getRider ID());
        statement.setInt(3, itemToSave.getRider level());
        statement.setInt(4, itemToSave.getRider EXP());
        statement.setInt(5, itemToSave.getRider EXP to next level());











        statement.executeUpdate();
        return "OK";
        } catch (SQLException resultsException) {
        String error = "Database error - can't insert into 'User-Rider-Level' table: " + resultsException.getMessage();

        Logger.log(error);
        return error;
        }
        }

public static String update(User-Rider-Level itemToSave) {
        try {
        PreparedStatement statement = DatabaseConnection.newStatement(
        "UPDATE User-Rider-Level SET Rider ID = ?, Rider Level = ?, Rider EXP = ?, Rider EXP to Next Level = ? WHERE User ID = ?"
        );
        statement.setInt(1, itemToSave.getRider ID());
        statement.setInt(2, itemToSave.getRider level());
        statement.setInt(3, itemToSave.getRider EXP());
        statement.setInt(4, itemToSave.getRider EXP to next level());











        statement.setInt(5, itemToSave.getUser ID());
        statement.executeUpdate();
        return "OK";
        } catch (SQLException resultsException) {
        String error = "Database error - can't update 'User-Rider-Level' table: " + resultsException.getMessage();

        Logger.log(error);
        return error;
        }
        }

public static String deleteById(int id) {
        try {
        PreparedStatement statement = DatabaseConnection.newStatement(
        "DELETE FROM User-Rider-Level WHERE User ID = ?"
        );
        statement.setInt(1, id);
        statement.executeUpdate();
        return "OK";
        } catch (SQLException resultsException) {
        String error = "Database error - can't delete by id from 'User-Rider-Level' table: " + resultsException.getMessage();

        Logger.log(error);
        return error;
        }
        }

        }