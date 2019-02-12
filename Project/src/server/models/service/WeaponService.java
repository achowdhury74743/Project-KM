package server.models.services;

import server.Logger;
import server.DatabaseConnection;
import server.models.Weapon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WeaponService {

    public static String selectAllInto(List<Weapon> targetList) {
        targetList.clear();
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT WeaponID, WeaponName, AttackValue, CriticalChance, CriticalMultilpier, UnlockLevel FROM Weapon"
            );
            if (statement != null) {
                ResultSet results = statement.executeQuery();
                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Weapon(results.getInt("WeaponID"), results.getString("WeaponName"), results.getInt("AttackValue"), results.getFloat("CriticalChance"), results.getFloat("CriticalMultilpier"), results.getInt("UnlockLevel")));


                    }
                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select all from 'Weapon' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
        return "OK";
    }

    public static Weapon selectById(int id) {
        Weapon result = null;
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "SELECT WeaponID, WeaponName, AttackValue, CriticalChance, CriticalMultilpier, UnlockLevel FROM Weapon WHERE WeaponID = ?"
            );
            if (statement != null) {
                statement.setInt(1, id);
                ResultSet results = statement.executeQuery();
                if (results != null && results.next()) {
                    result = new Weapon(results.getInt("WeaponID"), results.getString("WeaponName"), results.getInt("AttackValue"), results.getFloat("CriticalChance"), results.getFloat("CriticalMultilpier"), results.getInt("UnlockLevel"));


                }
            }
        } catch (SQLException resultsException) {
            String error = "Database error - can't select by id from 'Weapon' table: " + resultsException.getMessage();

            Logger.log(error);
        }
        return result;
    }

    public static String insert(Weapon itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "INSERT INTO Weapon (WeaponID, WeaponName, AttackValue, CriticalChance, CriticalMultilpier, UnlockLevel) VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setInt(1, itemToSave.getWeapon_ID());
            statement.setString(2, itemToSave.getWeapon_name());
            statement.setInt(3, itemToSave.getAttack_value());
            statement.setFloat(4, itemToSave.getCritical_chance());
            statement.setFloat(5, itemToSave.getCritical_multiplier());
            statement.setInt(6, itemToSave.getUnlock_level());










            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't insert into 'Weapon' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

    public static String update(Weapon itemToSave) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "UPDATE Weapon SET WeaponName = ?, AttackValue = ?, CriticalChance = ?, CriticalMultilpier = ?, UnlockLevel = ? WHERE WeaponID = ?"
            );
            statement.setString(1, itemToSave.getWeapon_name());
            statement.setInt(2, itemToSave.getAttack_value());
            statement.setFloat(3, itemToSave.getCritical_chance());
            statement.setFloat(4, itemToSave.getCritical_multiplier());
            statement.setInt(5, itemToSave.getUnlock_level());










            statement.setInt(6, itemToSave.getWeapon_ID());
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't update 'Weapon' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

    public static String deleteById(int id) {
        try {
            PreparedStatement statement = DatabaseConnection.newStatement(
                    "DELETE FROM Weapon WHERE WeaponID = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
            return "OK";
        } catch (SQLException resultsException) {
            String error = "Database error - can't delete by id from 'Weapon' table: " + resultsException.getMessage();

            Logger.log(error);
            return error;
        }
    }

}