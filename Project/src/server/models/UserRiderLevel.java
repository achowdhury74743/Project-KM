package server.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class UserRiderLevel {
    private int userID;
    private int riderID;
    private int riderlevel;
    private int riderEXP;
    private int riderEXPtonextlevel;

    public UserRiderLevel(int userID, int riderID, int riderlevel, int riderEXP, int riderEXPtonextlevel) {
        this.userID = userID;
        this.riderID = riderID;
        this.riderlevel = riderlevel;
        this.riderEXP = riderEXP;
        this.riderEXPtonextlevel = riderEXPtonextlevel;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRiderID() {
        return riderID;
    }

    public void setRiderID(int riderID) {
        this.riderID = riderID;
    }

    public int getRiderlevel() {
        return riderlevel;
    }

    public void setRiderlevel(int riderlevel) {
        this.riderlevel = riderlevel;
    }

    public int getRiderEXP() {
        return riderEXP;
    }

    public void setRiderEXP(int riderEXP) {
        this.riderEXP = riderEXP;
    }

    public int getRiderEXPtonextlevel() {
        return riderEXPtonextlevel;
    }

    public void setRiderEXPtonextlevel(int riderEXPtonextlevel) {
        this.riderEXPtonextlevel = riderEXPtonextlevel;
    }

    public static ArrayList<UserRiderLevel> getUserriderlevels() {
        return userriderlevels;
    }

    public static void setUserriderlevels(ArrayList<UserRiderLevel> userriderlevels) {
        UserRiderLevel.userriderlevels = userriderlevels;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static ArrayList<UserRiderLevel> userriderlevels = new ArrayList<UserRiderLevel>();

    public static int nextId() {
        int id = 0;
        for (UserRiderLevel u: userriderlevels) {
            if (u.getUserID() > id) {
                id = u.getUserID();
            }
        }
        return id + 1;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("user_ID", getUserID());
        j.put("rider_ID", getRiderID());
        j.put("rider_level", getRiderlevel());
        j.put("rider_EXP", getRiderEXP());
        j.put("rider_EXP_to_next_level", getRiderEXPtonextlevel());











        return j;
    }
}