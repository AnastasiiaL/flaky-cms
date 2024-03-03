package nl.cms.domain.enums;

public enum UNumber {
    TEN("10", "10", 10),
    TWENTY("20", "20", 20);

    private final String value;
    private final String description;
    private final int number;

    UNumber(String value, String description, int number) {
        this.value = value;
        this.description = description;
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }
}
