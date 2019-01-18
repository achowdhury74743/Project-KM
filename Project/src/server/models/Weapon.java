package server.models;

public class Weapon {
    private int id;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;

    // Get IntelliJ to auto-generate a constructor, getter and setters here:

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static ArrayList<Weapon> weapons = new ArrayList<>();

    public static int nextId() {
        int id = 0;
        for (Weapon w: weapons) {
            if (w.getId() > id) {
                id = w.getId();
            }
        }
        return id + 1;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("id", getId());
        j.put("a", getA());
        j.put("b", getB());
        j.put("c", getC());
        j.put("d", getD());
        j.put("e", getE());
        j.put("f", getF());
        j.put("g", getG());
        j.put("h", getH());
        j.put("i", getI());
        j.put("j", getJ());
        j.put("k", getK());
        j.put("l", getL());
        j.put("m", getM());
        j.put("n", getN());
        j.put("o", getO());
        return j;
    }
}