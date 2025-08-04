package Package1;

public enum Gender {
    M("Male"),
    F("Female");

    private String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    //  7th 
    public static Gender fromChar(char c) {
        if (c == 'M' || c == 'm') {
            return M;
        } else if (c == 'F' || c == 'f') {
            return F;
        } else {
            throw new IllegalArgumentException("Invalid gender. Use 'M' or 'F'.");
        }
    }
}
