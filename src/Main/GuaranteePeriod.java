package Main;
public enum GuaranteePeriod {
    COMPUTER(24),
    APPLIANCE(6);

    private int value;

    GuaranteePeriod(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
