package model.Item;

import model.App;
import model.Map.Tile;

public enum ItemType {
    CHERRY_BOMB("Cherry Bomb"),
    BOMB("Bomb"),
    MEGA_BOMB("Mega Bomb"),
    SPRINKLER("Sprinkler"),
    QUALITY_SPRINKLER("Quality Sprinkler"),
    IRIDIUM_SPRINKLER("Iridium Sprinkler"),
    CHARCOAL_KILN("Charcoal Klin"),
    FURNACE("Furnace"),
    SCARECROW("Scarecrow"),
    DELUXE_SCARECROW("Deluxe Scarecrow"),
    BEE_HOUSE("Bee House"),
    CHEESE_PRESS("Cheese Press"),
    KEG("Keg"),
    LOOM("Loom"),
    MAYONNAISE_MACHINE("Mayonnaise Machine"),
    OIL_MAKER("Oil Maker"),
    PRESERVES_JAR("Preserves Jar"),
    DEHYDRATOR("Dehydrator"),
    GRASS_STARTER("Grass Starter"),
    FISH_SMOKER("Fish Smoker"),
    MYSTIC_TREE_SEED("Mystic Tree Seed"),

    QUARTZ("Quartz"),
    EARTH_CRYSTAL("Earth Crystal"),
    FROZEN_TEAR("Frozen Tear"),
    FIRE_QUARTZ("Fire Quartz"),
    EMERALD("Emerald"),
    AQUAMARINE("Aquamarine"),
    RUBY("Ruby"),
    AMETHYST("Amethyst"),
    TOPAZ("Topaz"),
    JADE("Jade"),
    DIAMOND("Diamond"),
    PRISMATIC_SHARD("Prismatic Shard"),
    COPPER("Copper"),
    IRON("Iron"),
    GOLD("Gold"),
    IRIDIUM("Iriduim"),
    COAL("Coal"),

    COPPER_ORE("copper ore"),
    IRON_ORE("iron ore"),
    GOLD_ORE("gold ore"),
    COPPER_BAR("copper bar"),
    IRON_BAR("iron bar"),
    GOLD_BAR("gold bar"),
    IRIDIUM_BAR("iridium bar"),
    WOOD("wood"),
    STONE("stone"),
    IRIDIUM_ORE("iridium ore"),
    ACORN("acorn"),
    MAPLE_SEED("maple seed"),
    PINE_CONE("pine cone"),
    MAHOGANY_SEED("mahogany seed"),

    FIBER("fiber");




    private final String DisplayName;

    ItemType(String DisplayName) {
        this.DisplayName = DisplayName;
    }

    @Override
    public String toString()
    {
        return DisplayName;
    }
    public static ItemType getItemType(String DisplayName)
    {
        for (ItemType itemType : ItemType.values())
        {
            if (itemType.DisplayName.equalsIgnoreCase(DisplayName))
            {
                return itemType;
            }
        }
        return null;
    }

    public String getDisplayName() {
        return DisplayName;
    }
}
