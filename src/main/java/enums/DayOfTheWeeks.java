package enums;

public enum DayOfTheWeeks {
    saturday(0, "saturday"), sunday(1, "sunday"), monday(2, "sunday"), tuesday(3, "tuesday"), wednesday(4, "wednesday"), thursday(5, "thursday"), friday(6, "friday");
    private int valueOfDay;
    private String name;

    DayOfTheWeeks(int valueOfDay, String name) {
        this.name = name;
        this.valueOfDay = valueOfDay;
    }

    public int getValue() {
        return this.valueOfDay;
    }

    public DayOfTheWeeks getDayByValue(int value) {
        for (DayOfTheWeeks day : DayOfTheWeeks.values()) {
            if (day.getValue() == value) {
                return day;
            }
        }
        return null;
    }

    public int changeday() {
        return valueOfDay++;
    }
}
