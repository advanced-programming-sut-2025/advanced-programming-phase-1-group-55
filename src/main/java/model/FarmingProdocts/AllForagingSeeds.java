package model.FarmingProdocts;

import enums.Seasons;
import model.Item.ItemType;

import java.util.Objects;

public enum AllForagingSeeds implements Seed {
    BLUE_JAZZ_SEEDS("Jazz Seeds", Seasons.spring, 0,ItemType.JAZZ_SEEDS),
    CARROT_SEEDS("Carrot Seeds", Seasons.spring, 1,ItemType.CARROT_SEEDS),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", Seasons.spring, 2,ItemType.CAULIFLOWER_SEEDS),
    COFFEE_BEAN("Coffee Bean", Seasons.spring, 3,ItemType.COFFEE_BEANS),
    GARLIC_SEEDS("Garlic Seeds", Seasons.spring, 4,ItemType.GARLIC_SEEDS),
    BEAN_STARTER("Bean Starter", Seasons.spring, 5,ItemType.BEAN_STARTER),
    KALE_SEEDS("Kale Seeds", Seasons.spring, 6,ItemType.KALE_SEEDS),
    PARSNIP_SEEDS("Parsnip Seeds", Seasons.spring, 7,ItemType.PARSNIP_SEEDS),
    POTATO_SEEDS("Potato Seeds", Seasons.spring, 8,ItemType.POTATO_SEEDS),
    RHUBARB_SEEDS("Rhubarb Seeds", Seasons.spring, 9,ItemType.RHUBARB_SEEDS),
    STRAWBERRY_SEEDS("Strawberry Seeds", Seasons.spring, 10,ItemType.STRAWBERRY_SEEDS),
    TULIP_BULB("Tulip Bulb", Seasons.spring, 11,ItemType.TULIP_BULB),
    RICE_SHOOT("Rice Shoot", Seasons.spring, 12,ItemType.RICE_SHOOT),
    BLUEBERRY_SEEDS("Blueberry Seeds", Seasons.summer, 13,ItemType.BLUEBERRY_SEEDS),
    CORN_SEEDS("Corn Seeds", Seasons.summer, 14,ItemType.CORN_SEEDS),
    HOPS_STARTER("Hops Starter", Seasons.summer, 15,ItemType.HOPS_STARTER),
    PEPPER_SEEDS("Pepper Seeds", Seasons.summer, 16,ItemType.PEPPER_SEEDS),
    MELON_SEEDS("Melon Seeds", Seasons.summer, 17,ItemType.MELON_SEEDS),
    POPPY_SEEDS("Poppy Seeds", Seasons.summer, 18,ItemType.POPPY_SEEDS),
    RADISH_SEEDS("Radish Seeds", Seasons.summer, 19,ItemType.RADISH_SEEDS),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", Seasons.summer, 20,ItemType.RED_CABBAGE_SEEDS),
    STARFRUIT_SEEDS("Starfruit Seeds", Seasons.summer, 21,ItemType.STARFRUIT_SEEDS),
    SPANGLE_SEEDS("Spangle Seeds", Seasons.summer, 22,ItemType.SPANGLE_SEEDS),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", Seasons.summer, 23,ItemType.SUMMER_SQUASH_SEEDS),
    SUNFLOWER_SEEDS("Sunflower Seeds", Seasons.summer, 24,ItemType.SUNFLOWER_SEEDS),
    TOMATO_SEEDS("Tomato Seeds", Seasons.summer, 25,ItemType.TOMATO_SEEDS),
    WHEAT_SEEDS("Wheat Seeds", Seasons.summer, 26,ItemType.WHEAT_SEEDS),
    AMARANTH_SEEDS("Amaranth Seeds", Seasons.fall, 27,ItemType.AMARANTH_SEEDS),
    ARTICHOKE_SEEDS("Artichoke Seeds", Seasons.fall, 28,ItemType.ARTICHOKE_SEEDS),
    BEET_SEEDS("Beet Seeds", Seasons.fall, 29,ItemType.BEET_SEEDS),
    BOK_CHOYS_SEEDS("Bok Choy Seeds", Seasons.fall, 30,ItemType.BOK_CHOY_SEEDS),
    BROCCOLI_SEEDS("Broccoli Seeds", Seasons.fall, 31,ItemType.BROCCOLI_SEEDS),
    CRANBERRY_SEEDS("Cranberry Seeds", Seasons.fall, 32,ItemType.CRANBERRY_SEEDS),
    EGGPLANT_SEEDS("Eggplant Seeds", Seasons.fall, 33,ItemType.EGGPLANT_SEEDS),
    FAIRY_SEEDS("Fairy Seeds", Seasons.fall, 34,ItemType.FAIRY_SEEDS),
    GRAPE_STARTER("Grape Starter", Seasons.fall, 35,ItemType.GRAPE_STARTER),
    PUMPKIN_SEEDS("Pumpkin Seeds", Seasons.fall, 36,ItemType.PUMPKIN_SEEDS),
    YAM_SEEDS("Yam Seeds", Seasons.fall, 37,ItemType.YAM_SEEDS),
    RARE_SEED("Rare Seed", Seasons.fall, 38,ItemType.RARE_SEED),
    POWDERMELON_SEEDS("Powdermelon Seeds", Seasons.winter, 39,ItemType.POWDERMELON_SEEDS),
    ANCIENT_SEEDS("Ancient Seeds", Seasons.special, 40,ItemType.ANCIENT_SEED);

    private final String name;
    private final Seasons season;
    private final int id;
    private final ItemType itemType;

    AllForagingSeeds(String name, Seasons season, int id,ItemType itemType) {
        this.name = name;
        this.season = season;
        this.id = id;
        this.itemType=itemType;
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

    public ItemType getItemType() {
        return itemType;
    }
}
