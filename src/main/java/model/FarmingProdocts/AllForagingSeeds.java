package model.FarmingProdocts;

import enums.Seasons;

import java.util.Objects;

public enum AllForagingSeeds implements Seed {
    BLUE_JAZZ_SEEDS("Jazz Seeds", Seasons.spring, 0),
    CARROT_SEEDS("Carrot Seeds", Seasons.spring, 1),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", Seasons.spring, 2),
    COFFEE_BEAN("Coffee Bean", Seasons.spring, 3),
    GARLIC_SEEDS("Garlic Seeds", Seasons.spring, 4),
    BEAN_STARTER("Bean Starter", Seasons.spring, 5),
    KALE_SEEDS("Kale Seeds", Seasons.spring, 6),
    PARSNIP_SEEDS("Parsnip Seeds", Seasons.spring, 7),
    POTATO_SEEDS("Potato Seeds", Seasons.spring, 8),
    RHUBARB_SEEDS("Rhubarb Seeds", Seasons.spring, 9),
    STRAWBERRY_SEEDS("Strawberry Seeds", Seasons.spring, 10),
    TULIP_BULB("Tulip Bulb", Seasons.spring, 11),
    RICE_SHOOT("Rice Shoot", Seasons.spring, 12),
    BLUEBERRY_SEEDS("Blueberry Seeds", Seasons.summer, 13),
    CORN_SEEDS("Corn Seeds", Seasons.summer, 14),
    HOPS_STARTER("Hops Starter", Seasons.summer, 15),
    PEPPER_SEEDS("Pepper Seeds", Seasons.summer, 16),
    MELON_SEEDS("Melon Seeds", Seasons.summer, 17),
    POPPY_SEEDS("Poppy Seeds", Seasons.summer, 18),
    RADISH_SEEDS("Radish Seeds", Seasons.summer, 19),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", Seasons.summer, 20),
    STARFRUIT_SEEDS("Starfruit Seeds", Seasons.summer, 21),
    SPANGLE_SEEDS("Spangle Seeds", Seasons.summer, 22),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", Seasons.summer, 23),
    SUNFLOWER_SEEDS("Sunflower Seeds", Seasons.summer, 24),
    TOMATO_SEEDS("Tomato Seeds", Seasons.summer, 25),
    WHEAT_SEEDS("Wheat Seeds", Seasons.summer, 26),
    AMARANTH_SEEDS("Amaranth Seeds", Seasons.fall, 27),
    ARTICHOKE_SEEDS("Artichoke Seeds", Seasons.fall, 28),
    BEET_SEEDS("Beet Seeds", Seasons.fall, 29),
    BOK_CHOYS_SEEDS("Bok Choy Seeds", Seasons.fall, 30),
    BROCCOLI_SEEDS("Broccoli Seeds", Seasons.fall, 31),
    CRANBERRY_SEEDS("Cranberry Seeds", Seasons.fall, 32),
    EGGPLANT_SEEDS("Eggplant Seeds", Seasons.fall, 33),
    FAIRY_SEEDS("Fairy Seeds", Seasons.fall, 34),
    GRAPE_STARTER("Grape Starter", Seasons.fall, 35),
    PUMPKIN_SEEDS("Pumpkin Seeds", Seasons.fall, 36),
    YAM_SEEDS("Yam Seeds", Seasons.fall, 37),
    RARE_SEED("Rare Seed", Seasons.fall, 38),
    POWDERMELON_SEEDS("Powdermelon Seeds", Seasons.winter, 39),
    ANCIENT_SEEDS("Ancient Seeds", Seasons.special, 40),
    FORAGING_SEEDS("Foraging Seeds", Seasons.special, 41);

    private final String name;
    private final Seasons season;
    private final int id;

    AllForagingSeeds(String name, Seasons season, int id) {
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
    public Seasons getSeason() {
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

    public static AllForagingSeeds fromName(String name) {
        for (AllForagingSeeds seed : values()) {
            if (Objects.equals(seed.getName(), name)) {
                return seed;
            }
        }
        throw new IllegalArgumentException("Invalid seed name: " + name);
    }
}
