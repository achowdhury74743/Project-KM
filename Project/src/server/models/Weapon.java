package server.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Weapon {
    private int weapon_ID;
    private String weapon_name;
    private int attack_value;
    private float critical_chance;
    private float critical_multiplier;
    private int unlock_level;

    public Weapon(int weapon_ID, String weapon_name, int attack_value, float critical_chance, float critical_multiplier, int unlock_level) {
        this.weapon_ID = weapon_ID;
        this.weapon_name = weapon_name;
        this.attack_value = attack_value;
        this.critical_chance = critical_chance;
        this.critical_multiplier = critical_multiplier;
        this.unlock_level = unlock_level;
    }

    public int getWeapon_ID() {
        return weapon_ID;
    }

    public String getWeapon_name() {
        return weapon_name;
    }

    public int getAttack_value() {
        return attack_value;
    }

    public float getCritical_chance() {
        return critical_chance;
    }

    public float getCritical_multiplier() {
        return critical_multiplier;
    }

    public int getUnlock_level() {
        return unlock_level;
    }

    public void setWeapon_ID(int weapon_ID) {
        this.weapon_ID = weapon_ID;
    }

    public void setWeapon_name(String weapon_name) {
        this.weapon_name = weapon_name;
    }

    public void setAttack_value(int attack_value) {
        this.attack_value = attack_value;
    }

    public void setCritical_chance(float critical_chance) {
        this.critical_chance = critical_chance;
    }

    public void setCritical_multiplier(float critical_multiplier) {
        this.critical_multiplier = critical_multiplier;
    }

    public void setUnlock_level(int unlock_level) {
        this.unlock_level = unlock_level;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    public static int nextId() {
        int id = 0;
        for (Weapon w: weapons) {
            if (w.getWeapon_ID() > id) {
                id = w.getWeapon_ID();
            }
        }
        return id + 1;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("weapon_ID", getWeapon_ID());
        j.put("weapon_name", getWeapon_name());
        j.put("attack_value", getAttack_value());
        j.put("critical_chance", getCritical_chance());
        j.put("critical_multiplier", getCritical_multiplier());
        j.put("unlock_level", getUnlock_level());










        return j;
    }
}