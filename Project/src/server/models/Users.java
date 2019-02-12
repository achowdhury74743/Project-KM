package server.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Users {
    private int user_ID;
    private String username;
    private String password;
    private int level;
    private int exp_to_next_level;
    private int user_exp;

    public Users(int user_ID, String username, String password, int level, int exp_to_next_level, int user_exp) {
        this.user_ID = user_ID;
        this.username = username;
        this.password = password;
        this.level = level;
        this.exp_to_next_level = exp_to_next_level;
        this.user_exp = user_exp;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp_to_next_level() {
        return exp_to_next_level;
    }

    public void setExp_to_next_level(int exp_to_next_level) {
        this.exp_to_next_level = exp_to_next_level;
    }

    public int getUser_exp() {
        return user_exp;
    }

    public void setUser_exp(int user_exp) {
        this.user_exp = user_exp;
    }

    public static ArrayList<Users> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<Users> users) {
        Users.users = users;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static ArrayList<Users> users = new ArrayList<Users>();

    public static int nextId() {
        int id = 0;
        for (Users u: users) {
            if (u.getUser_ID() > id) {
                id = u.getUser_ID();
            }
        }
        return id + 1;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("user_ID", getUser_ID());
        j.put("username", getUsername());
        j.put("password", getPassword());
        j.put("level", getLevel());
        j.put("exp_to_next_level", getExp_to_next_level());
        j.put("user_exp", getUser_exp());










        return j;
    }
}