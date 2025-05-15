package model.FarmingProdocts;

import model.Item.ItemType;

public enum FruitType {
    Apricot("Apricot", ItemType.APRICOT,1, 59, true, 38,AllTrees.APRICOT_TREE)
    ,Cherry("Cherry", ItemType.CHERRY, 1, 80, true, 38,AllTrees.CHERRY_TREE)
    ,Banana("Banana", ItemType.BANANA, 1, 150, true, 75,AllTrees.BANANA_TREE)
    ,Mango("Mango", ItemType.MANGO, 1, 130, true, 100,AllTrees.MAHOGANY_TREE)
    ,Orange("Orange", ItemType.ORANGE, 1, 100, true, 38,AllTrees.ORANGE_TREE)
    ,Peach("Peach", ItemType.PEACH, 1, 140, true, 38,AllTrees.PEACH_TREE)
    ,Apple("Apple", ItemType.APPLE, 1, 100, true, 38,AllTrees.APPLE_TREE)
    ,Pomegranate("Pomegranate", ItemType.POMEGRANATE, 1, 140, true, 38,AllTrees.POMEGRANATE_TREE)
    ,OakResin("Oak Resin", ItemType.OAK_RESIN, 7, 150, false, 0,AllTrees.OAK_TREE)
    ,MapleSyrup("Maple Syrup", ItemType.MAPLE_SYRUP, 9, 200, false, 0,AllTrees.MAPLE_TREE)
    ,PineTar("Pine Tar", ItemType.PINE_TAR, 5, 100, false, 0,AllTrees.PINE_TREE)
    ,Sap("Sap", ItemType.SAP, 1, 2, true, -2,AllTrees.MAHOGANY_TREE)
    ,CommonMushroom("Common Mushroom", ItemType.COMMON_MUSHROOM, 1, 40, true, 38,AllTrees.MUSHROOM_TREE)
    ,MysticSyrup("Mystic Syrup", ItemType.MYSTIC_SYRUP, 7, 1000, true, 500,AllTrees.MYSTIC_TREE);


    private final String name;
    private final ItemType type;
    private final int fruitHarvestCycle;
    private final int fruitBaseSellPrice;
    private final boolean isFruitEdible;
    private final int fruitEnergy;
    private   final AllTrees tree;

    FruitType(String name, ItemType type, int fruitHarvestCycle, int fruitBaseSellPrice, boolean isFruitEdible, int fruitEnergy, AllTrees tree) {
        this.name = name;
        this.type = type;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.fruitBaseSellPrice = fruitBaseSellPrice;
        this.isFruitEdible = isFruitEdible;
        this.fruitEnergy = fruitEnergy;
        this.tree = tree;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public int getFruitHarvestCycle() {
        return fruitHarvestCycle;
    }

    public int getFruitBaseSellPrice() {
        return fruitBaseSellPrice;
    }

    public boolean isFruitEdible() {
        return isFruitEdible;
    }

    public int getFruitEnergy() {
        return fruitEnergy;
    }

    public AllTrees getTree() {
        return tree;
    }
}
