package server.models.services;

import server.Logger;
import server.DatabaseConnection;
import server.models.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersService {

    public static String selectAllInto(List<Users> targetList) {
        targetList.clear();
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT Id, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O FROM user"
            );
            if (statement != null) {
                ResultSet results = statement.executeQuery();
                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Users(results.getInt("Id"), results.getString("A"), results.getString("B"), results.getString("C"), results.getString("D"), results.getString("E"), results.getString("F"), results.getString("G"), results.getString("H"), results.getString("I"), results.getString("J"), results.getString("K"), results.getString("L"), results.getString("M"), results.getString("N"), results.getString("O")));


                    }
                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select all from 'user' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
        return "OK";
    }

    public static Users selectById(int id) {
        Users result = null;
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT Id, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O FROM user WHERE Id = ?"
            );
            if (statement != null) {
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                if (results != null && results.next()) {
                    result = new Users(results.getInt("Id"), results.getString("A"), results.getString("B"), results.getString("C"), results.getString("D"), results.getString("E"), results.getString("F"), results.getString("G"), results.getString("H"), results.getString("I"), results.getString("J"), results.getString("K"), results.getString("L"), results.getString("M"), results.getString("N"), results.getString("O"));


                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select by id from 'user' table: " + resultsException.getMessage();

            Logger.log(error);
        }
        return result;
    }

    public static String insert(Users itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "INSERT INTO user (Id, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setInt(1, itemToSave.getId());
            statement.setString(2, itemToSave.getA());
            statement.setString(3, itemToSave.getB());
            statement.setString(4, itemToSave.getC());
            statement.setString(5, itemToSave.getD());
            statement.setString(6, itemToSave.getE());
            statement.setString(7, itemToSave.getF());
            statement.setString(8, itemToSave.getG());
            statement.setString(9, itemToSave.getH());
            statement.setString(10, itemToSave.getI());
            statement.setString(11, itemToSave.getJ());
            statement.setString(12, itemToSave.getK());
            statement.setString(13, itemToSave.getL());
            statement.setString(14, itemToSave.getM());
            statement.setString(15, itemToSave.getN());
            statement.setString(16, itemToSave.getO());
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't insert into 'user' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

    public static String update(Users itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "UPDATE user SET A = ?, B = ?, C = ?, D = ?, E = ?, F = ?, G = ?, H = ?, I = ?, J = ?, K = ?, L = ?, M = ?, N = ?, O = ? WHERE Id = ?"
            );
            statement.setString(1, itemToSave.getA());
            statement.setString(2, itemToSave.getB());
            statement.setString(3, itemToSave.getC());
            statement.setString(4, itemToSave.getD());
            statement.setString(5, itemToSave.getE());
            statement.setString(6, itemToSave.getF());
            statement.setString(7, itemToSave.getG());
            statement.setString(8, itemToSave.getH());
            statement.setString(9, itemToSave.getI());
            statement.setString(10, itemToSave.getJ());
            statement.setString(11, itemToSave.getK());
            statement.setString(12, itemToSave.getL());
            statement.setString(13, itemToSave.getM());
            statement.setString(14, itemToSave.getN());
            statement.setString(15, itemToSave.getO());
            statement.setInt(16, itemToSave.getId());
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't update 'user' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

    public static String deleteById(int id) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "DELETE FROM user WHERE Id = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't delete by id from 'user' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

}