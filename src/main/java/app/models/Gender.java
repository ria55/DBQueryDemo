package app.models;

public enum Gender {

    WOMAN,
    MAN,
    UNKNOWN;

    public static Gender findGender(String gender) {
        for (Gender g : values()) {
            if (g.name().equalsIgnoreCase(gender)) {
                return g;
            }
        }
        return UNKNOWN;
    }

}
