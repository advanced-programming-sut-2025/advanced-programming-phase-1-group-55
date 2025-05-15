package model.FarmingProdocts;

import enums.Seasons;
import model.Item.ItemType;

public enum AllForagingSeeds implements Seed {
    JAZZ_SEED(ItemType.JAZZ_SEEDS, Seasons.spring, 0),
    CARROT_SEEDS(ItemType.CARROT_SEEDS, Seasons.spring, 1),
    CAULIFLOWER_SEEDS(ItemType.CAULIFLOWER_SEEDS, Seasons.spring, 2),
    COFFEE_BEAN(ItemType.COFFEE_BEANS, Seasons.spring, 3),
    GARLIC_SEEDS(ItemType.GARLIC_SEEDS, Seasons.spring, 4),
    BEAN_STARTER(ItemType.BEAN_STARTER, Seasons.spring, 5),
    KALE_SEEDS(ItemType.KALE_SEEDS, Seasons.spring, 6),
    PARSNIP_SEEDS(ItemType.PARSNIP_SEEDS, Seasons.spring, 7),
    POTATO_SEEDS(ItemType.POTATO_SEEDS, Seasons.spring, 8),
    RHUBARB_SEEDS(ItemType.RHUBARB_SEEDS, Seasons.spring, 9),
    STRAWBERRY_SEEDS(ItemType.STRAWBERRY_SEEDS, Seasons.spring, 10),
    TULIP_BULB(ItemType.TULIP_BULB, Seasons.spring, 11),
    RICE_SHOOT(ItemType.RICE_SHOOT, Seasons.spring, 12),
    BLUEBERRY_SEEDS(ItemType.BLUEBERRY_SEEDS, Seasons.summer, 13),
    CORN_SEEDS(ItemType.CORN_SEEDS, Seasons.summer, 14),
    HOPS_STARTER(ItemType.HOPS_STARTER, Seasons.summer, 15),
    PEPPER_SEEDS(ItemType.PEPPER_SEEDS, Seasons.summer, 16),
    MELON_SEEDS(ItemType.MELON_SEEDS, Seasons.summer, 17),
    POPPY_SEEDS(ItemType.POPPY_SEEDS, Seasons.summer, 18),
    RADISH_SEEDS(ItemType.RADISH_SEEDS, Seasons.summer, 19),
    RED_CABBAGE_SEEDS(ItemType.RED_CABBAGE_SEEDS, Seasons.summer, 20),
    STARFRUIT_SEEDS(ItemType.STARFRUIT_SEEDS, Seasons.summer, 21),
    SPANGLE_SEEDS(ItemType.SPANGLE_SEEDS, Seasons.summer, 22),
    SUMMER_SQUASH_SEEDS(ItemType.SUMMER_SQUASH_SEEDS, Seasons.summer, 23),
    SUNFLOWER_SEEDS(ItemType.SUNFLOWER_SEEDS, Seasons.summer, 24),
    TOMATO_SEEDS(ItemType.TOMATO_SEEDS, Seasons.summer, 25),
    WHEAT_SEEDS(ItemType.WHEAT_SEEDS, Seasons.summer, 26),
    AMARANTH_SEEDS(ItemType.AMARANTH_SEEDS, Seasons.fall, 27),
    ARTICHOKE_SEEDS(ItemType.ARTICHOKE_SEEDS, Seasons.fall, 28),
    BEET_SEEDS(ItemType.BEET_SEEDS, Seasons.fall, 29),
    BOK_CHOYS_SEEDS(ItemType.BOK_CHOY_SEEDS, Seasons.fall, 30),
    BROCCOLI_SEEDS(ItemType.BROCCOLI_SEEDS, Seasons.fall, 31),
    CRANBERRY_SEEDS(ItemType.CRANBERRY_SEEDS, Seasons.fall, 32),
    EGGPLANT_SEEDS(ItemType.EGGPLANT_SEEDS, Seasons.fall, 33),
    FAIRY_SEEDS(ItemType.FAIRY_SEEDS, Seasons.fall, 34),
    GRAPE_STARTER(ItemType.GRAPE_STARTER, Seasons.fall, 35),
    PUMPKIN_SEEDS(ItemType.PUMPKIN_SEEDS, Seasons.fall, 36),
    YAM_SEEDS(ItemType.YAM_SEEDS, Seasons.fall, 37),
    RARE_SEED(ItemType.RARE_SEED, Seasons.fall, 38),
    POWDERMELON_SEEDS(ItemType.POWDERMELON_SEEDS, Seasons.winter, 39),
    ANCIENT_SEEDS(ItemType.ANCIENT_SEED, Seasons.special, 40);

    private final ItemType type;
    private final Seasons season;
    private final int id;

    AllForagingSeeds(ItemType type, Seasons season, int id) {
        this.type = type;
        this.season = season;
        this.id = id;
    }

    public int getId() {
        return id;
    }
//
//    @Override
//    public String getType() {
//        return type;
//    }
//
//    @Override
//    public Seasons getSeason() {
//        return season;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }


    public ItemType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public Seasons getSeason() {
        return season;
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
