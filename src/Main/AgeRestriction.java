package Main;
public enum AgeRestriction {
    NONE(0),
    TEENAGER(13),
    ADULT(18);

    private int value;

    AgeRestriction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
