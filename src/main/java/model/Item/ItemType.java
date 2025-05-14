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

    FIBER("fiber"),

    FRIED_EGG("fried egg"),
    BAKED_FISH("baked fish"),
    SALAD("salad"),
    OMELET("omelet"),
    PUMPKIN_PIE("pumpkin pie"),
    SPAGHETTI("spaghetti"),
    PIZZA("pizza"),
    TORTILLA("tortilla"),
    MAKI_ROLL("maki roll"),
    TRIPLE_SHOT_ESPRESSO("triple shot espresso"),
    COOKIE("cookie"),
    PANCAKE("pancake"),
    FRUIT_SALAD("fruit salad"),
    RED_PLATE("red plate"),
    SALMON_DINNER("salmon dinner"),
    VEGETABLE_MEDLEY("vegetable medley"),
    FARMER_LUNCH("farmer's lunch"),
    SURVIVAL_BURGER("survival burger"),
    DISH_O_THE_SEA("dish O' the Sea"),
    SEAFORM_PUDDING("seaform pudding"),
    MINER_TREAT("miner's treat"),
    PANCAKES("pancakes"),
    HASH_BROWNS("hash browns"),
    FARMERS_LUNCH("farmers lunch"),
    SEAFOAM_PUDDING("seafoam pudding"),
    MINERS_TREAT("miners treat"),



    EGG("egg"),
    SARDINE("sardine"),
    SALMON("salmon"),
    WHEAT("wheat"),
    LEEK("leek"),
    DANDELION("dandelion"),
    MILK("milk"),
    PUMPKIN("pumpkin"),
    WHEAT_FLOWER("wheat flower"),
    TOMATO("tomato"),
    CHEESE("cheese"),
    CORN("corn"),
    RICE("rice"),
    COFFEE("coffee"),
    SUGAR("sugar"),
    POTATO("potato"),
    OIL("oil"),
    BLUEBERRY("blueberry"),
    MELON("melon"),
    APRICOT("apricot"),
    CHERRY("cherry"),
    BANANA("banana"),
    MANGO("mango"),
    ORANGE("orange"),
    PEACH("peach"),
    POMEGRANATE("pomegranate"),
    APPLE("apple"),
    OAK_RESIN("oak resin"),
    MAPLE_SYRUP("maple syrup"),
    PINE_TAR("pine tar"),
    SAP("sap"),
    COMMON_MUSHROOM("common mushroom"),
    MYSTIC_SYRUP("mystic syrup"),
    RED_CABBAGE("red cabbage"),
    RADISH("radish"),
    AMARANTH("amaranth"),
    KALE("kale"),
    BEET("beet"),
    PARSNIP("parsnip"),
    BREAD("bread"),
    CARROT("carrot"),
    EGGPLANT("eggplant"),
    HASH_BROWN("hash brown"),
    FLOUNDER("flounder"),
    WHEAT_FLOUR("wheat flour"),
    ANY_FISH("any fish"),
    MIDNIGHT_CARP("midnight carp");





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
