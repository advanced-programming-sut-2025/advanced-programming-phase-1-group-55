package model.FarmingProdocts;

public enum AllForagingSeeds implements Seed {
    BLUE_JAZZ_SEEDS("Jazz Seeds", "Spring", 0),
    CARROT_SEEDS("Carrot Seeds", "Spring", 1),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", "Spring", 2),
    COFFEE_BEAN("Coffee Bean", "Spring", 3),
    GARLIC_SEEDS("Garlic Seeds", "Spring", 4),
    BEAN_STARTER("Bean Starter", "Spring", 5),
    KALE_SEEDS("Kale Seeds", "Spring", 6),
    PARSNIP_SEEDS("Parsnip Seeds", "Spring", 7),
    POTATO_SEEDS("Potato Seeds", "Spring", 8),
    RHUBARB_SEEDS("Rhubarb Seeds", "Spring", 9),
    STRAWBERRY_SEEDS("Strawberry Seeds", "Spring", 10),
    TULIP_BULB("Tulip Bulb", "Spring", 11),
    RICE_SHOOT("Rice Shoot", "Spring", 12),
    BLUEBERRY_SEEDS("Blueberry Seeds", "Summer", 13),
    CORN_SEEDS("Corn Seeds", "Summer", 14),
    HOPS_STARTER("Hops Starter", "Summer", 15),
    PEPPER_SEEDS("Pepper Seeds", "Summer", 16),
    MELON_SEEDS("Melon Seeds", "Summer", 17),
    POPPY_SEEDS("Poppy Seeds", "Summer", 18),
    RADISH_SEEDS("Radish Seeds", "Summer", 19),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", "Summer", 20),
    STARFRUIT_SEEDS("Starfruit Seeds", "Summer", 21),
    SPANGLE_SEEDS("Spangle Seeds", "Summer", 22),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", "Summer", 23),
    SUNFLOWER_SEEDS("Sunflower Seeds", "Summer", 24),
    TOMATO_SEEDS("Tomato Seeds", "Summer", 25),
    WHEAT_SEEDS("Wheat Seeds", "Summer", 26),
    AMARANTH_SEEDS("Amaranth Seeds", "Fall", 27),
    ARTICHOKE_SEEDS("Artichoke Seeds", "Fall", 28),
    BEET_SEEDS("Beet Seeds", "Fall", 29),
    BOK_CHOYS_SEEDS("Bok Choy Seeds", "Fall", 30),
    BROCCOLI_SEEDS("Broccoli Seeds", "Fall", 31),
    CRANBERRY_SEEDS("Cranberry Seeds", "Fall", 32),
    EGGPLANT_SEEDS("Eggplant Seeds", "Fall", 33),
    FAIRY_SEEDS("Fairy Seeds", "Fall", 34),
    GRAPE_STARTER("Grape Starter", "Fall", 35),
    PUMPKIN_SEEDS("Pumpkin Seeds", "Fall", 36),
    YAM_SEEDS("Yam Seeds", "Fall", 37),
    RARE_SEED("Rare Seed", "Fall", 38),
    POWDERMELON_SEEDS("Powdermelon Seeds", "Winter", 39),
    ANCIENT_SEEDS("Ancient Seeds", "Special", 40),
    FORAGING_SEEDS("Foraging Seeds", "Special", 41);

    private final String name;
    private final String season;
    private final int id;

    AllForagingSeeds(String name, String season, int id) {
        this.name = name;
        this.season = season;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return name;
    }

    public static AllForagingSeeds fromId(int id) {
        for (AllForagingSeeds seed : values()) {
            if (seed.getId() == id) {
                return seed;
            }
        }
        throw new IllegalArgumentException("Invalid seed ID: " + id);
    }
}
