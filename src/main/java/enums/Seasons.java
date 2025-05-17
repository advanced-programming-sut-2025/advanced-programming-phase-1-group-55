package enums;

public enum Seasons {

    spring(0, "spring"), summer(1, "summer"), fall(2, "fall"), winter(3, "winter"),special(5,"special");
    private int value;
    private String name;

    Seasons(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Seasons getSeasonByValue(int value) {
        for (Seasons season : Seasons.values()) {
            if (season.getValue() == value) {
                return season;
            }
        }
        return null;
    }

    public Seasons nextSeason() {
        System.out.println("value : "+this.value);
        return getSeasonByValue((this.value + 1) % 4);
    }

}
