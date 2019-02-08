package server.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Entity {
    private int entity_ID;
    private String entity_name;
    private int entity_health;
    private int entity_defence;
    private int weapon_id;
    private int death_exp;
    private int unlock_level;
    private float level_stat_modifier;
    private float character_level_stat_modifier;
    private int next_armour_level_multiplier;







    // Get IntelliJ to auto-generate a constructor, getter and setters here:

    public Entity(int entity_ID, String entity_name, int entity_health, int entity_defence, int weapon_id, int death_exp, int unlock_level, float level_stat_modifier, float character_level_stat_modifier, int next_armour_level_multiplier) {
        this.entity_ID = entity_ID;
        this.entity_name = entity_name;
        this.entity_health = entity_health;
        this.entity_defence = entity_defence;
        this.weapon_id = weapon_id;
        this.death_exp = death_exp;
        this.unlock_level = unlock_level;
        this.level_stat_modifier = level_stat_modifier;
        this.character_level_stat_modifier = character_level_stat_modifier;
        this.next_armour_level_multiplier = next_armour_level_multiplier;
    }

    public int getEntity_ID() {
        return entity_ID;
    }

    public void setEntity_ID(int entity_ID) {
        this.entity_ID = entity_ID;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public int getEntity_health() {
        return entity_health;
    }

    public void setEntity_health(int entity_health) {
        this.entity_health = entity_health;
    }

    public int getEntity_defence() {
        return entity_defence;
    }

    public void setEntity_defence(int entity_defence) {
        this.entity_defence = entity_defence;
    }

    public int getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(int weapon_id) {
        this.weapon_id = weapon_id;
    }

    public int getDeath_exp() {
        return death_exp;
    }

    public void setDeath_exp(int death_exp) {
        this.death_exp = death_exp;
    }

    public int getUnlock_level() {
        return unlock_level;
    }

    public void setUnlock_level(int unlock_level) {
        this.unlock_level = unlock_level;
    }

    public float getLevel_stat_modifier() {
        return level_stat_modifier;
    }

    public void setLevel_stat_modifier(float level_stat_modifier) {
        this.level_stat_modifier = level_stat_modifier;
    }

    public float getCharacter_level_stat_modifier() {
        return character_level_stat_modifier;
    }

    public void setCharacter_level_stat_modifier(float character_level_stat_modifier) {
        this.character_level_stat_modifier = character_level_stat_modifier;
    }

    public int getNext_armour_level_multiplier() {
        return next_armour_level_multiplier;
    }

    public void setNext_armour_level_multiplier(int next_armour_level_multiplier) {
        this.next_armour_level_multiplier = next_armour_level_multiplier;
    }

    public static ArrayList<Entity> getEntitys() {
        return entitys;
    }

    public static void setEntitys(ArrayList<Entity> entitys) {
        Entity.entitys = entitys;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static ArrayList<Entity> entitys = new ArrayList<Entity>();

    public static int nextId() {
        int id = 0;
        for (Entity e: entitys) {
            if (e.getEntity_ID() > id) {
                id = e.getEntity_ID();
            }
        }
        return id + 1;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("entity_ID", getEntity_ID());
        j.put("entity_name", getEntity_name());
        j.put("entity_health", getEntity_health());
        j.put("entity_defence", getEntity_defence());
        j.put("weapon_id", getWeapon_id());
        j.put("death_exp", getDeath_exp());
        j.put("unlock_level", getUnlock_level());
        j.put("level_stat_modifier", getLevel_stat_modifier());
        j.put("character_level_stat_modifier", getCharacter_level_stat_modifier());
        j.put("next_armour_level_multiplier", getNext_armour_level_multiplier());






        return j;
    }
}