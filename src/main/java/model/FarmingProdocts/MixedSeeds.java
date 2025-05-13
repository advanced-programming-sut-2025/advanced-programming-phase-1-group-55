package model.FarmingProdocts;

import enums.Seasons;

public enum MixedSeeds implements Seed {
    JAZZ_SEEDS("Jazz Seeds", Seasons.spring),
    CARROT_SEEDS("Carrot Seeds", Seasons.spring),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", Seasons.spring),
    COFFEE_BEAN("Coffee Bean", Seasons.spring),
    GARLIC_SEEDS("Garlic Seeds", Seasons.spring),
    BEAN_STARTER("Bean Starter", Seasons.spring),
    KALE_SEEDS("Kale Seeds", Seasons.spring),
    PARSNIP_SEEDS("Parsnip Seeds", Seasons.spring),
    POTATO_SEEDS("Potato Seeds", Seasons.spring),
    RHUBARB_SEEDS("Rhubarb Seeds", Seasons.spring),
    STRAWBERRY_SEEDS("Strawberry Seeds", Seasons.spring),
    TULIP_BULB("Tulip Bulb", Seasons.spring),
    RICE_SHOOT("Rice Shoot", Seasons.spring),
    BLUEBERRY_SEEDS("Blueberry Seeds", Seasons.summer),
    CORN_SEEDS("Corn Seeds", Seasons.summer),
    HOPS_STARTER("Hops Starter", Seasons.summer),
    PEPPER_SEEDS("Pepper Seeds", Seasons.summer),
    MELON_SEEDS("Melon Seeds", Seasons.summer),
    POPPY_SEEDS("Poppy Seeds", Seasons.summer),
    RADISH_SEEDS("Radish Seeds", Seasons.summer),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds", Seasons.summer),
    STARFRUIT_SEEDS("Starfruit Seeds", Seasons.summer),
    SPANGLE_SEEDS("Spangle Seeds", Seasons.summer),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", Seasons.summer),
    SUNFLOWER_SEEDS("Sunflower Seeds", Seasons.summer),
    TOMATO_SEEDS("Tomato Seeds", Seasons.summer),
    WHEAT_SEEDS("Wheat Seeds", Seasons.summer),
    AMARANTH_SEEDS("Amaranth Seeds", Seasons.fall),
    ARTICHOKE_SEEDS("Artichoke Seeds", Seasons.fall),
    BEET_SEEDS("Beet Seeds", Seasons.fall),
    BOK_CHOY_SEEDS("Bok Choy Seeds", Seasons.fall),
    BROCCOLI_SEEDS("Broccoli Seeds", Seasons.fall),
    CRANBERRY_SEEDS("Cranberry Seeds", Seasons.fall),
    EGGPLANT_SEEDS("Eggplant Seeds", Seasons.fall),
    FAIRY_SEEDS("Fairy Seeds", Seasons.fall),
    GRAPE_STARTER("Grape Starter", Seasons.fall),
    PUMPKIN_SEEDS("Pumpkin Seeds", Seasons.fall),
    YAM_SEEDS("Yam Seeds", Seasons.fall),
    RARE_SEED("Rare Seed", Seasons.fall),
    POWDERMELON_SEEDS("Powdermelon Seeds", Seasons.winter),
    ANCIENT_SEEDS("Ancient Seeds", Seasons.special),
    MIXED_SEEDS("Mixed Seeds", Seasons.special);

    private final String name;
    private final Seasons season;

    MixedSeeds(String name, Seasons season) {
        this.name = name;
        this.season = season;
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
}
