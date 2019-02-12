package server.models.services;

import server.Logger;
import server.DatabaseConnection;
import server.models.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EntityService {

    public static String selectAllInto(List<Entity> targetList) {
        targetList.clear();
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT UserID, RiderID, RiderLevel, RiderEXP, RiderEXPtoNextLevel, DeathEXP, UnlockLevel, Level-statmodifier, characterlevelstatmodifier, Nextarmourlevelmultiplier FROM entity"
            );
            if (statement != null) {
                ResultSet results = statement.executeQuery();
                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Entity(results.getInt("UserID"), results.getString("RiderID"), results.getInt("RiderLevel"), results.getInt("RiderEXP"), results.getInt("RiderEXPtoNextLevel"), results.getInt("DeathEXP"), results.getInt("UnlockLevel"), results.getFloat("Level-statmodifier"), results.getFloat("characterlevelstatmodifier"), results.getInt("Nextarmourlevelmultiplier")));


                    }
                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select all from 'entity' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
        return "OK";
    }

    public static Entity selectById(int id) {
        Entity result = null;
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT UserID, RiderID, RiderLevel, RiderEXP, RiderEXPtoNextLevel, DeathEXP, UnlockLevel, Level-statmodifier, characterlevelstatmodifier, Nextarmourlevelmultiplier FROM entity WHERE UserID = ?"
            );
            if (statement != null) {
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                if (results != null && results.next()) {
                    result = new Entity(results.getInt("UserID"), results.getString("RiderID"), results.getInt("RiderLevel"), results.getInt("RiderEXP"), results.getInt("RiderEXPtoNextLevel"), results.getInt("DeathEXP"), results.getInt("UnlockLevel"), results.getFloat("Level-statmodifier"), results.getFloat("characterlevelstatmodifier"), results.getInt("Nextarmourlevelmultiplier"));



                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select by id from 'entity' table: " + resultsException.getMessage();

            Logger.log(error);
        }
        return result;
    }

    public static String insert(Entity itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "INSERT INTO entity (UserID, RiderID, RiderLevel, RiderEXP, RiderEXPtoNextLevel, DeathEXP, UnlockLevel, Level-statmodifier, characterlevelstatmodifier, Nextarmourlevelmultiplier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setInt(1, itemToSave.getEntity_ID());
            statement.setString(2, itemToSave.getEntity_name());
            statement.setInt(3, itemToSave.getEntity_health());
            statement.setInt(4, itemToSave.getEntity_defence());
            statement.setInt(5, itemToSave.getWeapon_id());
            statement.setInt(6, itemToSave.getDeath_exp());
            statement.setInt(7, itemToSave.getUnlock_level());
            statement.setFloat(8, itemToSave.getLevel_stat_modifier());
            statement.setFloat(9, itemToSave.getCharacter_level_stat_modifier());
            statement.setInt(10, itemToSave.getNext_armour_level_multiplier());






            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't insert into 'entity' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

    public static String update(Entity itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "UPDATE entity SET RiderID = ?, RiderLevel = ?, RiderEXP = ?, RiderEXPtoNextLevel = ?, DeathEXP = ?, UnlockLevel = ?, Level-statmodifier = ?, characterlevelstatmodifier = ?, Nextarmourlevelmultiplier = ? WHERE UserID = ?"
            );
            statement.setString(1, itemToSave.getEntity_name());
            statement.setInt(2, itemToSave.getEntity_health());
            statement.setInt(3, itemToSave.getEntity_defence());
            statement.setInt(4, itemToSave.getWeapon_id());
            statement.setInt(5, itemToSave.getDeath_exp());
            statement.setInt(6, itemToSave.getUnlock_level());
            statement.setFloat(7, itemToSave.getLevel_stat_modifier());
            statement.setFloat(8, itemToSave.getCharacter_level_stat_modifier());
            statement.setInt(9, itemToSave.getNext_armour_level_multiplier());






            statement.setInt(10, itemToSave.getEntity_ID());
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't update 'entity' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

    public static String deleteById(int id) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "DELETE FROM entity WHERE UserID = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't delete by id from 'entity' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

}