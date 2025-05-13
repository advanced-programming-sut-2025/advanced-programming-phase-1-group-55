package model.FarmingProdocts;

public enum FruitType {
    Apricot("Apricot",1, 59, true, 38,AllTrees.APRICOT_TREE)
    ,Cherry("Cherry", 1, 80, true, 38,AllTrees.CHERRY_TREE)
    ,Banana("Banana", 1, 150, true, 75,AllTrees.BANANA_TREE)
    ,Mango("Mango", 1, 130, true, 100,AllTrees.MAHOGANY_TREE)
    ,Orange("Orange", 1, 100, true, 38,AllTrees.ORANGE_TREE)
    ,Peach("Peach", 1, 140, true, 38,AllTrees.PEACH_TREE)
    ,Apple("Apple", 1, 100, true, 38,AllTrees.APPLE_TREE)
    ,Pomegranate("Pomegranate", 1, 140, true, 38,AllTrees.POMEGRANATE_TREE)
    ,OakResin("Oak Resin", 7, 150, false, 0,AllTrees.OAK_TREE)
    ,MapleSyrup("Maple Syrup", 9, 200, false, 0,AllTrees.MAPLE_TREE)
    ,PineTar("Pine Tar", 5, 100, false, 0,AllTrees.PINE_TREE)
    ,Sap("Sap", 1, 2, true, -2,AllTrees.MAHOGANY_TREE)
    ,CommonMushroom("Common Mushroom", 1, 40, true, 38,AllTrees.MUSHROOM_TREE)
    ,MysticSyrup("Mystic Syrup", 7, 1000, true, 500,AllTrees.MYSTIC_TREE);
    private final String name;
    private final int fruitHarvestCycle;
    private final int fruitBaseSellPrice;
    private final boolean isFruitEdible;
    private final int fruitEnergy;
    private   final AllTrees tree;

    FruitType(String name, int fruitHarvestCycle, int fruitBaseSellPrice, boolean isFruitEdible, int fruitEnergy, AllTrees tree) {
        this.name = name;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.fruitBaseSellPrice = fruitBaseSellPrice;
        this.isFruitEdible = isFruitEdible;
        this.fruitEnergy = fruitEnergy;
        this.tree = tree;
    }

    public String getName() {
        return name;
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
